package action.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.team.TeamDAO;
import utility1.UploadSave;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int no = Integer.parseInt(request.getParameter("no"));
		

		String oldfile = request.getParameter("oldfile");
		TeamDAO dao = new TeamDAO();
		
		boolean flag = dao.delete(no);
		if (flag) {
			String upDir = request.getRealPath("/team/storage");
			UploadSave.deleteFile(upDir, oldfile);
		}

		request.setAttribute("flag", flag);
		return "/views/team/deleteProc.jsp";
	}

}
