package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberDAO();
		
		if(id==null){
			id = (String)session.getAttribute("id");
		}
		String oldfile = dao.getFname(id);
		
		request.setAttribute("id", id);
		request.setAttribute("oldfile", oldfile);
		
		return "/views/member/deleteForm.jsp";
	}

}
