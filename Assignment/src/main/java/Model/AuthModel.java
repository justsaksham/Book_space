package Model;

public class AuthModel {
private String key;
private long id;
private String bookName;

public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
@Override
public String toString() {
	return "AuthModel [key=" + key + ", id=" + id + ", bookName=" + bookName + "]";
}


}
