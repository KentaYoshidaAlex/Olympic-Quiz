package logic;

import dao.LogDAO;
import model.QuizData;
import model.User;

public class LogLogic {
	public void logInsert(User user, QuizData quizData, String choice, int r, int w) {
		LogDAO logDao = new LogDAO();
		logDao.insertLog(user, quizData, choice, r, w);
	}
}
