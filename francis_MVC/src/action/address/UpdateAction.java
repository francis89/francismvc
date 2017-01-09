package action.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.address.AddressDAO;
import model.address.AddressDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		AddressDTO dto = new AddressDTO();
		AddressDAO dao = new AddressDAO();
		int no = Integer.parseInt(request.getParameter("no"));
		dto = dao.read(no);
		request.setAttribute("dto", dto);
		return "/views/address/updateForm.jsp";
	}

}
