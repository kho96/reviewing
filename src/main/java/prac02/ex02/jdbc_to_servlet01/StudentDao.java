package prac02.ex02.jdbc_to_servlet01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {
	private static StudentDao instance;
	
	private StudentDao() { }
	
	public static StudentDao getInstance() {
		if (instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}
	
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "jin";
	private final String PW = "1234";
	
	// getConnection
	public Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return null;
	}
	
	// closeAll
	private void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) try { conn.close(); } catch(Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch(Exception e) { }
		if (rs != null) try { rs.close(); } catch(Exception e) { }
	}
	
	
	
	// 학생 등록
	public boolean addStudent(StudentVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into t_student(name, grade, class, class_no)"
					+ "	  values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getGrade());
			pstmt.setInt(3, vo.getMyClass());
			pstmt.setInt(4, vo.getClass_no());
			int count = pstmt.executeUpdate();
			if (count == 1) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	// 학생 1명 정보 보여주기
	public StudentVo studentByClassNo(int class_no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_student where class_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, class_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				int myClass = rs.getInt("class");
				StudentVo vo = new StudentVo(name, grade, myClass, class_no);
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
}
