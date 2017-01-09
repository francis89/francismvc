package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;

public class IdProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();

		boolean flag = dao.duplicateId(id);

		request.setAttribute("flag", flag);
		request.setAttribute("id", id);

		return "/views/popup/id_proc.jsp";
	}

}
