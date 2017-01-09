package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.NullAction;
import action.Action;

public class Controller extends HttpServlet {
	// template사용여부 결정
	private boolean usingTemplate = false;
	// template페이지 경로
	private String templatePage = null;
	// 요청를 분석한 값과 매핑되는 Action 객체를 담는다.
	private Map commandHandlerMap = new java.util.HashMap();

	public void init(ServletConfig config) throws ServletException {
		// <param-value>F:/rfid02/mvc/workspace/mvc_board/WebContent/WEB-INF/config/action-config.properties</param-value>
		String configFile = config.getInitParameter("configFile");

		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configFile);
			// 속성 파일을 객체로 로딩
			// 키와 문자열 값으로 저장됩니다.
			prop.load(fis);
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}

		// properties 객체에서 키목록을 추출합니다.
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			// 하나의 키를 추출합니다.
			/// pilot/mvc/basic/hello.do
			String command = (String) keyIter.next();
			System.out.println("command: " + command);

			// 추출된 키에 해당하는 값을 가져옵니다.
			// mvctem.command.HelloHandler
			String handlerClassName = prop.getProperty(command);
			System.out.println("handlerClassName: " + handlerClassName);

			try {
				// 클래스를 JVM으로 로딩합니다.
				// mvctem.command.HelloHandler 클래스의 소스를 읽어 들입니다.
				Class handlerClass = Class.forName(handlerClassName);

				// 읽어들인 클래의 객체를 생성합니다.
				Object handlerInstance = handlerClass.newInstance();

				// MAP에 키와 각 클래스별 객체가 저장합니다.
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
		// 템플릿 파일을 web.xml파일로 부터 읽어 옵니다. template.jsp
		templatePage = config.getInitParameter("templatePage");
		// 템플릿 파일이 있다면 usingTemplate변수에 "true"를 할당합니다.
		if (templatePage != null && !templatePage.equals("")) {
			usingTemplate = true; // 템플릿 페이지 존재
		}
	}

	// Form Method GET일 경우
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	// Form Method POST일 경우
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// 비즈니스 로직 호출 처리
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Client가 요청한 URI주소
		String command = request.getRequestURI();
		System.out.println("RequestURI: " + request.getRequestURI());

		// 주소가 /www_mvc로 시작하는지 검사
		// context root로 시작하면 context root 문자열 제거
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
			System.out.println("command: " + command);
		}

		// 주어진 URL에 해당하는 핸들러 클래스가 존재하는지 검색
		// pilot/mvc/basic/hello.do=mvctem.command.HelloHandler
		Action action = (Action) commandHandlerMap.get(command);

		// 핸들러가 없는 경우
		if (action == null) {
			action = new NullAction();
		}

		String viewPage = null;
		try {
			// Model(Business Logic) 부분을 처리합니다.
			// Model부분이 처리된후에는 처리된 내용을 출력할
			// View 페이지가 리턴됩니다.
			viewPage = action.execute(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		
		if(viewPage.indexOf("/popup")!=-1){
			usingTemplate = false;
		}else{
			usingTemplate = true;
		}

		String forwardURI = templatePage;

		if (viewPage.indexOf("popup") != -1) {
			forwardURI = viewPage;
		}
		if (usingTemplate) {
			request.setAttribute("CONTENT_PAGE", viewPage);
		} else {
			forwardURI = viewPage;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURI);
		dispatcher.forward(request, response);
	}
}
