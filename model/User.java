//--------------ユーザー情報を記録するためのJava Beans----------

package model;

import java.io.Serializable;

public class User implements Serializable {
  private String name; // ユーザー名
  private String id;	//ID
  private String pass; // パスワード
  private int clearCount;//クリア数
  private int missCount;//失敗数

public User() {
	name = null;
	id = null;
	pass = null;
	clearCount = 0;
	missCount = 0;
  }


public User(String id,String pass ,String name) {

    this.id = id;
    this.pass = pass;
    this.name = name;

}

  public User(String pass ,String id, int clearCount, int missCount) {

    this.pass = pass;
    this.id = id;
	this.clearCount = clearCount;
	this.missCount = missCount;

  }

  public User(String id ,String pass, String name, int clearCount, int missCount) {

	  	this.id = id;
	    this.pass = pass;
	    this.name = name;
		this.clearCount = clearCount;
		this.missCount = missCount;

	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getClearCount() {
		return clearCount;
	}

	public void setClearCount(int clearCount) {
		this.clearCount = clearCount;
	}
	public int getMissCount() {
		return missCount;
	}
	public void setMissCount(int missCount) {
		this.missCount = missCount;
	}
}
