package action.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class UpdateFileAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String oldfile = request.getParameter("oldfile");
		
		request.setAttribute("oldfile", oldfile);
		return "/views/team/updateFileForm.jsp";
	}

}
