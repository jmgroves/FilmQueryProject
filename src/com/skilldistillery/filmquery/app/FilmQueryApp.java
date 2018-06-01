package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.getFilmById(1);
		System.out.println(film);
	}

	private void launch() throws SQLException {

		startUserInterface();

		input.close();
	}

	private void startUserInterface() throws SQLException {
		int choice = 0;
		do {
			printMenu();
			choice = input.nextInt();
			if (choice < 1 || choice > 3) {
				System.out.println("Invalid input, do again");
			}
		} while (choice < 1 && choice > 3);
		selection(choice);

	}

	private void selection(int choice) throws SQLException {
		if (choice == 1) {
			System.out.println("Please enter the id");
			int id = input.nextInt();
			Film film = db.getFilmById(id);
			if (film == null) {
				System.out.println("Film not found");
			} else {
				System.out.println("Would you like to see all the movies details?\n[Y]\n[N]");
				input.nextLine();
				String userDetail = input.nextLine();
				if (userDetail.equalsIgnoreCase("y")) {
					System.out.println(film.printFullDescription());
				} else {
					System.out.println(film);
				}
			}
			startUserInterface();
		}
		if (choice == 2) {
			System.out.println("Please enter a search term");
			input.nextLine();
			String search = input.nextLine();
			List<Film> filmList = db.getFilmsBySearchWord(search);
			if (filmList.isEmpty()) {
				System.out.println("There are no films matching that description");
			} else {
				System.out.println(filmList);
				startUserInterface();
			}

		}
		if (choice == 3) {
			System.out.println("Ok, goodbye");
			System.exit(0);
		}
	}

	private void printMenu() {
		System.out.println("What would you like to do?");
		System.out.println("[1] - Look up a film by its id");
		System.out.println("[2] - Look up a film by a search keyword");
		System.out.println("[3] - Exit the application");
	}

}
