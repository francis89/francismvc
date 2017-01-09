package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;
import model.member.MemberDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		HttpSession session = request.getSession();
		String grade = (String)session.getAttribute("grade");

		String col = request.getParameter("col");
		String word = request.getParameter("word");
		String nowPage = request.getParameter("nowPage");
		
		
		
		if(id==null){	// 관리자가 아닐때
			id = (String)session.getAttribute("id");
		}
		MemberDAO dao = new MemberDAO();
		MemberDTO dto =dao.read(id);
		
		request.setAttribute("dto", dto);
		request.setAttribute("id", id);
		request.setAttribute("grade", grade);
//		request.setAttribute("col", col);
//		request.setAttribute("word", word);
//		request.setAttribute("nowPage", nowPage);
		
		return "/views/member/read.jsp";
	}

}
