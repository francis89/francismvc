package action.memo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.memo.MemoDAO;
import model.memo.MemoDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int memono = Integer.parseInt(request.getParameter("memono"));
		MemoDAO dao = new MemoDAO();
		MemoDTO dto = dao.read(memono);
		
		request.setAttribute("dto", dto);
		
		return "/views/memo/updateForm.jsp";
	}

}
