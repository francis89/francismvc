package action.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.bbs.BbsDAO;
import model.bbs.BbsDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String col = request.getParameter("col");
		String word = request.getParameter("word");
		String nowPage = request.getParameter("nowPage");
		
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		BbsDAO dao = new BbsDAO();
		BbsDTO dto = dao.read(bbsno);
		int cnt = 0;
		/*조회수 증가*/
		dao.upViewcnt(bbsno);
		String content = dto.getContent();
		
		content = content.replaceAll("\r\n", "<br>");
		
		
		request.setAttribute("dto", dto);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("bbsno", bbsno);
		request.setAttribute("content", content);
		
		
		
		return "/views/bbs/read.jsp";
	}

}
