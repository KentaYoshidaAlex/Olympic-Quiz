//--------------ユーザー新規作成の際に通るサーブレット----------
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.CreateUserLogic;
import model.User;

@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateUser() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");

		// Userインスタンス（ユーザー情報）の生成
		User user = new User(id, pass, name);
		System.out.println("ユーザーインスタンス生成！");

		CreateUserLogic createUserLogic = new CreateUserLogic();
		createUserLogic.execute(user);

		// 新規登録成功時の処理
		if (createUserLogic != null) {
			// ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("createUser", user);

		}
		// 新規登録結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/createUserResult.jsp");
		dispatcher.forward(request, response);
	}

}
