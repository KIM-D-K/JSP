package action;

import java.io.IOException;

import dao.BoardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.BoardVO;

@WebServlet("/del")
public class BoardDeleteAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		//System.out.println("idx="+idx);
		
		BoardDAO dao = BoardDAO.getInstance();
		//삭제하고자 하는 게시물을 idx를 통해 찾는다.
		
		BoardVO baseVO = dao.selectOne(idx);
		
		baseVO.setSubject("삭제된 글입니다.");
		baseVO.setName("unknown");
		
		int res = dao.del_update(baseVO);
		
		
		if(res > 0) {
			response.getWriter().print("{\"param\":\"yes\"}");
		} else {
			response.getWriter().print("{\"param\":\"no\"}");
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
