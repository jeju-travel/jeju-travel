package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import member.MemberDaoImpl;


@WebServlet(name = "/LoginOutConroller", urlPatterns = { "/login_input", "/login", "/logout"})
public class LoginOutController extends HttpServlet {

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
		if (action.equals("login_input")) {

		} else if (action.equals("login")) {
			
			

		} else if(action.equals("logout")) {
			
		}

		String dispatchUrl = null;
		// 주소 이동
		if (action.equals("login_input")) {
			dispatchUrl = "/member/login.jsp";
		} else if (action.equals("login")) {
			
			HttpSession session = req.getSession();
			//String id = (String)session.getAttribute("member");
			if(session.getAttribute("member") != null) {
				dispatchUrl = "/index.jsp";
			}else {
				dispatchUrl = "/member/login.jsp";				
			}
		} else if(action.equals("logout")) {
			dispatchUrl = "/index.jsp";
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
