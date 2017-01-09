package action.memo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.memo.MemoDAO;
import model.memo.MemoDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		MemoDTO dto = new MemoDTO();
		request.setCharacterEncoding("utf-8");
		dto.setMemono(Integer.parseInt(request.getParameter("memono")));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		MemoDAO dao = new MemoDAO();
		boolean flag = dao.update(dto);
		request.setAttribute("flag", flag);
		return "/views/memo/updateProc.jsp";
	}

}
