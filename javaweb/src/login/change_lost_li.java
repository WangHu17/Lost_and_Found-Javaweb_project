package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class change_lost_li extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ʼ��
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
		String user = "sa";
		String pwd = "160510111xyj";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		//�������ݿ����st
		Statement st;
		//��ȡ����
		
		try {
			Class.forName(driverName);
			try {
				Connection conn = DriverManager.getConnection(url,user,pwd);
				//������ѯ����
				st = conn.createStatement();
				System.out.println("����lost�ɹ�");
				
				//д��ѯ���
				String sql = "update lost set name='"+name+"',description='"+description+"',time='"+time+"',location='"+location+"' where id = '"+id+"'";
				//��ȡ���
				st.execute(sql);
				
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("����lost����2");
		}
	
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����lost����1");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}