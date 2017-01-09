package action.memo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.memo.MemoDAO;
import model.memo.MemoDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		int memono = Integer.parseInt(request.getParameter("memono"));
		MemoDAO dao = new MemoDAO();
		/* 조회수 증가 */
		dao.upViewcnt(memono);
		/* 조회수 증가 END */
		/* 조회 */
		MemoDTO dto = dao.read(memono);
		/* 조회 END */
		String content = null;
		if (dto != null) {
			content = dto.getContent();
			content = content.replaceAll("\r\n", "<BR>");
			dto.setContent(content);
		}
		request.setAttribute("dto", dto);
		return "/views/memo/read.jsp";
	}

}
