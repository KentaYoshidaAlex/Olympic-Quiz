//--------------DB userテーブルに関する処理を行うDAO----------

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AccountDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1/quiz?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public User findByLogin(User user) {
		User user1 = null;

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT ID, PASS, NAME FROM USER WHERE ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPass());
			System.out.println("ＳＱＬ文の表示" + pStmt);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致したユーザーが存在した場合
			// そのユーザーを表すAccountインスタンスを生成
			if (rs.next()) {
				// 結果表からデータを取得
				String id = rs.getString("ID");
				String pass = rs.getString("PASS");
				String name = rs.getString("NAME");

				user1 = new User(id, pass, name, 0, 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// 見つかったユーザーまたはnullを返す
		return user1;
	}

	public void createUser(User user) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "insert into user values ( ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getName());
			System.out.println("インサート文の内容" + pStmt);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
