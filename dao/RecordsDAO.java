//--------------DB logから統計処理を行うDAO----------

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Records;
import model.User;

public class RecordsDAO {

	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://127.0.0.1/quiz?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<Records> getRecords(User user) {

		List<Records> recList = new ArrayList<>();

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = " select moto.mainGenre, moto.subGenre, fuku.image, moto.date " +
					" from ( select mainGenre, subGenre, date from log where userId = ? and clear >= 3 ) moto " +
					" left outer join ( select mainGenre, subGenre, image from quiz ) fuku " +
					" on moto.mainGenre = fuku.mainGenre and moto.subGenre = fuku.subGenre " +
					" where moto.date is not null " +
					" group by moto.subGenre order by moto.mainGenre ; " ;

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致した問題が存在した場合
			// その問題を表すrecordsインスタンスを生成
			while (rs.next()) {
				// 結果表からデータを取得
				String mainGenre1 = rs.getString("mainGenre");
				String subGenre1 = rs.getString("subGenre");
				String image = rs.getString("image");
				String date = rs.getString("date");

				String mg;
				String sg;

				if (mainGenre1.equals("Greeting")) {
					mg = "世界のあいさつ";
				} else if (mainGenre1.equals("Olympic")) {
					mg = "オリンピックの雑学";
				} else if (mainGenre1.equals("Japanese")) {
					mg = "国内観光の雑学";
				} else if(mainGenre1.equals("Conversation")){
					mg = "基本英会話";
				} else {
					mg = mainGenre1;
				}

				if (subGenre1.equals("hello")) {
					sg = "こんにちは";
				} else if (subGenre1.equals("thankYou")) {
					sg = "ありがとう";
				} else if (subGenre1.equals("haveANiceDay")) {
					sg = "よい一日を";
				} else if (subGenre1.equals("origin")) {
					sg = "オリンピック競技の発祥国";
				} else if (subGenre1.equals("location")) {
					sg = "歴代オリンピック開催国";
				} else if (subGenre1.equals("player")) {
					sg = "世界の選手";
				} else if (subGenre1.equals("olympicelse")) {
					sg = "その他（由来など）";
				} else if (subGenre1.equals("JapaneseTourism")) {
					sg = "有名な観光地";
				} else if (subGenre1.equals("localSpecialty")) {
					sg = "ご当地名物";
				} else if (subGenre1.equals("introduction")) {
					sg = "紹介～はじめまして～";
				} else if (subGenre1.equals("guide")) {
					sg = "道案内";
				} else if (subGenre1.equals("tourism")) {
					sg = "観光案内";
				} else if (subGenre1.equals("others")){
					sg = "その他（感嘆表現・スラング）";
				} else {
					sg = subGenre1;
				}

				Records rec = new Records(mg, sg, image, date);
				recList.add(rec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return recList;
	}

	public List<Records> getNoRecords(User user){
		List<Records> nonRecList = new ArrayList<>();

		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			// SELECT文を準備
			String sql = " select moto.mainGenre, moto.subGenre "
					+ " from ( "
					+ " select distinct mainGenre, subGenre from quiz ) moto"
					+ " left outer join ( "
					+ " select distinct userId, mainGenre, subGenre from log "
					+ " where userId = ? ) fuku "
					+ " on moto.mainGenre = fuku.mainGenre and moto.subGenre = fuku.subGenre "
					+ " where fuku.subGenre is null;";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());

			// SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 一致した問題が存在した場合
			// その問題を表すreccordsインスタンスを生成
			while (rs.next()) {
				// 結果表からデータを取得
				String mainGenre1 = rs.getString("mainGenre");
				String subGenre1 = rs.getString("subGenre");

				String nmg;
				String nsg;

				if (mainGenre1.equals("Greeting")) {
					nmg = "世界のあいさつ";
				} else if (mainGenre1.equals("Olympic")) {
					nmg = "オリンピックの雑学";
				} else if (mainGenre1.equals("Japanese")) {
					nmg = "国内観光の雑学";
				} else if (mainGenre1.equals("Conversation")){
					nmg = "基本英会話";
				} else {
					nmg = mainGenre1;
				}

				if (subGenre1.equals("hello")) {
					nsg = "こんにちは";
				} else if (subGenre1.equals("thankYou")) {
					nsg = "ありがとう";
				} else if (subGenre1.equals("haveANiceDay")) {
					nsg = "よい一日を";
				} else if (subGenre1.equals("origin")) {
					nsg = "オリンピック競技の発祥国";
				} else if (subGenre1.equals("location")) {
					nsg = "歴代オリンピック開催国";
				} else if (subGenre1.equals("player")) {
					nsg = "世界の選手";
				} else if (subGenre1.equals("olympicelse")) {
					nsg = "その他（由来など）";
				} else if (subGenre1.equals("JapaneseTourism")) {
					nsg = "有名な観光地";
				} else if (subGenre1.equals("localSpecialty")) {
					nsg = "ご当地名物";
				} else if (subGenre1.equals("introduction")) {
					nsg = "紹介～はじめまして～";
				} else if (subGenre1.equals("guide")) {
					nsg = "道案内";
				} else if (subGenre1.equals("tourism")) {
					nsg = "観光案内";
				} else if (subGenre1.equals("others")) {
					nsg = "その他（感嘆表現・スラング）";
				} else {
					nsg = subGenre1;
				}

				Records rec = new Records(nmg, nsg);
				nonRecList.add(rec);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return nonRecList;
	}
}
