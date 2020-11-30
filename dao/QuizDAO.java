//--------------DB quizテーブルに関する処理を行うDAO----------

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QuizData;

public class QuizDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1/quiz?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<QuizData> findQuiz(String subGenre) {
		List<QuizData> quizDataList = new ArrayList<>();

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT mainGenre, subGenre, no, question, answer,hint, choice1, choice2, choice3, choice4, image, pass FROM quiz WHERE subGenre = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, subGenre);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致した問題が存在した場合
			// その問題を表すQuizDataインスタンスを生成
			while (rs.next()) {
				// 結果表からデータを取得
				String mainGenre1 = rs.getString("mainGenre");
				String subGenre1 = rs.getString("subGenre");
				int no = rs.getInt("no");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				String hint = rs.getString("hint");
				String choice1 = rs.getString("choice1");
				String choice2 = rs.getString("choice2");
				String choice3 = rs.getString("choice3");
				String choice4 = rs.getString("choice4");
				String image = rs.getString("image");
				String pass = rs.getString("pass");
				QuizData quizData = new QuizData(mainGenre1, subGenre1, no, question, answer, hint, choice1, choice2,
						choice3, choice4, image, pass);
				quizDataList.add(quizData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// 見つかったクイズまたはnullを返す
		return quizDataList;
	}

	public QuizData quizJudge(String subGenre, int quizNo) {
		QuizData quizData = new QuizData();

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT mainGenre, subGenre, no, question, answer,hint, choice1, choice2, choice3, choice4, image, pass FROM quiz WHERE subGenre = ? AND no = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, subGenre);
			pStmt.setInt(2, quizNo);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致した問題が存在した場合
			// その問題を表すQuizDataインスタンスを生成
			while (rs.next()) {
				// 結果表からデータを取得
				String mainGenre1 = rs.getString("mainGenre");
				String subGenre1 = rs.getString("subGenre");
				int no = rs.getInt("no");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				String hint = rs.getString("hint");
				String choice1 = rs.getString("choice1");
				String choice2 = rs.getString("choice2");
				String choice3 = rs.getString("choice3");
				String choice4 = rs.getString("choice4");
				String image = rs.getString("image");

				String pass = rs.getString("pass");
				quizData = new QuizData(mainGenre1, subGenre1, no, question, answer, hint, choice1, choice2, choice3,
						choice4, image, pass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quizData;

	}

	public List<QuizData> findAllQuiz() {

		List<QuizData> quizDataList = new ArrayList<>();

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "SELECT mainGenre, subGenre, no, question, answer,hint, choice1, choice2, choice3, choice4, image, pass FROM quiz";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				// 結果表からデータを取得
				String mainGenre1 = rs.getString("mainGenre");
				String subGenre1 = rs.getString("subGenre");
				int no = rs.getInt("no");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				String hint = rs.getString("hint");
				String choice1 = rs.getString("choice1");
				String choice2 = rs.getString("choice2");
				String choice3 = rs.getString("choice3");
				String choice4 = rs.getString("choice4");
				String image = rs.getString("image");
				String pass = rs.getString("pass");
				QuizData quizData2 = new QuizData(mainGenre1, subGenre1, no, question, answer, hint, choice1, choice2,
						choice3, choice4, image, pass);
				quizDataList.add(quizData2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// 見つかったクイズまたはnullを返す
		return quizDataList;
	}

	public void createQuiz(QuizData quizData) {
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = "insert into quiz(mainGenre, subGenre, question, answer, hint, "
					+ "choice1, choice2, choice3, choice4, image, pass) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, quizData.getMainGenre());
			pStmt.setString(2, quizData.getSubGenre());
			pStmt.setString(3, quizData.getQuestion());
			pStmt.setString(4, quizData.getAnswer());
			pStmt.setString(5, quizData.getHint());
			pStmt.setString(6, quizData.getChoice1());
			pStmt.setString(7, quizData.getChoice2());
			pStmt.setString(8, quizData.getChoice3());
			pStmt.setString(9, quizData.getChoice4());
			pStmt.setString(10, quizData.getImage());
			pStmt.setString(11, quizData.getPass());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
