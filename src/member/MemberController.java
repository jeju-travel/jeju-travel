package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;


@WebServlet(name = "/MemberConroller", urlPatterns = { "/join", "/idcheck"})
public class MemberController extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		System.out.println(uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);

		// logic
		if (action.equals("join")) {

		} else if (action.equals("idcheck")) {
			// 화면에서 id 값 받아오기
			String id = req.getParameter("id_value");

			MemberDao memberDao = new MemberDaoImpl();
		
			System.out.println(id);

			

		} 
		
		String dispatchUrl = null;
		// 주소 이동
		if (action.equals("join")) {
			dispatchUrl = "/member/join.jsp";
		} else if (action.equals("idcheck")) {
			dispatchUrl = "/ajax/idcheck.jsp";

		} 


		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
