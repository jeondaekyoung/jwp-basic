package next.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId=req.getParameter("userId");
		String password=req.getParameter("password");
		if(userId!=null){
			User foundUser=DataBase.findUserById(userId);
			log.debug("찾은 아이디:"+foundUser);
			if(null!=foundUser&&foundUser.getUserId().equals(userId)){
				if(foundUser.getPassword().equals(password)){
					resp.sendRedirect("/index.html");
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
