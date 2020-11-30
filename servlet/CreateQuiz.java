//--------------クイズ新規作成の際に通るサーブレット----------
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.CreateQuizLogic;
import model.QuizData;

@WebServlet("/CreateQuiz")
public class CreateQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateQuiz() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String mainGenre = request.getParameter("mainGenre");
		String subGenre = request.getParameter("subGenre");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String hint = request.getParameter("hint");
		String choice1 = request.getParameter("choice1");
		String choice2 = request.getParameter("choice2");
		String choice3 = request.getParameter("choice3");
		String choice4 = request.getParameter("choice4");
		String image = request.getParameter("image");
		String pass = request.getParameter("pass");

		if(pass.equals("")) { pass = null ; }

		// クイズインスタンスの生成
		QuizData quizData = new QuizData(mainGenre, subGenre, question, answer, hint, choice1, choice2, choice3,
				choice4, image, pass);

		System.out.println("クイズインスタンス生成！");

		CreateQuizLogic createQuizLogic = new CreateQuizLogic();
		createQuizLogic.execute(quizData);

		System.out.println("クイズ登録executeメソッド実行！");

		// クイズ登録成功時の処理
		if (createQuizLogic != null) {
			// クイズ情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("createQuiz", quizData);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/createQuizResult.jsp");
		dispatcher.forward(request, response);
	}
}
