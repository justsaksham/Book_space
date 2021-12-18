package DAO;

import java.util.List;
import java.util.ArrayList;

import Model.Book;

public class DAO {
public static ArrayList<Book> list;
public DAO(){
	list=new ArrayList<Book>();
}
public void save(Book book) {
	list.add(book);
}
public List<Book> getAll(){
	return list;
}
public Book getBook(long id) {
	
	for(Book b:list) {
		if(id==b.getId()) {
			return b;
		}
	}
	return null;
}
public Book deleteBook(long id) {
	for(Book b:list) {
		if(id==b.getId()) {
			list.remove(b);
			return b;
		}
	}
	return null;
}
public List<Book> getBookByName(String name){
	List<Book> l=new ArrayList<Book>();
	for(Book b:list) {
		if(b.getBookName().toLowerCase().equals(name.toLowerCase())) {
			l.add(b);
		}
	}
	return l;
	
}
public Book UpadteBook(Book book) {
	int flag=0;
	Book tempBook = null;
	for(Book b:list) {
		if(b.getId()==book.getId()) {
			flag=1;
			tempBook=b;
			break;
			
		}
	}
	if(flag==1) {
		//list.remove(tempBook);
	//	list.add(book);
		tempBook.clone(book);
		return book;
	}
	else {
		return null;
	}
}
}
