package action;

import java.io.IOException;
import java.util.List;

import dao.GogekDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.GogekVO;

@WebServlet("/gogek_list")
public class GogekListAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		String search ="all";
		String str_search = request.getParameter("search");
		
		if(str_search != null && !str_search.isEmpty()) {
			search = str_search;
		}
		
		List<GogekVO> list = null;
		
		if(search.equals("all")) list = GogekDAO.getInstance().selectList();
		else list = GogekDAO.getInstance().selectList(search);
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("gogek_list.jsp");
		disp.forward(request, response);
	}
}
