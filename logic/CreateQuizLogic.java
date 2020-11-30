//--------------jspから受け取った情報でクイズを新規作成する----------
package logic;

import dao.QuizDAO;
import model.QuizData;

public class CreateQuizLogic {
	public boolean execute(QuizData quizData) {
		QuizDAO dao = new QuizDAO();
		dao.createQuiz(quizData);
		return dao != null;
	}

}
