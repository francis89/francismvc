package action.bbs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import action.Action;
import model.bbs.BbsDAO;
import model.bbs.BbsDTO;
import utility1.UploadSave;

public class ReplyProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String upDir = request.getRealPath("/views/bbs/storage");
		String tempDir = request.getRealPath("/views/bbs/temp");
		BbsDTO dto = new BbsDTO();
		UploadSave upload = new UploadSave(request, -1, -1, tempDir);	

		//paging, search 를 위한값
		String col = upload.getParameter("col");
		String word = UploadSave.encode(upload.getParameter("word"));
		String nowPage = upload.getParameter("nowPage");
		//답변을 위한 부모의 값
		dto.setGrpno(Integer.parseInt(upload.getParameter("grpno")));
		dto.setIndent(Integer.parseInt(upload.getParameter("indent")));
		dto.setAnsnum(Integer.parseInt(upload.getParameter("ansnum")));
		//부모글 삭제를 제한하기위해서
		dto.setBbsno(Integer.parseInt(upload.getParameter("bbsno")));
		//form 의 입력된값 가져오기
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
		
		
		BbsDAO dao = new BbsDAO();
		dao.addAnsnum(dto.getGrpno(), dto.getAnsnum());
		boolean flag = dao.reply(dto);
		
		request.setAttribute("col", col);		
		request.setAttribute("word", word);		
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("flag", flag);
		
		
		return "/views/bbs/replyProc.jsp";
	}

}
