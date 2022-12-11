package prac02.ex02.jdbc_to_servlet02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDao {
	private static StudentDao instance;
	
	private StudentDao() { }
	
	public static StudentDao getInstance() {
		if (instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}
	
//	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private final String ID = "jin";
//	private final String PW = "1234";
//	
//	// getConnection
//	public Connection getConnection() {
//		try {
//			Class.forName(DRIVER_NAME);
//			Connection conn = DriverManager.getConnection(URL, ID, PW);
//			return conn;
//		} catch (Exception e) {
//			e.printStackTrace(); 
//		}
//		return null;
//	}
	
	// 커넥션 풀에서 커넥션 얻어오기
	// 처음에는 context.xml 파일 생성 (META-INF)에 위치 -> WEM-INF, web.xml수정하기
	private Connection getConnection() {
		try {
			Context context = new InitialContext(); // 컨텍스트 만들기
			
			// context.xml에 등록된 커넥션 풀을 얻어낸다.
			DataSource dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracleDB");
//			DataSource dataSource = 
//			(DataSource)((Context) context.lookup("java:/comp/env"))
//			.lookup("jdbc/oracleDB");
			
			// 커넥션 풀에 들어 있는 커넥션을 얻어온다.
			Connection conn = dataSource.getConnection();
			System.out.println("conn : "+ conn);
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
	
	// 전체 조회
	public List<StudentVo> showAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<StudentVo> list = new ArrayList<>();
			while (rs.next()) {
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				int myClass = rs.getInt("class");
				int class_no = rs.getInt("class_no");
				StudentVo vo = new StudentVo(name, grade, myClass, class_no);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	// 학생 1명 정보 보여주기(번호로찾기)
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
	
	// 학생 1명 정보 보여주기(번호로찾기)
	public StudentVo studentByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_student where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int grade = rs.getInt("grade");
				int myClass = rs.getInt("class");
				int class_no = rs.getInt("class_no");
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
	
	// 삭제
	public boolean deleteStudent(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "delete from t_student "
					+ "	  where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
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

	// 정보 수정
	public boolean modifyStudent(String orgName, StudentVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "update t_student set"
					+ "			name = ?, grade = ?, class = ?, class_no = ? "
					+ "	  where name = ?";
			System.out.println("orgName : " + orgName);
			System.out.println("vo :" + vo.toString());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getGrade());
			pstmt.setInt(3, vo.getMyClass());
			pstmt.setInt(4, vo.getClass_no());
			pstmt.setString(5, orgName);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
}
