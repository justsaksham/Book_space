package Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.DAO;
import Model.Book;
import Model.Result;


public class Repository {
private DAO dao;
{
	dao=new DAO();
}
	public Result create(Book book) {
		long id=getTimeStamp();
		book=new Book(book,id);
		dao.save(book);
		List<Book> list=new ArrayList<Book>();
		list.add(book);
		return getResult(list);
	}
	public Result getAllBooks(){
		return  getResult(dao.getAll());
	}
	public Result getBook(long id) {
		Book b=dao.getBook(id);

		List<Book> list=new ArrayList<Book>();
		if(b!=null)
		list.add(b);
		return getResult(list);
	}
	public Result getBookbyName(String name) {
		if(name!=null)
		return getResult(dao.getBookByName(name));
		else {
			return getResult("failure","please provide name of book");
		}
	}
	public Result deleteBook(long id) {
		Book b=dao.deleteBook(id);
		List<Book> list=new ArrayList<Book>();
		if(b!=null)
		list.add(b);
		return getResult(list);
	}
	
	public Result updateBook(Book book) {
		Book b=dao.UpadteBook(book);
		List<Book> list=new ArrayList<Book>();
		if(b!=null) {
			list.add(b);
		}
		return getResult(list);
	}
	
	private long getTimeStamp(){
		return System.currentTimeMillis();
	}
	private Result getResult(List<Book> list) {
		Result l=new Result();
		if(list.size()>0) {
		l.setResult("success");
		l.setStatus("OK");
		}
		else {
			l.setResult("failure");
			l.setStatus("No book found");
			return l;
		}
		l.getMap().put("data", list);
		return l;
	}
	public Result getResult(String result,String status) {
		Result l=new Result();
		l.setResult(result);
		l.setStatus(status);
		return l;
	}
}
