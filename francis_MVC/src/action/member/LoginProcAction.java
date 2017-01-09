package action.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;

public class LoginProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		MemberDAO dao = new MemberDAO();
		request.setCharacterEncoding("utf-8");
		
		/*중요*/
		HttpSession session = request.getSession();
		
		boolean flag = dao.loginCheck(id,passwd);
		String grade = null;//회원 등급
		if(flag){
			grade = dao.getGrade(id);
			session.setAttribute("id", id);
			session.setAttribute("grade", grade);
			 // ---------------------------------------------- 
		    // Cookie 저장, Checkbox는 선택하지 않으면 null 임 
		    // ---------------------------------------------- 
			 Cookie cookie = null; 
			       
			 String c_id = request.getParameter("c_id"); // Y, 아이디 저장 여부 
			       
			 if (c_id != null){  // 처음에는 값이 없음으로 null 체크로 처리
			      cookie = new Cookie("c_id", "Y");    // 아이디 저장 여부 쿠키 
			      cookie.setMaxAge(120);               // 2 분 유지 
			      response.addCookie(cookie);          // 쿠키 기록 
			   
			      cookie = new Cookie("c_id_val", id); // 아이디 값 저장 쿠키  
			      cookie.setMaxAge(120);               // 2 분 유지 
			      response.addCookie(cookie);          // 쿠키 기록  
			         
			 }else{ 
			 	    cookie = new Cookie("c_id", "");     // 쿠키 삭제 
			    	cookie.setMaxAge(0); 
			      	response.addCookie(cookie); 
			         
			      	cookie = new Cookie("c_id_val", ""); // 쿠키 삭제 
			      	cookie.setMaxAge(0); 
			      	response.addCookie(cookie); 
			  } 
			    // --------------------------------------------- 
		 
		    
		}
		request.setAttribute("flag", flag);
		
		return "/views/member/loginProc.jsp";
	}

}
