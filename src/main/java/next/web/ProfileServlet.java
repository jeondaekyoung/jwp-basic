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

@WebServlet("/user/profile")
public class ProfileServlet extends HttpServlet {
	private static final Logger log = LoggerFactory.getLogger(UpdateUserFormServlet.class);
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String userId=(String)req.getSession().getAttribute("userId");
				User user= null;
				if(userId!=null){
					user=DataBase.findUserById(userId);
				}
				req.setAttribute("user",user);
				
				req.getRequestDispatcher("/user/profile.jsp").forward(req, resp);
		}
		
}
