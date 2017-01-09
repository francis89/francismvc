package action.address;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.address.AddressDAO;
import model.address.AddressDTO;
import model.memo.MemoDAO;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		AddressDTO dto = new AddressDTO();
		request.setCharacterEncoding("utf-8");
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddress1(request.getParameter("address1"));
		dto.setAddress2(request.getParameter("address2"));
		
		AddressDAO dao = new AddressDAO();
		boolean flag = dao.create(dto);
		request.setAttribute("flag", flag);
		
		return "/views/address/createProc.jsp";
	}

}

