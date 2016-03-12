package weibo4j.examples.timeline;

import java.util.List;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Emotion;
import weibo4j.model.WeiboException;

public class GetEmotions {

	public static void main(String[] args) {
		String access_token = "2.00NdhwtC7X5R3Cbe1cb1ed8dwRBUYC";
		Timeline tm = new Timeline(access_token);
		try {
			List<Emotion> emotions =  tm.getEmotions();
			for(Emotion e : emotions){
//				Log.logInfo(e.toString());
//				Log.logInfo(tm.getEmotions());
				System.out.println(tm.getEmotions());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
