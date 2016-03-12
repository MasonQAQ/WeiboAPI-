package weibo4j.model;

import java.util.ArrayList;
import java.util.List;

import weibo4j.http.Response;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/**
 * 获取@当前用户的最新微博的ID
 * 
 * @author xiaoV
 * 
 */
public class MentionsIds extends WeiboResponse {

	private static final long serialVersionUID = -7507725013094889640L;
	private long nextCursor;
	private long previousCursor;
	private long totalNumber;
	private long interval;
	private List<String> statusesIds; // ID列表
	private boolean hasvisible;
	public MentionsIds(Response res) throws WeiboException {
		super(res); //看成你从自己微博获取的数据，res
		JSONObject json = res.asJSONObject();//res变成标准json格式
		System.out.println(json);
		try {
			nextCursor = json.getLong("next_cursor");//取得res这个json中的next_cusor属性
			previousCursor = json.getLong("previous_cursor");//同上
			totalNumber = json.getLong("total_number");//同上
			hasvisible = json.getBoolean("hasvisible");//同上
			interval = json.getLong("interval");//同上
			JSONArray list = json.getJSONArray("statuses");//同上
			int size = list.length();//同上
			statusesIds = new ArrayList<String>(size);//同上
			for (int i = 0; i < size; i++) {
				statusesIds.add(list.getString(i));
			}
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);//跑出异常
		}

	}

	public MentionsIds(JSONObject json) throws WeiboException {
		try {
			nextCursor = json.getLong("next_cursor");
			previousCursor = json.getLong("previous_cursor");
			totalNumber = json.getLong("total_number");
			hasvisible = json.getBoolean("hasvisible");
			interval = json.getLong("interval");
			JSONArray list = json.getJSONArray("statuses");
			int size = list.length();
			statusesIds = new ArrayList<String>(size);
			for (int i = 0; i < size; i++) {
				statusesIds.add(list.getString(i));
			}
		} catch (JSONException jsone) {
			throw new WeiboException(jsone);
		}
	}

	public long getNextCursor() {
		return nextCursor;//get方法,好的java程序，属性（变量）都设置为private,如：private name,获取需要的private属性，用public的方法，一般是getName
	}//这都是为了安全

	public void setNextCursor(long nextCursor) {
		this.nextCursor = nextCursor;
	}

	public long getPreviousCursor() {
		return previousCursor;
	}

	public void setPreviousCursor(long previousCursor) {
		this.previousCursor = previousCursor;
	}

	public long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public List<String> getStatusesIds() {
		return statusesIds;
	}

	public void setStatusesIds(List<String> statusesIds) {
		this.statusesIds = statusesIds;
	}

	public boolean isHasvisible() {
		return hasvisible;
	}

	public void setHasvisible(boolean hasvisible) {
		this.hasvisible = hasvisible;
	}

}
