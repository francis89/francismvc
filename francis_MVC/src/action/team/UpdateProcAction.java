package action.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.team.TeamDAO;
import model.team.TeamDTO;
import utility1.UploadSave;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int no = Integer.parseInt(request.getParameter("no"));
		request.setCharacterEncoding("utf-8");
		String upDir = request.getRealPath("/views/team/storage");
		String tempDir = request.getRealPath("/views/team/temp");

		UploadSave upload = new UploadSave(request, -1, -1, tempDir);
		
		TeamDAO dao = new TeamDAO();
		TeamDTO dto = dao.read(no);
		
		dto.setPhone(upload.getParameter("phone"));
		dto.setZipcode(upload.getParameter("zipcode"));
		dto.setAddress1(UploadSave.encode(upload.getParameter("address1")));
		dto.setAddress2(UploadSave.encode(upload.getParameter("address2")));
		dto.setHobby(UploadSave.encode(upload.getParameter("hobby")));
		dto.setSkill(upload.getParameterValues("skill"));
		
		boolean flag = dao.update(dto);
		
		request.setAttribute("flag", flag);
		
		
		return "/views/team/updateProc.jsp";
	}

}
