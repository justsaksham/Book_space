package Controllers;

import com.blade.mvc.RouteContext;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.security.web.cors.CorsConfiger;
@Path("BookStore")
public class FlightController {
	@Route(value = { "getAllBooks","create","getBook","getBooksByName","deleteBook","update"}, method = HttpMethod.OPTIONS)
	public void options(RouteContext ctx) {
		//"Origin, X-Requested-With, Content-Type, Accept, Authorization, Methods"
		ctx.response().header("Access-Control-Allow-Origin","*");
		ctx.response().header("Access-Control-Allow-Headers","*");
		ctx.response().header("Access-Control-Allow-Methods",CorsConfiger.DEFAULT_ALLOWED_METHODS);
		
	   }
	
}
