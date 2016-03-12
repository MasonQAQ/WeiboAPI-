package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
public class GetFriendsTimeline {
	public static void main(String[] args) throws JSONException, WeiboException {
		String access_token = "2.00NdhwtC7X5R3Cbe1cb1ed8dwRBUYC";
		Timeline tm = new Timeline(access_token);
		
		JFrame f = new JFrame("微博信息统计");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container content = f.getContentPane();
	    JSONObject status = tm.getFriendsTimeline();
	    JSONArray statuses=status.getJSONArray("statuses");
	    Object[][] rows=new Object[statuses.length()][3];
	    for (int i = 0; i < statuses.length(); i++) {
	    	rows[i][2]=" "+statuses.getJSONObject(i).getString("text")+" ";
	    	rows[i][1]=" "+statuses.getJSONObject(i).getJSONObject("user").getString("screen_name")+" ";
	    	rows[i][0]=" "+statuses.getJSONObject(i).getJSONObject("user").getString("idstr")+" ";
		}
		Object columns[] = { "id","name", "text"};
	    JTable table = new JTable(rows, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    content.add(scrollPane, BorderLayout.CENTER);
	    double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
	    double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
	    f.setSize((int)width,400);
	    FitTableColumns(table);
	    f.setVisible(true);
	}
	//用于控制列宽
	public static void FitTableColumns(JTable myTable){
		  JTableHeader header = myTable.getTableHeader();
		     int rowCount = myTable.getRowCount();

		     Enumeration columns = myTable.getColumnModel().getColumns();
		     while(columns.hasMoreElements()){
		         TableColumn column = (TableColumn)columns.nextElement();
		         int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
		         int width = (int)myTable.getTableHeader().getDefaultRenderer()
		                 .getTableCellRendererComponent(myTable, column.getIdentifier()
		                         , false, false, -1, col).getPreferredSize().getWidth();
		         for(int row = 0; row<rowCount; row++){
		             int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
		               myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
		             width = Math.max(width, preferedWidth);
		         }
		         header.setResizingColumn(column); 
		         column.setWidth(width+myTable.getIntercellSpacing().width);
		}
	}
}
