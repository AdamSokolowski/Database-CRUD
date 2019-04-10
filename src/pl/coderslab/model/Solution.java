package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Solution {

	private int id;
	private LocalDateTime created;
	private LocalDateTime updated;
	private String description;
	private int exercise_id;
	private int users_id;

	public Solution() {

	}

	public Solution(String description, int exercise_id, int users_id) {

		this.description = description;
		this.exercise_id = exercise_id;
		this.users_id = users_id;

	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreated() {
		return created;
	}
	
	public String getCreatedAsString() {
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String datetime = created.format(dateTimeFormat);
		return  datetime;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}
	
	public String getUpdatedAsString() {
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String datetime = updated.format(dateTimeFormat);
		return  datetime;
	}

	public String getDescription() {
		return description;
	}

	public int getExercise_id() {
		return exercise_id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExercise_id(int exercise_id) {
		this.exercise_id = exercise_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", exercise_id=" + exercise_id + ", users_id=" + users_id + "]";
	}

	public int saveToDB(Connection conn) throws SQLException {
		if (this.id == 0) {
			String sql = "INSERT INTO Solution(created, updated, description, exercise_id, users_id) VALUES (now(), now(), ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, this.description);
			preparedStatement.setInt(2, this.exercise_id);
			preparedStatement.setInt(3, this.users_id);
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				this.id = rs.getInt(1);
			}
		} else {
			String sql = "UPDATE Solution SET updated=now(), description=?, exercise_id=?, users_id=? where id = ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, this.description);
			preparedStatement.setInt(2, this.exercise_id);
			preparedStatement.setInt(3, this.users_id);
			preparedStatement.setInt(4, this.id);
			preparedStatement.executeUpdate();
		}
		return this.id;
	}

	static public Solution loadById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM Solution where id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getTimestamp("created").toLocalDateTime();
			loadedSolution.updated = resultSet.getTimestamp("updated").toLocalDateTime();
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			return loadedSolution;
		}
		return null;
	}

	static public Solution[] loadAll(Connection conn) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM Solution";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getTimestamp("created").toLocalDateTime();
			loadedSolution.updated = resultSet.getTimestamp("updated").toLocalDateTime();
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		return sArray;
	}
	
	static public Solution[] loadAllByUserId(Connection conn, int users_id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM Solution WHERE users_id=?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, users_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getTimestamp("created").toLocalDateTime();
			loadedSolution.updated = resultSet.getTimestamp("updated").toLocalDateTime();
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		return sArray;
	}
	
	static public Solution[] loadAllByExerciseId(Connection conn, int exercise_id) throws SQLException {
		ArrayList<Solution> solutions = new ArrayList<Solution>();
		String sql = "SELECT * FROM Solution where exercise_id=? ORDER BY IFNULL(updated, created) DESC";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, exercise_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getTimestamp("created").toLocalDateTime();
			loadedSolution.updated = resultSet.getTimestamp("updated").toLocalDateTime();
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions.add(loadedSolution);
		}
		Solution[] sArray = new Solution[solutions.size()];
		sArray = solutions.toArray(sArray);
		return sArray;
	}
	
	public void delete(Connection conn) throws SQLException {
		if (this.id != 0) {
			String sql = "DELETE FROM Solution WHERE id= ?";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, this.id);
			preparedStatement.executeUpdate();
			this.id = 0;
		}
	}
	
	public Solution[] loadAll(Connection conn, int limit) throws SQLException{
	
		Solution[] solutions = new Solution[limit];
		String sql = "SELECT * FROM Solution ORDER BY created DESC LIMIT ?";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, limit);
		ResultSet resultSet = preparedStatement.executeQuery();
		int i = 0;
		while (resultSet.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.id = resultSet.getInt("id");
			loadedSolution.created = resultSet.getTimestamp("created").toLocalDateTime();
			loadedSolution.updated = resultSet.getTimestamp("updated").toLocalDateTime();
			loadedSolution.description = resultSet.getString("description");
			loadedSolution.exercise_id = resultSet.getInt("exercise_id");
			loadedSolution.users_id = resultSet.getInt("users_id");
			solutions[i] = loadedSolution;
			i++;
		}
		return solutions;
	}

}