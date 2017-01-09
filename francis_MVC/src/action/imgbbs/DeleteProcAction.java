package action.imgbbs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.imgbbs.ImgbbsDAO;
import utility1.UploadSave;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String passwd = request.getParameter("passwd");
		
		String oldfile = request.getParameter("oldfile");
		ImgbbsDAO dao = new ImgbbsDAO(); 
		
		Map map = new HashMap();
		map.put("no", no);
		map.put("passwd", passwd);
		boolean pflag = dao.passCheck(map);
		//수정처리
		boolean flag = false;
		if (pflag) {
			flag = dao.delete(no);
		}
		if(flag){
			String upDir = request.getRealPath("/views/imgbbs/storage");
			UploadSave.deleteFile(upDir,oldfile);
		}
		
		request.setAttribute("pflag", pflag);
		request.setAttribute("flag", flag);
		
		
		return "/views/imgbbs/deleteProc.jsp";
	}

}
