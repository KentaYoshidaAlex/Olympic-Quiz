//--------------jspから受け取った情報でユーザーを新規作成する----------

package logic;

import dao.AccountDAO;
import model.User;

public class CreateUserLogic {
	//voidからbooleanに変更
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		dao.createUser(user);
		System.out.println("execute実行");
		//仮のreturn
		return dao != null;
	}
}
