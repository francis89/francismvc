package action.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.address.AddressDAO;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		AddressDAO dao = new AddressDAO();
		boolean flag = dao.delete(no);
		request.setAttribute("flag", flag);
		return "/views/address/deleteProc.jsp";
	}
}
