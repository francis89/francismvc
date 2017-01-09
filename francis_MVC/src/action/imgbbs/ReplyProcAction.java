package action.imgbbs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import action.Action;
import model.imgbbs.ImgbbsDAO;
import model.imgbbs.ImgbbsDTO;
import utility1.UploadSave;

public class ReplyProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String upDir = request.getRealPath("/views/imgbbs/storage");
		  String tempDir = request.getRealPath("/views/imgbbs/temp");
		  
		  ImgbbsDAO dao = new ImgbbsDAO();
		  UploadSave upload = new UploadSave(request, -1, -1, tempDir); 
		
		  //paging, search 를 위한값
		  String col = upload.getParameter("col");
		  String word = UploadSave.encode(upload.getParameter("word"));
		  String nowPage = upload.getParameter("nowPage");
		  ImgbbsDTO dto = new ImgbbsDTO();
		  dto.setGrpno(Integer.parseInt(upload.getParameter("grpno")));
		  dto.setIndent(Integer.parseInt(upload.getParameter("indent")));
		  dto.setAnsnum(Integer.parseInt(upload.getParameter("ansnum")));
		  //부모글 삭제를 제한하기위해서
		  dto.setNo(Integer.parseInt(upload.getParameter("no")));
		  //form 의 입력된값 가져오기
		  dto.setName(UploadSave.encode(upload.getParameter("name")));
		  dto.setTitle(UploadSave.encode(upload.getParameter("title")));
		  dto.setContent(UploadSave.encode(upload.getParameter("content")));
		  dto.setPasswd(UploadSave.encode(upload.getParameter("passwd")));
		  
		  FileItem fileItem = upload.getFileItem("filename");
		  int filesize = (int)fileItem.getSize();
		  String filename = null;
		  if(filesize>0){
		    filename = UploadSave.saveFile(fileItem, upDir);
		  }else{
			    filename = "member.jpg";
		  }
		  dto.setFilename(filename);
		  
		  Map map = new HashMap();
		  map.put("col", col);
		  map.put("word", word);
		  dao.addAnsnum(dto.getGrpno(), dto.getAnsnum());
		  boolean flag = dao.createreply(dto);
		  
		  request.setAttribute("flag", flag);
		  request.setAttribute("col", col);
		  request.setAttribute("word", word);
		  request.setAttribute("nowPage", nowPage);
		
		return "/views/imgbbs/replyProc.jsp";
	}

}
