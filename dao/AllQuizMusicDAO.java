package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AllQuizMusic;

public class AllQuizMusicDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL =
          "jdbc:mysql://127.0.0.1/quiz?characterEncoding=UTF-8&serverTimezone=JST";
  private final String DB_USER = "root";
  private final String DB_PASS = "root";

  public List<AllQuizMusic> findAllMusic() {
	  List<AllQuizMusic> AllMusicList = new ArrayList<>();

    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(
        JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文を準備
      String sql = "SELECT correctS, gameOverS, congratulationsS, congratulationsS2  FROM AllQuizMusic";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();

      // 一致した問題が存在した場合
      // その問題を表すQuizDataインスタンスを生成
      while (rs.next()) {
        // 結果表からデータを取得
    	String correctS1 = rs.getString("correctS");
    	String gameOverS = rs.getString("gameOverS");
        String congratulationsS = rs.getString("congratulationsS");
        String congratulationsS2 = rs.getString("congratulationsS2");


        AllQuizMusic allQuizMusic2 = new AllQuizMusic (correctS1, gameOverS, congratulationsS, congratulationsS2);
        AllMusicList.add(allQuizMusic2);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    // 見つかったクイズまたはnullを返す
    return AllMusicList;
  }
}
