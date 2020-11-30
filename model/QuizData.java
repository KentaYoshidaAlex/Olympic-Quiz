//--------------クイズデータを保持するためのJava Beans----------

package model;

import java.io.Serializable;

public class QuizData implements Serializable {
	private String mainGenre;
	private String subGenre;
	private int no;
	private String question;
	private String answer;
	private String hint;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String image;
	private String pass;

	public QuizData() {

		this.mainGenre = "";
		this.subGenre = "";
		this.no = 0;
		this.question = "";
		this.answer = "";
		this.hint = "";
		this.choice1 = "";
		this.choice2 = "";
		this.choice3 = "";
		this.choice4 = "";
		this.image = "";
		this.pass = "";

	}

	public QuizData(String mainGenre, String subGenre, int no, String question, String answer, String hint,
			String choice1, String choice2, String choice3, String choice4, String image, String pass) {
		this.mainGenre = mainGenre;
		this.subGenre = subGenre;
		this.no = no;
		this.question = question;
		this.answer = answer;
		this.hint = hint;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.image = image;
		this.pass = pass;
	}

	public QuizData(String mainGenre, String subGenre, String question, String answer, String hint,
			String choice1, String choice2, String choice3, String choice4, String image, String pass) {
		this.mainGenre = mainGenre;
		this.subGenre = subGenre;
		this.question = question;
		this.answer = answer;
		this.hint = hint;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.image = image;
		this.pass = pass;
	}

	public String getMainGenre() {
		return mainGenre;
	}

	public void setMainGenre(String mainGenre) {
		this.mainGenre = mainGenre;
	}

	public String getSubGenre() {
		return subGenre;
	}

	public void setSubGenre(String subGenre) {
		this.subGenre = subGenre;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getChoice4() {
		return choice4;
	}

	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
