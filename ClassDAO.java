package dbStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClassDAO {
	String url = "jdbc:mysql://localhost:3306/classdb";
	String driver = "com.mysql.jdbc.Driver";
	String id = "root";
	String pwd = "1234";
	Connection con = null;
	Statement stmt = null;
	
	public void createDB() {
		String url = "jdbc:mysql://localhost/";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			stmt = con.createStatement();
			String createDB = "CREATE DATABASE classdb";
			stmt.executeUpdate(createDB);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void createTable() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			stmt = con.createStatement();
			String createTable = "create table class(number int auto_increment primary key,name varchar(10),kor int,eng int,math int)";
			stmt.executeUpdate(createTable);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insertClass(ClassDTO classDTO) {
		PreparedStatement pt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			String insert = "insert into class values(null,?,?,?,?)";
			pt = con.prepareStatement(insert);
			pt.setString(1, classDTO.getName());
			pt.setInt(2, classDTO.getKor());
			pt.setInt(3, classDTO.getEng());
			pt.setInt(4, classDTO.getMath());
			pt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void selectAll() {
		ArrayList<ClassDTO>list = new ArrayList<>();
		String select = "select * from class";
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				ClassDTO classDTO = new ClassDTO(rs.getInt("number"),rs.getString("name"),rs.getInt("kor"),rs.getInt("eng"),rs.getInt("math"));
				classDTO.setNumber(rs.getInt("number"));
				classDTO.setName(rs.getString("name"));
				classDTO.setKor(rs.getInt("kor"));
				classDTO.setEng(rs.getInt("eng"));
				classDTO.setMath(rs.getInt("math"));
				list.add(classDTO);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(ClassDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	public void select(int number) {
		ArrayList<ClassDTO>list = new ArrayList<>();
		String select = "select * from class where number ="+number;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				ClassDTO classDTO = new ClassDTO(rs.getInt("number"),rs.getString("name"),rs.getInt("kor"),rs.getInt("eng"),rs.getInt("math"));
				classDTO.setNumber(rs.getInt("number"));
				classDTO.setName(rs.getString("name"));
				classDTO.setKor(rs.getInt("kor"));
				classDTO.setEng(rs.getInt("eng"));
				classDTO.setMath(rs.getInt("math"));
				list.add(classDTO);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(ClassDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	public void updateClass(String name,int kor,int eng,int math) {
		PreparedStatement pt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			String update = "update book set name=?,kor=?,eng=?,math=? where number = ?";
			pt = con.prepareStatement(update);
			pt.setString(1, name);
			pt.setInt(1, kor);
			pt.setInt(2, eng);
			pt.setInt(3, math);
			pt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteClass(int number) {
		PreparedStatement pt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			String delete = "delete from class where number = ?";
			pt = con.prepareStatement(delete);
			pt.setInt(1, number);
			
			pt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void dropTable(String table) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pwd);
			stmt = con.createStatement();
			String dropTable = "drop table "+table;
			stmt.executeUpdate(dropTable);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
