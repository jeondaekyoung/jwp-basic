package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.dao.QuestionDao;
import next.model.User;

public class HomeController extends AbstractController {
    private QuestionDao questionDao = new QuestionDao();

    @Override
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//테스트아이디
    	User testUser = new User("jdk", "jdk", "전대경", "jdk@naver.com");
        request.getSession().setAttribute("user", testUser);
        
    	return jspView("index.jsp").addObject("questions", questionDao.findAll());
    }
}
