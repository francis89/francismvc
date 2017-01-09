package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;
import model.member.MemberDTO;
import utility1.UploadSave;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(); 
		String id = request.getParameter("id");
		String grade = (String)session.getAttribute("grade");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.read(id);
		
		
		dto.setTel(request.getParameter("tel"));
		dto.setAddress1(request.getParameter("address1"));
		dto.setAddress2(request.getParameter("address2"));

		dto.setPasswd(request.getParameter("passwd"));
		dto.setEmail(request.getParameter("email"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setJob(request.getParameter("job"));
		
		boolean flag = dao.update(dto);
		
		request.setAttribute("flag", flag);
		request.setAttribute("dto", dto);
		request.setAttribute("id", id);
		request.setAttribute("grade", grade);
		
		return "/views/member/updateProc.jsp";
	}

}
