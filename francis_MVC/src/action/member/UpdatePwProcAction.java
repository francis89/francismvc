package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.member.MemberDAO;

public class UpdatePwProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		MemberDAO dao = new MemberDAO();
		
		boolean flag = dao.updatePw(id, passwd);
		request.setAttribute("flag", flag);
		
		
		return "/views/member/updatePwProc.jsp";
	}

}
