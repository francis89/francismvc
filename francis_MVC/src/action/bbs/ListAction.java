package action.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import model.bbs.BbsDAO;
import model.bbs.BbsDTO;
import utility1.Utility;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				String col = Utility.checkNull(request.getParameter("col"));
				String word = Utility.checkNull(request.getParameter("word"));

				if (col.equals("total")) {
					word = "";
				}
				// 검색end
				// 페이지 관련 ----------------`--------------
				int nowPage = 1; // 현재 페이지(변경가능해야함))
				if (request.getParameter("nowPage") != null) {
					nowPage = Integer.parseInt(request.getParameter("nowPage"));
				}

				int recordPerPage = 5; // 현 페이지당 보여줄 레코드 갯수

				// DB에서 읽어줄 시작순번과 끝순번 생성
				int sno = ((nowPage - 1) * recordPerPage) + 1;
				int eno = nowPage * recordPerPage;

				// 검색에 대한 데이터를 리스트에가서 뽑아와야함.
				Map map = new HashMap();
				map.put("col", col);
				map.put("word", word);
				map.put("sno", sno);
				map.put("eno", eno);

				
				BbsDAO dao = new BbsDAO();
				List<BbsDTO> list = dao.list(map);
				int total = dao.total(col, word);
				
				String paging = Utility.paging3(total, nowPage, recordPerPage, col, word);
				request.setAttribute("list", list);
				request.setAttribute("nowPage", nowPage);
				request.setAttribute("col",col);
				request.setAttribute("word", word);
				request.setAttribute("paging",paging);
		
		return "/views/bbs/list.jsp";
	}

}
