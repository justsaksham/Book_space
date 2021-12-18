package Controllers;

import java.util.List;
import java.util.Map;

import com.blade.mvc.RouteContext;
import com.blade.mvc.annotation.BodyParam;
import com.blade.mvc.annotation.DeleteRoute;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.annotation.PutRoute;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.http.HttpResponse;
import com.blade.mvc.http.Response;
import com.blade.security.web.cors.CorsConfiger;
import com.blade.security.web.cors.CorsMiddleware;

import Model.AuthModel;
import Model.Book;
import Model.Result;
import Model.UpdateModel;
import Repository.Repository;

@Path("BookStore")
public class BookController {
	private final String API_KEY="123";
	private Repository reso;
	{
		reso=new Repository();
		
	}
	@PostRoute("create")
	@JSON
	public Result create(RouteContext ctx ,@BodyParam UpdateModel updateModel) {
		setCors(ctx);
		 if(updateModel.getKey()!=null && updateModel.getKey().equals(API_KEY))
				return reso.create(updateModel.getBook());
		 else if(updateModel.getKey()==null)
				return reso.getResult("Failure "," API key is not sent");
			else {
				return reso.getResult("Failure "," API key is invalid");
			}	
		 
		}
	
	@Route(value = "getAllBooks", method = HttpMethod.OPTIONS)
	public void options(RouteContext ctx) {
		//"Origin, X-Requested-With, Content-Type, Accept, Authorization, Methods"
		ctx.response().header("Access-Control-Allow-Origin","*");
		ctx.response().header("Access-Control-Allow-Headers","*");
		ctx.response().header("Access-Control-Allow-Methods",CorsConfiger.DEFAULT_ALLOWED_METHODS);
		
	   }
	@GetRoute("getAllBooks")
	@JSON
	public Result getAllBooks(RouteContext ctx) {
		setCors(ctx);
	return reso.getAllBooks();
	}
	
	@PostRoute("getBook")
	@JSON
	public Result getBook(RouteContext ctx,@BodyParam AuthModel auth) {
		setCors(ctx); 
		return reso.getBook(auth.getId());
	}
	
	@PostRoute("getBooksByName")
	@JSON
	public Result getBooksByName(RouteContext ctx , @BodyParam AuthModel auth) {
		setCors(ctx);
		return reso.getBookbyName(auth.getBookName());
	}
	
	@DeleteRoute("deleteBook")
	@JSON
	public Result deleteBook(RouteContext ctx ,@BodyParam AuthModel auth) {
		try{
			setCors(ctx);
		
		if(auth.getKey()!=null && auth.getKey().equals(API_KEY))
		return reso.deleteBook(auth.getId());
		else if(auth.getKey()==null)
			return reso.getResult("Failure "," API key is not sent");
		else {
			return reso.getResult("Failure "," API key is invalid");
		}
	}
	catch(Exception e){
		return reso.getResult("Failure "," Something happened w");
		
	}
	}
	
	 @PutRoute("update")
	 @JSON()
	 public Result updateBook(RouteContext ctx ,@BodyParam UpdateModel updateModel) {
		 try{
			 setCors(ctx);
		 if(updateModel.getKey()!=null && updateModel.getKey().equals(API_KEY))
				return reso.updateBook(updateModel.getBook());
		 else if(updateModel.getKey()==null)
				return reso.getResult("Failure "," API key is not sent");
			else {
				return reso.getResult("Failure "," API key is invalid");
			}	
		 }
		 catch(Exception e) {
			 return reso.getResult("Failure "," Something unexpected happened");
		 }
	 }
	 
	 private void setCors(RouteContext ctx) {
		 ctx.response().header("Access-Control-Allow-Origin","*");
			ctx.response().header("Access-Control-Allow-Headers","*");
			ctx.response().header("Access-Control-Allow-Methods",CorsConfiger.DEFAULT_ALLOWED_METHODS);
			
	 }
	
	
}
