package model.data.systemUserData;

import model.data.ISData;

public class SystemUserData extends ISData {

	// Attribute
	public String loginID, loginPW;

	// Getter & Setter
	public String getLoginID() {return this.loginID;}
	public void setLoginID(String loginID) {this.loginID = loginID;}
	public String getLoginPW() {return this.loginPW;}
	public void setLoginPW(String loginPW) {this.loginPW = loginPW;}
}
