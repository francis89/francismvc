package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import action.Action;
import model.member.MemberDAO;
import model.member.MemberDTO;
import utility1.UploadSave;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String upDir = "/views/member/storage";
		String tempDir = "/views/member/temp";

		upDir = request.getRealPath(upDir);
		tempDir = request.getRealPath(tempDir);
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();

		UploadSave upload = new UploadSave(request, -1, -1, tempDir);

		String id = UploadSave.encode(upload.getParameter("id"));
		String email = upload.getParameter("email");
		String str = "";
		String viewPage = "/views/member/prcreateProc.jsp";

		if (dao.duplicateId(id)) {
			str = "중복된 ID";
			request.setAttribute("str", str);
		} else if (dao.duplicateEmail(email)) {
			str = "중복된 Email";
			request.setAttribute("str", str);
		} else {
			// form의 입력값을 밥는다.
			dto.setId(UploadSave.encode(upload.getParameter("id")));
			dto.setMname(UploadSave.encode(upload.getParameter("mname")));
			dto.setAddress1(UploadSave.encode(upload.getParameter("address1")));
			dto.setAddress2(UploadSave.encode(upload.getParameter("address2")));

			dto.setPasswd(UploadSave.encode(upload.getParameter("passwd")));
			dto.setTel(upload.getParameter("tel"));
			dto.setEmail(upload.getParameter("email"));
			dto.setZipcode(upload.getParameter("zipcode"));
			dto.setJob(upload.getParameter("job"));

			// form의 선택한 파일 받기
			FileItem fileItem = upload.getFileItem("fname");
			int size = (int) fileItem.getSize();
			String fname = null;
			if (size > 0) {
				fname = UploadSave.saveFile(fileItem, upDir);
			} else {
				fname = "member.jpg";
			}
			dto.setFname(fname);

			boolean flag = false;
			flag = dao.create(dto);
			request.setAttribute("flag", flag);
			viewPage = "/views/member/createProc.jsp";
		}

		return viewPage;

	}

}
