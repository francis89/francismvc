package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import model.member.MemberDAO;
import utility1.UploadSave;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String upDir = request.getRealPath("/views/member/storage");
		String tempDir = request.getRealPath("/views/member/temp");
		MemberDAO dao = new MemberDAO();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String oldfile = request.getParameter("oldfile");
		if(oldfile!=null && oldfile.equals("member.jpg")){
			oldfile = null;
		}
		
		boolean flag = dao.delete(id);
		if(flag){
			
			UploadSave.deleteFile(upDir, oldfile);
			session.invalidate();//그회원과 서버가 끊어지는것을 말한다.
		}
		
		request.setAttribute("flag", flag);
		
		return "/views/member/deleteProc.jsp";
	}

}
