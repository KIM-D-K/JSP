package action;

import java.io.IOException;
import java.util.List;

import dao.SawonDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.SawonVO;

@WebServlet("/sawon_list")
public class SawonListAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptno = 0;
		
		//맨 처음실행하게 되면 null이 들어갈거임
		String str_deptno = request.getParameter("deptno");
		
		if(str_deptno != null && !str_deptno.isEmpty()) {
			deptno = Integer.parseInt(str_deptno);
		}
		
		List<SawonVO> list = null;
		
		if(deptno == 0) {
			list = SawonDAO.getInstance().selectList();	
		} else {
			list = SawonDAO.getInstance().selectList(deptno);
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("sawon_list.jsp");
		disp.forward(request, response);
		
		
		
		
	}
}
