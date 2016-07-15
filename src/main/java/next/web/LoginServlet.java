package next.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("userId")!=null){
			resp.sendRedirect("/user/login.html");
		}
	
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String userId=req.getParameter("userId");
		String password=req.getParameter("password");
		if(userId!=null){
			User foundUser=DataBase.findUserById(userId);
			
			if(null!=foundUser&&foundUser.getUserId().equals(userId)){
				if(foundUser.getPassword().equals(password)){
					HttpSession session = req.getSession();
					session.setAttribute("userId", userId);
					resp.sendRedirect("/user/list");
				}
				else{
					resp.sendRedirect("/user/login_failed.html");
				}
			}
			else{
				resp.sendRedirect("/user/login_failed.html");
			}
		}
		else{//아이디를 입력안함
			resp.sendRedirect("/user/login_failed.html");
		}
	}
}
