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

@WebServlet("/user/updateForm")
public class UpdateUserFormServlet extends HttpServlet{
	private static final Logger log = LoggerFactory.getLogger(UpdateUserFormServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("userId:"+req.getParameter("userId"));
		
		req.setAttribute("user",DataBase.findUserById(req.getParameter("userId")));	
		req.getRequestDispatcher("/user/update.jsp").forward(req, resp);
	}
}
