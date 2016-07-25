package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.dao.QuestionDao;
import next.model.Question;

public class UpdateQuestionController extends AbstractController {
	private static final Logger log = LoggerFactory.getLogger(UpdateQuestionController.class);

	private QuestionDao questionDao = new QuestionDao();

	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long questionId=Long.parseLong(request.getParameter("questionId"));
		String writer=request.getParameter("writer");
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		
		
		questionDao.update(questionId,writer,title,contents);
		Question question= questionDao.findById(questionId);		
		
		ModelAndView mav = jspView("/qna/show.jsp");
		mav.addObject("question", question);
		return mav;
	}

}
