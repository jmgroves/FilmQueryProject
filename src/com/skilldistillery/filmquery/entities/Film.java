package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private String language;
	private int rentalDuration;
	private double rentalRates;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String category;
	private List<Actor> actorList;
	public Film() {		
	}
	
	public Film(int id, String title, String category, String description, int releaseYear, String language, int languageId, int rentalDuration,
			double rentalRates, int length, double replacementCost, String rating, String specialFeatures, List<Actor> actorList) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.releaseYear = releaseYear;
		this.language = language;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRates = rentalRates;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actorList = actorList;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalRates() {
		return rentalRates;
	}
	public void setRentalRates(double rentalRates) {
		this.rentalRates = rentalRates;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRates);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRates) != Double.doubleToLongBits(other.rentalRates))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("\nTitle: ");
		builder.append(title);
		builder.append("\nCategory: ");
		builder.append(category);
		builder.append("\nRelease Year: ");
		builder.append(releaseYear);
		builder.append("\nDescription: ");
		builder.append(description);
		builder.append("\nLanguage: ");
		builder.append(language);
		builder.append("\nRating: ");
		builder.append(rating);
		builder.append("\nActor List: ");
		for (Actor actor : actorList) {
			builder.append(actor);
			builder.append(", ");
		}
		builder.append("\n\n");
		return builder.toString();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String printFullDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nFilm id: ");
		builder.append(id);
		builder.append("\nTitle: ");
		builder.append(title);
		builder.append("\nRelease Year: ");
		builder.append(releaseYear);
		builder.append("\nCategory: ");
		builder.append(category);
		builder.append("\nDescription: ");
		builder.append(description);
		builder.append("\nLanguage id: ");
		builder.append(languageId);
		builder.append("\nLanguage: ");
		builder.append(language);
		builder.append("\nRental Duration: ");
		builder.append(rentalDuration);
		builder.append("\nRental Rate: ");
		builder.append(rentalRates);
		builder.append("\nLength: ");
		builder.append(length);
		builder.append("\nReplacement Cost: ");
		builder.append(replacementCost);
		builder.append("\nRating: ");
		builder.append(rating);
		builder.append("\nSpecial Features: ");
		builder.append(specialFeatures);
		builder.append("\nActor List: ");
		for (Actor actor : actorList) {
			builder.append(actor);
			builder.append(", ");
		}
		builder.append("\n\n");
		return builder.toString();

	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
