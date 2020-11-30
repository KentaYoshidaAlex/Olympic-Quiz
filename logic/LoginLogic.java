//--------------取得したユーザー情報をDBに送り、一致するユーザーがいるかを判定----------

package logic;

import dao.AccountDAO;
import model.User;

public class LoginLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		User user1 = dao.findByLogin(user);

		return user1 != null;
	}
}