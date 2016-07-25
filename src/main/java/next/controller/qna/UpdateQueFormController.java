package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;


import core.mvc.ModelAndView;

import next.dao.QuestionDao;

import next.model.Question;

public class UpdateQueFormController extends AbstractController {
	private static final Logger log = LoggerFactory.getLogger(UpdateQueFormController.class);

	private QuestionDao questionDao = new QuestionDao();

	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String questionId=request.getParameter("questionId");
		
		Question question =questionDao.findById(Long.parseLong(questionId));
		ModelAndView mav = jspView("/qna/form.jsp");
		mav.addObject("question", question);
		return mav;
	}

}
