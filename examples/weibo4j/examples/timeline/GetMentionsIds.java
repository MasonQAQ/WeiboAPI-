package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.MentionsIds;
import weibo4j.model.WeiboException;

public class GetMentionsIds {
	public static void main(String[] args) {
		String access_token = "2.00NdhwtC7X5R3Cbe1cb1ed8dwRBUYC";
		Timeline tm = new Timeline(access_token);
		try {
			MentionsIds ids = tm.getMentionsIds();//实例化MentionIds类
			//Log.logInfo(ids.getJson());//调用MentionIds类的toString 方法，
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
