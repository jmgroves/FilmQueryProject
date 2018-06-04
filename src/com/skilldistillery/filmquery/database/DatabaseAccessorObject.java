package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static String url = "jdbc:mysql://localhost:3306/sdvid";

	@Override
	public Film getFilmById(int filmId) throws SQLException {
		if (filmId <= 0) {
			return null;
		}

		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sqltext;
		sqltext = "Select * from film f JOIN language l ON l.id = f.language_id JOIN film_category fc ON f.id = fc.film_id JOIN category c ON c.id = fc.category_id WHERE f.id = ?";

		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmId);

		ResultSet rs = stmt.executeQuery();
		Film film = new Film();
		if (rs.next()) {
			int filmId2 = rs.getInt(1);
			String title = rs.getString(2);
			String desc = rs.getString(3);
			short releaseYear = rs.getShort(4);
			int langId = rs.getInt(5);
			int rentDur = rs.getInt(6);
			double rate = rs.getDouble(7);
			int length = rs.getInt(8);
			double repCost = rs.getDouble(9);
			String rating = rs.getString(10);
			String features = rs.getString(11);
			String language = rs.getString(13);
			String category = rs.getString(17);

			film = new Film(filmId2, title, category, desc, releaseYear, language, langId, rentDur, rate, length,
					repCost, rating, features, getActorsByFilmId(filmId));
		}
		rs.close();
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public Actor getActorById(int actorId) throws SQLException {

		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sqltext;
		sqltext = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, actorId);

		ResultSet rs = stmt.executeQuery();
		Actor actor = new Actor();
		if (rs.next()) {
			int id = rs.getInt(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);

			actor = new Actor(id, firstName, lastName);
		}
		rs.close();
		stmt.close();
		conn.close();
		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sqltext;
		sqltext = "SELECT actor_id FROM film JOIN film_actor ON film.id = film_actor.film_id " + " WHERE film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		List<Actor> list = new ArrayList<Actor>();
		while (rs.next()) {
			list.add(getActorById(rs.getInt(1)));
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}

	@Override
	public List<Film> getFilmsBySearchWord(String search) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sqltext;
		sqltext = "SELECT id FROM film WHERE title LIKE ? OR description LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setString(1, "%" + search + "%");
		stmt.setString(2, "%" + search + "%");
		ResultSet rs = stmt.executeQuery();
		List<Film> filmList = new ArrayList<Film>();
		while (rs.next()) {
			filmList.add(getFilmById(rs.getInt(1)));
		}
		rs.close();
		stmt.close();
		conn.close();
		return filmList;
	}

	@Override
	public void rentalCopies(int filmId) throws SQLException {
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sqltext;
		sqltext = "SELECT i.id, i.media_condition FROM Inventory_item i where i.film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		System.out.println("RENTAL DETAILS\n");
		while (rs.next()) {
			System.out.print("Rental ID: " + rs.getInt(1) + "\t" + "Rental Condition: " + rs.getString(2) + "\n");
		}
		rs.close();
		stmt.close();
		conn.close();

	}

}
