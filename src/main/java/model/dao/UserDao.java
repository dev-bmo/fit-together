package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.User;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class UserDao {

	// DB TABLE 에 insert 하는 작업도 메서드 화
	public boolean save(User newUser) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.135.193:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");

		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, newUser.getId());
			stmt.setString(2, newUser.getPasword());
			stmt.setString(3, newUser.getName());
			stmt.setString(4, newUser.getGender());
			stmt.setInt(5, newUser.getBirth());
			stmt.setString(6, newUser.getEmail());
			stmt.setString(7, newUser.getInterest());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public User findById(String id) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.135.193:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {
			// 식별키로 조회하고,
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE ID=?");
			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setPasword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setBirth(rs.getInt("birth"));
				user.setEmail(rs.getString("email"));
				user.setInterest(rs.getString("interest"));

				return user;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
