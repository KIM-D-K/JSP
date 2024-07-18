package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import dao.BoardDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Common.Board;
import vo.BoardVO;

@WebServlet("/board_list")
public class BoardListAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nowPage = 1;
		
		//맨 처음 실행할 때는 page값이 없기 때문에 null이 넘어온다.
		String page = request.getParameter("page");
		
		if(page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		//page가 1이면 1 ~ 10까지 조회
		//page가 2이면 11 ~ 20까지 조회
		int start = (nowPage-1)*Board.BLOCKLIST+1;
		int end = start + Board.BLOCKLIST - 1;
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		BoardDAO dao = BoardDAO.getInstance();

		//전체목록 가져오기
		List<BoardVO> list = dao.selectList(map);
		
		//전체 게시물 수 조회
		int res = dao.getRowTotal();
		
		
		
		
		
		
		request.getSession().removeAttribute("show");
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("board_list.jsp");
		disp.forward(request, response);
	}
}
















