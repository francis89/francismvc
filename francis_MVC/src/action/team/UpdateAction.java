package action.team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.team.TeamDAO;
import model.team.TeamDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));

		TeamDAO dao = new TeamDAO();
		TeamDTO dto = dao.read(no); 
		String skill = dto.getSkillstr();
		String nowPage = request.getParameter("nowPage");
		
		request.setAttribute("skill", skill);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("dto", dto);
		
		return "/views/team/updateForm.jsp";
	}

}
