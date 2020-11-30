//--------------クイズプレイ時に通るサーブレット----------

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AllQuizMusicDAO;
import logic.LogLogic;
import logic.QuizLogic;
import logic.UserLogic;
import logic.UserMissLogic;
import model.AllQuizMusic;
import model.Judge;
import model.QuizData;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Main() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//----------デフォルト値で初期宣言----------
		String errmsg = "エラー";

		//----------スコープの準備----------
		HttpSession session = request.getSession();
		ServletContext application = this.getServletContext();

		//----------QuizData quizDataのインスタンス生成・取得----------
		QuizData quizData = new QuizData();

		//----------User userのインスタンス生成・取得----------
		User user = (User) application.getAttribute("user");

		//----------クイズを取得＆合否判定する為のロジックをインスタンス化----------
		QuizLogic qLogic = new QuizLogic();

		//----------ログを残す為のロジックをインスタンス化----------
		LogLogic logLogic = new LogLogic();

		//----------正解時にカウントを回すロジックのインスタンス化----------
		UserLogic userLogic = new UserLogic();
		UserMissLogic userMissLogic = new UserMissLogic();

		//----------例外処理のtry/catch内----------
		try {

			// ----------引数受け取りのための文字コード設定----------
			request.setCharacterEncoding("utf-8"); // 受け取った引数の文字コードをセット
			response.setContentType("text/html; charset=utf-8");

			// ----------play.jsp および home.jspの引数受け取り----------
			String subGenre = request.getParameter("subGenre");
			String choice = request.getParameter("choice");
			String bttn = request.getParameter("bttn");
			String quizNo = request.getParameter("no");

			//----------問題選択後の処理---------
			if (bttn.equals("進む")) {

				System.out.println("「進む」ボタンを受取り");

				//subGenreのクイズデータをDBから取得し、quizData2に代入
				quizData = qLogic.findQuiz(subGenre);

				//----------QuizDataに"quiz"インスタンスを保存----------
				session.setAttribute("quiz", quizData);
				System.out.println("quizスコープにquizDataを保存");

				//----------AllMusicListに"am"インスタンスを保存----------

            	AllQuizMusicDAO aDao = new AllQuizMusicDAO();
            	List<AllQuizMusic> AllMusicList = aDao.findAllMusic();
            	AllQuizMusic MusicData = AllMusicList.get(0);

            	session.setAttribute("am", MusicData );
            	System.out.println("amスコープにMusicDataを保存");

				//----------RorW rw のインスタンス化、リクエストスコープへの保存----------
				Judge judge = new Judge(0);
				request.setAttribute("judge", judge);

				//----------アプリケーションスコープ userのクリアカウント数を0にする----------
				user.setClearCount(0);

				//---------play.jspにフォワード---------
				RequestDispatcher dispatcher = request.getRequestDispatcher("/play.jsp");
				dispatcher.forward(request, response);

			}
			//----------回答後の処理---------
			if (bttn.equals("回答")) {

				System.out.println("「回答」ボタンを受取り");

				boolean quizResult = qLogic.quizJudge(subGenre, Integer.parseInt(quizNo), choice);
				System.out.println("qLogic.execute()の実行完了");

				if (quizResult) {
					System.out.println("☆☆☆正解の処理始まり↓");

					//----------カウントを回す処理----------
					userLogic.clear(user);

					//----------Userに"user"インスタンスを保存----------
					session.setAttribute("user1", user);

					//----------RorW rw のインスタンス化、リクエストスコープへの保存----------
					Judge judge = new Judge(1);
					request.setAttribute("judge", judge);

					//----------sesionスコープに既出の問題の保存----------
					QuizData exquiz = (QuizData) session.getAttribute("quiz");
					session.setAttribute("exquiz", exquiz);

					//----------ログのインサート----------
					logLogic.logInsert(user, exquiz, choice, 1, 0);

					//----------次の問題用をランダムで発生させ、スコープに保存----------
					QuizData quizData2 = qLogic.findQuiz(subGenre);
					session.setAttribute("quiz", quizData2);

					//----------play.jspに再度フォワード----------
					RequestDispatcher dispatcher = request.getRequestDispatcher("/play.jsp");
					dispatcher.forward(request, response);

				} else if (!quizResult) {
					System.out.println("☆☆☆不正解の処理始まり↓");

					//----------RorW rw のインスタンス化、リクエストスコープへの保存----------
					Judge judge = new Judge(2);
					request.setAttribute("judge", judge);

					//----------カウントを回す処理----------
					userMissLogic.miss(user);

					//----------Userに"user"インスタンスを保存----------
					session.setAttribute("user1", user);

					//----------ログのインサート----------
					QuizData exquiz = (QuizData) session.getAttribute("quiz");
					logLogic.logInsert(user, exquiz, choice, 0, 1);

					//----------play.jspに再度フォワード----------
					RequestDispatcher dispatcher = request.getRequestDispatcher("/play.jsp");
					dispatcher.forward(request, response);
				}
			}
		}

		//----------例外処理のエラー文----------
		catch (Exception e) {

			System.out.println("Exception: " + e.toString());

			try {
				response.getWriter().println("<html>");
				response.getWriter().println("入力エラー<br>" + errmsg + "<br>");
				response.getWriter().println("<ul>");
				response.getWriter().println("<li><a href='http://127.0.0.1:8080/OlympicQuiz/home.jsp''>戻る</a></li>");
				response.getWriter().println("</ul>");
				response.getWriter().println("</html>");

			} catch (Exception j) {

			} finally {

			}
		}
	}
}
