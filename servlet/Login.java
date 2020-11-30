//--------------ログインの際に通るサーブレット----------
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import logic.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		//String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String id = request.getParameter("id");
		int clearCount = Integer.valueOf(request.getParameter("clearCount"));
		int missCount = Integer.valueOf(request.getParameter("missCount"));
		String bttn = request.getParameter("bttn");

		// Userインスタンス（ユーザー情報）の生成
		User user = new User(pass, id, clearCount, missCount);

		// ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);
		System.out.println("ログイン処理完了！");

		if (bttn.equals("管理者ログイン")) {

			if (isLogin) {
			// 管理者画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
			dispatcher.forward(request, response);
			} else {
				//----------エラーメッセージをリクエストスコープへ保存----------
				request.setAttribute("error", "ログインに失敗しました。");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}


		} else if (bttn.equals("ログイン")) {

			// ログイン成功時の処理
			if (isLogin) {

				ServletContext application = this.getServletContext();
				AccountDAO dao = new AccountDAO();
				User user1 = dao.findByLogin(user);
				application.setAttribute("user", user1);
				System.out.println("userをアプリケーションスコープにセット");

				// ログイン結果画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
				dispatcher.forward(request, response);
			} else {
				//----------エラーメッセージをリクエストスコープへ保存----------
				request.setAttribute("error", "ログインに失敗しました。");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}