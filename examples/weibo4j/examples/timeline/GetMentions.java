package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetMentions {

	public static void main(String[] args) {
		String access_token = "2.00NdhwtC7X5R3Cbe1cb1ed8dwRBUYC";
		Timeline tm = new Timeline(access_token);
		try {
			StatusWapper status = tm.getMentions();
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
