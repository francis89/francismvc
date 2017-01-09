package action.bbs;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.bbs.BbsDAO;
import utility1.Utility;

public class DeleteProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String col = request.getParameter("col");
		String word = request.getParameter("word");
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		String passwd = request.getParameter("passwd");
		String nowPage = request.getParameter("nowPage");
		String oldfile = request.getParameter("oldfile");
		
		BbsDAO dao = new BbsDAO();
		
		Map map = new HashMap();
		map.put("bbsno", bbsno);
		map.put("passwd", passwd);
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		
		
			if(pflag){
				flag = dao.delete(bbsno);
			}
			if(flag){
				String upDir = request.getRealPath("/views/bbs/storage");
				Utility.deleteFile(oldfile, upDir);
			}
			
			request.setAttribute("pflag", pflag);
			request.setAttribute("flag", flag);
		
		
		return "/views/bbs/deleteProc.jsp";
	}

}
