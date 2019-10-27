package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtils {
	static ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	/**
	 * 获取连接对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException{
		return dataSource.getConnection();
	}
	

//	public static void main(String[] args) {
//	
//		try {
//			
//			Connection conn=DBUtil.getConn();
//			
//			   if(conn!=null)
//			   {
//				   System.out.println("数据库连接正常！");
//			   }
//			   else
//			   {
//				   System.out.println("数据库连接异常！");
//			   }
//			}
//			catch(Exception ex)
//			{
//				ex.printStackTrace();
//			}finally {
//				try {
//					DBUtil.close_conn(getConn());
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//	}
//
//	
/**
 * 释放资源
 * @param rs
 * @param st
 * @param conn
 */
	public static void release(ResultSet rs,Statement st,Connection conn) {
		close_Rs(rs);
		close_St(st);
		close_conn(conn);
	}
	public static void release(ResultSet rs,Connection conn) {
		close_Rs(rs);
		close_conn(conn);
	}
	public static void release(Statement st,Connection conn) {
		close_St(st);
		close_conn(conn);
	}
	
	public static void close_Rs(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		
	}
	public static void close_St(Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				st = null;
			}
		}
	}
	public static void close_conn(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
	}
}
