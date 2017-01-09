package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import action.Action;
import model.member.MemberDAO;
import utility1.UploadSave;

public class UpdateFileProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String upDir = request.getRealPath("/views/member/storage");
		String tempDir = request.getRealPath("/views/member/temp");
		UploadSave upload = new UploadSave(request,-1,-1,tempDir);
		MemberDAO dao = new MemberDAO();
		
		String id = upload.getParameter("id");
		String oldfile = UploadSave.encode(upload.getParameter("oldfile"));
		
		FileItem fileItem = upload.getFileItem("fname");
		int size = (int)fileItem.getSize();
		String fname = null;
		if(size > 0){
			UploadSave.deleteFile(upDir, oldfile);
			fname=UploadSave.saveFile(fileItem, upDir);
		}
		boolean flag= dao.updateFile(id, fname);
		
		request.setAttribute("flag", flag);
		request.setAttribute("id", id);
		
		return "/views/member/updateFileProc.jsp";
	}

}
