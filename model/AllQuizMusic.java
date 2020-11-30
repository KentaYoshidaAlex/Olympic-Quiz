package model;

import java.io.Serializable;

public class AllQuizMusic implements Serializable {
	private String correctS;
	private String gameOverS;
	private String congratulationsS;
	private String congratulationsS2;


	public AllQuizMusic() {

		this.correctS = "";
		this.gameOverS = "";
		this.congratulationsS = "";
		this.congratulationsS2 = "";

	}

	public AllQuizMusic( String correctS, String gameOverS,String congratulationsS, String congratulationsS2) {
		this.correctS = correctS;
		this.gameOverS = gameOverS;
		this.congratulationsS = congratulationsS;
		this.congratulationsS2 = "";

	}

	public String getCongratulationsS2() {
		return congratulationsS2;
	}

	public void setCongratulationsS2(String congratulationsS2) {
		this.congratulationsS2 = congratulationsS2;
	}

	public String getCorrectS() {
		return correctS;
	}

	public void setCorrectS(String correctS) {
		this.correctS = correctS;
	}

	public String getGameOverS() {
		return gameOverS;
	}

	public void setGameOverS(String gameOverS) {
		this.gameOverS = gameOverS;
	}

	public String getCongratulationsS() {
		return congratulationsS;
	}

	public void setCongratulationsS(String congratulationsS) {
		this.congratulationsS = congratulationsS;
	}
}