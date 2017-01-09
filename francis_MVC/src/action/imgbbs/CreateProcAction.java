package action.imgbbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import action.Action;
import model.imgbbs.ImgbbsDAO;
import model.imgbbs.ImgbbsDTO;
import utility1.UploadSave;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//--업로드용 변수 선언(폴더명)
		String upDir = "/views/imgbbs/storage";
		String tempDir = "/views/imgbbs/temp";
		//절대경로
		upDir = request.getRealPath(upDir);
		tempDir = request.getRealPath(tempDir);
		ImgbbsDTO dto = new ImgbbsDTO();
		ImgbbsDAO dao = new ImgbbsDAO();
		
		UploadSave upload = new UploadSave(request,-1,-1, tempDir);
		dto.setName(UploadSave.encode(upload.getParameter("name")));
		dto.setTitle(UploadSave.encode(upload.getParameter("title")));
		dto.setContent(UploadSave.encode(upload.getParameter("content")));
		dto.setPasswd(UploadSave.encode(upload.getParameter("passwd")));
		
		FileItem fileItem = upload.getFileItem("filename");
		int size = (int)fileItem.getSize();
		String filename = null;
		if(size>0){
			filename = UploadSave.saveFile(fileItem, upDir);
		} else{
			filename = "member.jpg";
		}
		dto.setFilename(filename);
		boolean flag = false;

		flag = dao.create(dto);
		
		request.setAttribute("flag", flag);
		
		return "/views/imgbbs/createProc.jsp";
	}

}
