//--------------問題クリアした場合ClearCountに+1・MissCountを0にする----------
package logic;

import model.User;

public class UserLogic {

	public void clear(User user) {
		int count = user.getClearCount();
		user.setClearCount(count + 1);
		//ミスのカウントを消している。
		user.setMissCount(0);
	}

}
