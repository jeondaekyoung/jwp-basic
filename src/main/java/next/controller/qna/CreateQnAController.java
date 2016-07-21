package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.Controller;
import core.mvc.ModelAndView;
import next.controller.user.CreateUserController;
import next.dao.QuestionDao;
import next.dao.UserDao;
import next.model.Question;
import next.model.User;

public class CreateQnAController extends AbstractController {
	private static final Logger log = LoggerFactory.getLogger(CreateQnAController.class);

    private QuestionDao questionDao = new QuestionDao();
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getSession().getAttribute("user")==null){
			 throw new NullPointerException("로그인 이후 이용하세요.");
	
			
		}
		
		Question question = new Question(
				request.getParameter("writer"), 
				request.getParameter("title"), 
				request.getParameter("contents")
			);
		
        log.debug("User : {}", question);
        questionDao.insert(question);
		return jspView("redirect:/");
	}

}
