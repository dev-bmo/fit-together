package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Event;
import oracle.jdbc.datasource.impl.OracleDataSource;

public class EventDao {

	public boolean save(Event event) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.210.77:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO EVENTS VALUES(EVENTS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, event.getTitle());
			stmt.setString(2, event.getDescription());
			stmt.setString(3, event.getTag());
			stmt.setInt(4, event.getGymId());
			stmt.setString(5, event.getHostId());
			stmt.setDate(5, event.getOpenAt());
			stmt.setInt(6, event.getCapacity());
			stmt.setInt(7, event.getAttendee());
			stmt.setDate(8, event.getRegisterAt());

			int r = stmt.executeUpdate();

			return r == 1 ? true : false;

		} catch (Exception e) {
			return false;
		}

	}

	public List<Event> findAll() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.210.77:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EVENTS ORDER BY OPEND_AT ASC");

			ResultSet rs = stmt.executeQuery();
			List<Event> events = new ArrayList<Event>();
			while (rs.next()) {
				Event one = new Event();
				one.setId(rs.getInt("id"));
				one.setTitle(rs.getString("title"));
				one.setDescription(rs.getString("title"));
				one.setTag(rs.getString("tag"));
				one.setGymId(rs.getInt("gym_id"));
				one.setHostId(rs.getString("host_id"));
				one.setOpenAt(rs.getDate("open_at"));

				one.setCapacity(rs.getInt("capacity"));
				one.setAttendee(rs.getInt("attendee"));
				one.setRegisterAt(rs.getDate("register_at"));

				events.add(one);
			}

			return events;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Event> findByTag(String tag) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.210.77:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("select * from events where tag=? order by open_date");
			stmt.setString(1, tag);

			ResultSet rs = stmt.executeQuery();
			List<Event> events = new ArrayList<Event>();
			while (rs.next()) {
				Event one = new Event();
				one.setId(rs.getInt("id"));
				one.setTitle(rs.getString("title"));
				one.setDescription(rs.getString("title"));
				one.setTag(rs.getString("tag"));
				one.setGymId(rs.getInt("gym_id"));
				one.setHostId(rs.getString("host_id"));
				one.setOpenAt(rs.getDate("open_at"));

				one.setCapacity(rs.getInt("capacity"));
				one.setAttendee(rs.getInt("attendee"));
				one.setRegisterAt(rs.getDate("register_at"));

				events.add(one);
			}

			return events;
		} catch (Exception e) {
			return null;
		}
	}

	public Event findById(int id) throws SQLException {

		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//13.125.210.77:1521/xe");
		ods.setUser("fit_together");
		ods.setPassword("oracle");
		try (Connection conn = ods.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EVENTS WHERE ID=?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Event one = new Event();
				one.setId(rs.getInt("id"));
				one.setTitle(rs.getString("title"));
				one.setDescription(rs.getString("title"));
				one.setTag(rs.getString("tag"));
				one.setGymId(rs.getInt("gym_id"));
				one.setHostId(rs.getString("host_id"));
				one.setOpenAt(rs.getDate("open_at"));

				one.setCapacity(rs.getInt("capacity"));
				one.setAttendee(rs.getInt("attendee"));
				one.setRegisterAt(rs.getDate("register_at"));
				return one;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
