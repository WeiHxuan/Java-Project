package rungame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * 

 *
 */
public class DBUtils {

	private final String DRIVER="com.mysql.cj.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/class?serverTimezone=UTC&characterEncoding=utf8";
	private final String USER="root";
	private final String PASS="djaw99";
	
	private static DBUtils utils =null;
	
	private DBUtils(){
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DBUtils getInstance(){
		if(utils==null){
			utils=new DBUtils();
		}
		return utils;
			
		}
	public Connection getConn()
	{
		Connection conn=null;
		try{
			conn=DriverManager.getConnection(URL,USER,PASS);
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeAll(ResultSet result,PreparedStatement ps,Connection conn) throws SQLException{
		if(result!=null){
			result.close();
		}
		if(ps!=null && conn!=null){
			ps.close();
			conn.close();
		}
	}
	

}

	
	
	
	
	
	


