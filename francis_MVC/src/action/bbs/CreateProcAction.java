package action.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import action.Action;
import model.bbs.BbsDAO;
import model.bbs.BbsDTO;
import utility1.UploadSave;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		BbsDTO dto = new BbsDTO();
		String upDir = request.getRealPath("/views/bbs/storage");
		String tempDir = request.getRealPath("/views/bbs/temp");
		UploadSave upload = new UploadSave(request, -1, -1, tempDir);
		
		dto.setWname(UploadSave.encode(upload.getParameter("wname")));
		dto.setTitle(UploadSave.encode(upload.getParameter("title")));
		dto.setContent(UploadSave.encode(upload.getParameter("content")));
		dto.setPasswd(UploadSave.encode(upload.getParameter("passwd")));
		
		FileItem fileItem = upload.getFileItem("filename"); 
		int filesize = (int)fileItem.getSize();
		String filename = null;
		if(filesize>0)
			filename = UploadSave.saveFile(fileItem, upDir);
		
		dto.setFilename(filename);
		dto.setFilesize(filesize);
		
		BbsDAO dao =new BbsDAO();
		boolean flag = dao.create(dto);
		request.setAttribute("flag", flag);
		
		return "/views/bbs/createProc.jsp";
	}

}
