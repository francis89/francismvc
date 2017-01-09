package action.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.address.AddressDAO;
import model.address.AddressDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		AddressDAO dao = new AddressDAO();
		AddressDTO dto = dao.read(no);
		request.setAttribute("dto", dto);
		return "/views/address/read.jsp";
	}
}
