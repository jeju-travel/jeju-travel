package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.member.MemberDao;
import dao.member.MemberDaoImpl;
import model.manager.Admin;
import model.manager.Member;
import util.JDBCUtil;


@WebServlet(name = "LoginOutConroller", urlPatterns = { "/login_input", "/login", "/logout",  "/findidpw", "/findid", "/findpw"})
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
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			System.out.println(id + " "+ pw);
			
			MemberDao dao = new MemberDaoImpl();
			
			Member member = dao.login(id, pw);
			Admin admin = dao.adminLogin(id,pw);
			
			
			if(member.getId() != null) {
				HttpSession session = req.getSession();
				session.setAttribute("member", member.getId());
				System.out.println("id: " + member.getId() + " pw: " +member.getPw() );
			}else if(admin.getId() != null){
				
				HttpSession session = req.getSession();
				session.setAttribute("admin", admin.getId());
				System.out.println("id: " + admin.getId() + " pw: " +admin.getPw() );
			}else {
				
				req.setAttribute("message", "존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다.");
				System.out.println("존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다.");
			}
			

		} else if(action.equals("logout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("member");
			session.removeAttribute("admin");
		}else if(action.equals("findidpw")) {
			
		}else if(action.equals("findid")) {
			
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
			
			MemberDao dao = new MemberDaoImpl();
			String id = dao.FindId(name, phone);
			
			req.setAttribute("id", id);
			
		}else if(action.equals("findpw")) {
			
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String hint = req.getParameter("hint");
			String answer = req.getParameter("answer");
			
			System.out.println(id + " " + name + " " + hint + " " + answer);
			MemberDao dao = new MemberDaoImpl();
			String pw = dao.FindPw(id, name, hint, answer);
			System.out.println(pw);
			req.setAttribute("pw", pw);
		}
		

		// 주소 이동
		String dispatchUrl = null;
		if (action.equals("login_input")) {
			dispatchUrl = "/jsp/member/login.jsp";
		} else if (action.equals("login")) {
			
			HttpSession session = req.getSession();
			//String id = (String)session.getAttribute("member");
			if(session.getAttribute("member") != null) {
				dispatchUrl = "/index.jsp";
			}else if(session.getAttribute("admin") != null){
				dispatchUrl = "jsp/lodging_admin/adminmain.jsp";
			}else {
				dispatchUrl = "/jsp/member/login.jsp";				
			}
		} else if(action.equals("logout")) {
			dispatchUrl = "/index.jsp";
		}else if(action.equals("findidpw")) {
			dispatchUrl = "/jsp/member/findidpw.jsp";
		}else if(action.equals("findid")) {
			dispatchUrl = "/jsp/member/findid.jsp";
		}else if(action.equals("findpw")) {
			dispatchUrl = "/jsp/member/findpw.jsp";
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(req, resp);
	}
}
