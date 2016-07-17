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

@WebServlet( value={"/user/update", "/user/updateForm"})
public class UpdateUserServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(UpdateUserServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user",DataBase.findUserById(req.getParameter("userId")));	
		req.getRequestDispatcher("/user/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId=req.getParameter("userId");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		log.debug("userId:"+userId+",password:"+password+",name:"+name+",email:"+email);
		
		User user=DataBase.findUserById(userId);
		user.update(password, name, email);
		
		
		DataBase.addUser(user);
		
		log.debug("수정이후 이름:"+user.getName());
		
		resp.sendRedirect("/user/list");
		
	}
	
	
}
