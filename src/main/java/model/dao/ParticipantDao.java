package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Participant;
import model.vo.User;
import model.vo.complex.ParticipantWithUserDeatil;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class ParticipantDao {
	public boolean save(Participant participant) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.135.193:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO PARTICIPANTS VALUES (PARTICIPANTS_SEQ.NEXTVAL, ?, ?, ?)");
			stmt.setString(1, participant.getUserId());
			stmt.setInt(2, participant.getEventId());
			stmt.setDate(3, participant.getJoinAt());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Participant> findByEventId(int eventId) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.135.193:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PARTICIPANTS WHERE EVENT_ID=?");
			stmt.setInt(1, eventId);

			ResultSet rs = stmt.executeQuery();
			List<Participant> participants = new ArrayList<>();
			while (rs.next()) {
				Participant one = new Participant();

				one.setId(rs.getInt("id"));
				one.setEventId(rs.getInt("event_id"));
				one.setUserId(rs.getString("user_id"));
				one.setJoinAt(rs.getDate("join_at"));
				participants.add(one);
			}

			return participants;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<ParticipantWithUserDeatil> findByEventIdWithUserDetail(int eventId) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.135.193:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM PARTICIPANTS p JOIN USERS u ON p.USER_ID = u.ID WHERE EVENT_ID=?");
			stmt.setInt(1, eventId);

			ResultSet rs = stmt.executeQuery();
			List<ParticipantWithUserDeatil> participants = new ArrayList<>();
			while (rs.next()) {
				Participant one = new Participant();
				one.setId(rs.getInt("id"));
				one.setEventId(rs.getInt("event_id"));
				one.setUserId(rs.getString("user_id"));
				one.setJoinAt(rs.getDate("join_at"));

				User user = new User();
				user.setId(rs.getString("id"));
				user.setPasword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setBirth(rs.getInt("birth"));
				user.setEmail(rs.getString("email"));
				user.setInterest(rs.getString("interest"));
				
				ParticipantWithUserDeatil pwud = new ParticipantWithUserDeatil();
				pwud.setParticipant(one);
				pwud.setUser(user);
				
				participants.add(pwud);
			}
			
			return participants;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
