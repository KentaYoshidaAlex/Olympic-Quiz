//--------------クイズの合否を記録するためのJava Beans----------

package model;

import java.io.Serializable;

public class Judge implements Serializable {
	private int judge;

	public Judge() {
		this.judge = 0;
	}

	public Judge(int judge) {
		this.judge = judge;
	}

	public int getJudge() {
		return judge;
	}

	public void setJudge(int judge) {
		this.judge = judge;
	}

}
