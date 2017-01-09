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
import utility1.Utility;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8"); 
		//--업로드용 변수 선언(폴더명)
				String upDir = "/views/bbs/storage";
				String tempDir = "/views/bbs/temp";
				//절대경로
				upDir = request.getRealPath(upDir);
				tempDir = request.getRealPath(tempDir);
				BbsDTO dto = new BbsDTO();
				BbsDAO dao = new BbsDAO();
				
				UploadSave upload = new UploadSave(request,-1,-1, tempDir);
				String col = upload.getParameter("col");
				String word = UploadSave.encode(upload.getParameter("word"));
				String nowPage = upload.getParameter("nowPage");
				String oldfile = UploadSave.encode(upload.getParameter("oldfile"));
				
				dto.setBbsno(Integer.parseInt(upload.getParameter("bbsno")));
				dto.setWname(UploadSave.encode(upload.getParameter("wname")));
				dto.setTitle(UploadSave.encode(upload.getParameter("title")));
				dto.setContent(UploadSave.encode(upload.getParameter("content")));
				dto.setPasswd(UploadSave.encode(upload.getParameter("passwd")));

				FileItem fileitem = upload.getFileItem("filename");
				int filesize = (int)fileitem.getSize(); 
				String filename = null;

				if(filesize>0){//새로운 파일을 업로드 했다.
					UploadSave.deleteFile(upDir, oldfile);
					filename = UploadSave.saveFile(fileitem, upDir);
				}
				dto.setFilename(filename);
				dto.setFilesize(filesize);
				
				Map map = new HashMap();
				map.put("bbsno", dto.getBbsno());
				map.put("passwd", dto.getPasswd());
			
				boolean pflag = dao.passCheck(map);
				boolean flag = false;
				if(pflag){
					flag = dao.update(dto);
				}
				
				
				
				request.setAttribute("flag", flag);
				request.setAttribute("pflag", pflag);
				request.setAttribute("col", col);
				request.setAttribute("word", word);
				request.setAttribute("nowPage", nowPage);
				request.setAttribute("dto", dto);
		
		return "/views/bbs/updateProc.jsp";
	}

}
