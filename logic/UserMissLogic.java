//--------------問題ミスした場合missCountに+1する,----------
//--------------ゲームオーバー時クリアカウントを0に戻す----------
package logic;

import model.User;

public class UserMissLogic {

	public void miss(User user) {
		int count = user.getMissCount();
		user.setMissCount(count + 1);
	}

}
