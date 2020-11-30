//--------------クイズの合否判定を行う----------

package logic;

import java.util.List;

import dao.QuizDAO;
import model.QuizData;

public class QuizLogic {
	public QuizData findQuiz(String subGenre){

		QuizDAO qDao = new QuizDAO();
		List<QuizData> quizDataList = qDao.findQuiz(subGenre);
		int no = new java.util.Random().nextInt(quizDataList.size());
		QuizData quizData = quizDataList.get(no);

		return quizData;
	}

	public boolean quizJudge(String subGenre, int quizNo, String choice) {

		QuizDAO qDao = new QuizDAO();
		QuizData quizData = qDao.quizJudge(subGenre, quizNo);

		String abox = quizData.getAnswer();

		System.out.println("ユーザーの回答 : " + choice);
		System.out.println("DBから取得した解答 : " + abox);

		//----------成否判定----------
		if (choice.equals(abox)) {
			return true;
		}
		return false;
	}
}
