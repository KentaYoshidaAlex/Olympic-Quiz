//--------------DB logテーブルに関する処理を行う（クイズの記録を保存する）DAO----------

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.QuizData;
import model.User;

public class LogDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1/quiz?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public void insertLog(User user, QuizData quizData, String choice, int r, int w) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備

			String sql = "insert into log( userId, mainGenre, subGenre, no, choice, answer,"
					+ "date, logRight, wrong, miss, clear ) values ( ?, ?, ?, ?, ?, ?, current_timestamp, ? , ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());
			pStmt.setString(2, quizData.getMainGenre());
			pStmt.setString(3, quizData.getSubGenre());
			pStmt.setInt(4, quizData.getNo());
			pStmt.setString(5, choice);
			pStmt.setString(6, quizData.getAnswer());
			pStmt.setInt(7, r);
			pStmt.setInt(8, w);
			pStmt.setInt(9, user.getMissCount());
			pStmt.setInt(10, user.getClearCount());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
