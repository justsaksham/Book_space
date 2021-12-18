package Model;

public class Book{
private long Id;

@Override
public String toString() {
	return "Book [Id=" + Id + ", BookName=" + BookName + ", AuthorName=" + AuthorName + ", description=" + description
			+ ", price=" + price + ", publisher=" + publisher + "]";
}
private String BookName;
private String AuthorName;
private String description;
private String price;
private String publisher;

public Book() {
	
}
public Book(Book b,long id) {
	this.AuthorName=b.AuthorName;
	this.BookName=b.BookName;
	this.description=b.description;
	this.price=b.price;
	this.publisher=b.publisher;
	this.Id=id;
}
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public String getBookName() {
	return BookName;
}
public void setBookName(String bookName) {
	BookName = bookName;
}

public String getAuthorName() {
	return AuthorName;
}
public void setAuthorName(String authorName) {
	AuthorName = authorName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public Book clone(Book b) {
	this.AuthorName=b.AuthorName;
	this.BookName=b.BookName;
	this.description=b.description;
	this.price=b.price;
	this.publisher=b.publisher;
	this.Id=b.Id;
	return this;
}
}
