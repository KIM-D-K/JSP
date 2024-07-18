package action;

import java.io.IOException;

import dao.BoardDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.BoardVO;

@WebServlet("/reply")
public class BoardReplyAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reply_form에서 전달된 파라미터를 받는다.
		
		//idx는 원본글의 idx
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		BoardDAO dao = BoardDAO.getInstance();
		
		//같은 ref를 가지고 있는 데이터들 중 내가 추가하려고 하는
		//step값 이상인 애들을 +1을 먼저 해야한다.
		
		//기준글의 idx를 이용해서 댓글을 달고싶은 게시글의 정보를 가져온다.
		BoardVO base_vo = dao.selectOne(idx);
		
		//기준글에 step이상 값은 step = step+1 처리
		int res = dao.update_step(base_vo);
	
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setIp(ip);
		
		//답글이 들어갈 위치를 선정
		vo.setRef(base_vo.getRef());
		vo.setStep(base_vo.getStep()+1);
		vo.setDepth(base_vo.getDepth()+1);
		
		
		res = dao.reply(vo);
		
		if(res > 0) {
			response.sendRedirect("board_list");
		}
		
		
		
		
		
		
		
	}
}
