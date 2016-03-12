package weibo4j.examples.account;

import weibo4j.Account;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class EndSession {

	public static void main(String[] args) {
		String access_token = "2.00NdhwtC7X5R3Cbe1cb1ed8dwRBUYC";
		Account am = new Account(access_token);
		try {
			User user = am.endSession();
			Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
