package action;

import java.io.IOException;
import java.util.List;

import dao.DeptDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.DeptVO;

@WebServlet("/dept_list")
public class DeptListAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//부서목록 가져오기
		List<DeptVO> list = DeptDAO.getInstance().selectList();
		
		//바인딩
		request.setAttribute("list", list);
		
		//포워딩
		RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp");
		disp.forward(request, response);
		
		
		
		
		
		
		
		
		
	}
}
