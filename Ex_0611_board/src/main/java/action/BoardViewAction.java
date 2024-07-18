package action;

import java.io.IOException;

import dao.BoardDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.BoardVO;

@WebServlet("/view")
public class BoardViewAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx=Integer.parseInt(request.getParameter("idx"));
		
		
		BoardDAO dao = BoardDAO.getInstance();
		
		HttpSession session = request.getSession();
		
		//세션에 show라는 이름으로 저장된 값을 조회(처음에는 null)
		String show = (String)session.getAttribute("show");
		
		if(show == null) {
			//idx에 해당하는 게시글의 조회수를 1증가시키세요
			//메서드명 : update_readhit()
			//id : board_readhit
			int res = dao.update_readhit(idx);
			session.setAttribute("show", "0");
		}
		
		//idx를 보내서 게시글 한 건을 조회
		BoardVO vo =dao.selectOne(idx);
		
		
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher disp = request.getRequestDispatcher("board_view.jsp");
		disp.forward(request, response);
		
		
		
		
	}
}
