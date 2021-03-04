package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import es.salesianos.model.Student;
import es.salesianos.service.BusinessService;

@org.springframework.stereotype.Repository("StudentRepository")

public class StudentRepository extends Repository {
	
	public void delete(Integer id) {
		Connection conn = createConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("DELETE FROM ALUMNO WHERE id=?");
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(prepareStatement);
		}
		closeConnection(conn);
	}
	
	public void insert(Student student) {
		Connection conn = createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ALUMNO (nombre, edad, asisteFCT, empresa)" + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setBoolean(3, student.isAssistsFCT());
			preparedStatement.setInt(4, student.getBusiness());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		closeConnection(conn);
	}
	
	public void update(Student student) {
		Connection conn = createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE ALUMNO SET nombre=?, edad=?, asisteFCT=?, empresa=? WHERE id=?");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setBoolean(3, student.isAssistsFCT());
			if (student.getBusiness() != null) {
				preparedStatement.setInt(4, student.getBusiness());				
			} else {
				preparedStatement.setNull(4, java.sql.Types.NULL); 
			}
			preparedStatement.setInt(5, student.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		closeConnection(conn);
	}
	
	public void setNull(Student student) {
		Connection conn = createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE ALUMNO SET empresa=? WHERE id=?");
			preparedStatement.setNull(1, java.sql.Types.NULL); 
			preparedStatement.setInt(2, student.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		closeConnection(conn);
	}
	
	public Student findById(Integer id) {
		Student student = null;
		Connection conn = createConnection();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMNO WHERE id=?");
			prepareStatement.setInt(1, id);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				student = new Student(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getBoolean(4),
						resultSet.getInt(5)
				);
				student.setBusinessobj(new BusinessService().findById(student.getBusiness()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		closeConnection(conn);
		return student;
	}
	
	public List<Student> listAll() {
		List<Student> StudentList = new ArrayList<Student>();
		Connection conn = createConnection();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ALUMNO");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getBoolean(4),
						resultSet.getInt(5)
				);
				student.setBusinessobj(new BusinessService().findById(student.getBusiness()));
				StudentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		closeConnection(conn);
		return StudentList;
	}
}
