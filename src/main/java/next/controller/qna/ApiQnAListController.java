package next.controller.qna;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.dao.QuestionDao;
import next.model.Question;

public class ApiQnAListController extends AbstractController {
	
	private QuestionDao questionDao = new QuestionDao();
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//9번 문제(갖다 붙여놓고 때려 마춘겁니다.. 이부분 다시 한번 리뷰해주시면 감사 하겠습니다.)
		List<Question> questionList=questionDao.findAll();
		ObjectMapper mapper = new ObjectMapper();
		 response.setContentType("application/json;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 out.print(mapper.writeValueAsString(questionList));
		 
		return jsonView();
		
	}

	
}
