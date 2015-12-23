package ch07;

public class Book {
	String title;
	int price;
	Author author;
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the autor
	 */
	public Author getAutor() {
		return author;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Author author) {
		this.author = author;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime + result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Book other = (Book) obj;
		if (author == null) {
			if ( other.author != null) return false;
		} else if (!author.equals(other.author)) return false;
		if (price != other.price) return false;
		if (title == null) {
			if (other.title != null) return false;
		} else if (!title.equals(other.title)) return false;
		return true;
		
		
	}
	
}
