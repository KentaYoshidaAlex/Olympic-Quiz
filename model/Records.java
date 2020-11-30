//--------------クイズ記録を保持するためのJava Beans----------

package model;

import java.io.Serializable;

public class Records implements Serializable {

	private String clMG;
	private String clSG;
	private String nonClMG;
	private String nonClSG;
	private String image;
	private String playDate;

	public Records() {
		this.clMG = null;
		this.clSG = null;
		this.nonClMG = null;
		this.nonClSG = null;
		this.playDate = null;
	}

	public Records(String clMG, String clSG, String image, String playDate) {
		this.clMG = clMG;
		this.clSG = clSG;
		this.image = image;
		this.playDate = playDate;
	}

	public Records(String nonClMG, String nonClSG) {
		this.nonClMG = nonClMG;
		this.nonClSG = nonClSG;
	}

	public String getClMG() {
		return clMG;
	}

	public void setClMG(String clMG) {
		this.clMG = clMG;
	}

	public String getClSG() {
		return clSG;
	}

	public void setClSG(String clSG) {
		this.clSG = clSG;
	}

	public String getNonClMG() {
		return nonClMG;
	}

	public void setNonClMG(String nonClMG) {
		this.nonClMG = nonClMG;
	}

	public String getNonClSG() {
		return nonClSG;
	}

	public void setNonClSG(String nonClSG) {
		this.nonClSG = nonClSG;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPlayDate() {
		return playDate;
	}

	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}

}
