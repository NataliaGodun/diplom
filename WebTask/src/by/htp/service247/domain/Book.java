package by.htp.service247.domain;

import java.io.Serializable;

/**
 * @author Godun Natalia
 * @version 1.0
 */
public class Book implements Serializable {

	private static final long serialVersionUID = 2661300046083956194L;

	private int id;
	private String writer;
	private String nameBook;
	private String image;
	private String genre;
	private String house;
	private String year;

	public Book() {

	}

	public Book(int id, String writer, String nameBook, String image, String genre, String house, String year) {
		super();
		this.id = id;
		this.writer = writer;
		this.nameBook = nameBook;
		this.image = image;
		this.genre = genre;
		this.house = house;
		this.year = year;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((nameBook == null) ? 0 : nameBook.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Book other = (Book) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (nameBook == null) {
			if (other.nameBook != null)
				return false;
		} else if (!nameBook.equals(other.nameBook))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	public String toString() {
		return "Id: " + this.id + ", writer: '" + this.writer + ", name book: " + this.nameBook + ", genre: "
				+ this.genre + ", publishing house: " + this.house + ", year: " + this.year;
	}
}
