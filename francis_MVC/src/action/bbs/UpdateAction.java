package action.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.bbs.BbsDAO;
import model.bbs.BbsDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8"); 
		
		BbsDTO dto = new BbsDTO();
		BbsDAO dao = new BbsDAO();
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		
		dto = dao.read(bbsno);
		request.setAttribute("dto", dto);
		
		return "/views/bbs/updateForm.jsp";
	}

}
