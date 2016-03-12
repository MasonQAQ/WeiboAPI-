package weibo4j.examples.trends;

import java.util.List;

import weibo4j.Trend;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.UserTrend;
import weibo4j.model.WeiboException;

public class GetTrends {

	public static void main(String[] args) {
		String access_token = "2.00NdhwtC7X5R3Cbe1cb1ed8dwRBUYC";
		String uid = "2658954891";
		Trend tm = new Trend(access_token);
		try {
			List<UserTrend> trends = tm.getTrends(uid);
			for(UserTrend t : trends){
				Log.logInfo(t.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
