package action.imgbbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.imgbbs.ImgbbsDAO;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int no = Integer.parseInt(request.getParameter("no"));
		String nowPage = request.getParameter("nowPage");
		ImgbbsDAO dao = new ImgbbsDAO();
		boolean flag = dao.chechRefno(no);
		
		request.setAttribute("flag", flag);
		
		return "/views/imgbbs/deleteForm.jsp";
	}

}
