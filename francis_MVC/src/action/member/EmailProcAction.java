package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;

public class EmailProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String email = request.getParameter("email");
		MemberDAO dao = new MemberDAO();
		request.setCharacterEncoding("utf-8");
		
		boolean flag = dao.duplicateEmail(email);

		request.setAttribute("flag", flag);
		request.setAttribute("email", email);

		return "/views/popup/email_proc.jsp";
	}

}
