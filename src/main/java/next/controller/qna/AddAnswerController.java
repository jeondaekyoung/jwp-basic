package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

public class AddAnswerController extends AbstractController {
	private static final Logger log = LoggerFactory.getLogger(AddAnswerController.class);

	private AnswerDao answerDao = new AnswerDao();

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse response) throws Exception {
		Answer answer = new Answer(req.getParameter("writer"), 
				req.getParameter("contents"), 
				Long.parseLong(req.getParameter("questionId")));
		log.debug("answer : {}", answer);
		long questionId = Long.parseLong(req.getParameter("questionId"));
		Answer savedAnswer = answerDao.insert(answer);
		QuestionDao questionDao = new QuestionDao();
		
		questionDao.update(questionId);
		
		Question question = questionDao.findById(questionId);
		
		log.info("Question ::: {} :::", question);
		
		return jsonView().addObject("answer", savedAnswer).addObject("question", question);
	}
}
