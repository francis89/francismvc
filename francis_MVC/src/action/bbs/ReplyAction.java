package action.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.bbs.BbsDAO;
import model.bbs.BbsDTO;

public class ReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		BbsDAO dao = new BbsDAO();
		BbsDTO dto = dao.readReply(bbsno);
		String col = request.getParameter("col");
		String word = request.getParameter("word");
		String nowPage = request.getParameter("nowPage");
		
		request.setAttribute("dto", dto);		
		request.setAttribute("col", col);		
		request.setAttribute("word", word);		
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("bbsno", bbsno);
		
		return "/views/bbs/replyForm.jsp";
	}

}
