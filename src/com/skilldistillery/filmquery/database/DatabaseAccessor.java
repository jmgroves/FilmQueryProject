package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	public Film getFilmById(int filmId) throws SQLException;

	public Actor getActorById(int actorId) throws SQLException;

	public List<Actor> getActorsByFilmId(int filmId) throws SQLException;

	public List<Film> getFilmsBySearchWord(String search) throws SQLException;
	
	public void rentalCopies (int id) throws SQLException;
}
