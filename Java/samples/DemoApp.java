import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.BaseRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DemoApp {
static void createDatabase(){
	
	try {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try(Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true",
			"app","app")){
		Statement st = con.createStatement();
		st.execute("create table books(bookid int primary key, title varchar(25))");
		System.out.println("Table created....");
		st.executeUpdate("insert into books VALUES (101, 'Java 8 in Action')");
		System.out.println("Data added");
	}catch(SQLException se){
		se.printStackTrace();
	}
	
	
}
	public static void main(String[] args) throws SQLException {

		//createDatabase();
		JdbcRowSet set = null;
		RowSetFactory factory = RowSetProvider.newFactory();
		set = factory.createJdbcRowSet();
		set.addRowSetListener(new RowSetListener() {
			
			@Override
			public void rowSetChanged(RowSetEvent event) {
				System.out.println("Entire row set has changed");
				
			}
			
			@Override
			public void rowChanged(RowSetEvent event) {
System.out.println("Indiviual record has changed");

				
			}
			
			@Override
			public void cursorMoved(RowSetEvent event) {
System.out.println("Cursor moved "+event.toString());

				
			}
		});
		
		
		set.setUrl("jdbc:derby://localhost:1527/sample");
		set.setUsername("app");
		set.setPassword("app");
		System.out.println("Fetching record");
		set.setCommand("select * from books");
		set.execute();
		while (set.next()) {
			System.out.println(set.getString(1));
		
			System.out.println("title "+ set.getString(2));
		}
		
	/*	//Class.forName("com.mysql.jdbc.Driver");
		Driver d = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		DriverAction da = null;
		DriverManager.registerDriver(d, da);*/
		
		
		
	}

}
