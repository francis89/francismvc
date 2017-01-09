package action.imgbbs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.imgbbs.ImgbbsDAO;
import model.imgbbs.ImgbbsDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String col = request.getParameter("col");
		String word = request.getParameter("word");
		String nowPage = request.getParameter("nowPage");
		
		int cnt = 0;
		/*조회수 증가*/
		ImgbbsDAO dao = new ImgbbsDAO();
		dao.upViewcnt(no);
		ImgbbsDTO dto = dao.read(no);
		String content = dto.getContent();
		
		content = content.replaceAll("\r\n", "<br>");
		
		List ilist = dao.imgRead(no);
		String[] files = (String[])ilist.get(0);
		int[] noArr = (int[])ilist.get(1);
		
		request.setAttribute("files", files);
		request.setAttribute("noArr", noArr);
		request.setAttribute("dto", dto);
		request.setAttribute("no", no);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("content", content);
		return "/views/imgbbs/read.jsp";
	}

}
