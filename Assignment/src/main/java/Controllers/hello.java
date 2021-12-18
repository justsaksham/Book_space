package Controllers;

import com.blade.Blade;
import com.blade.security.web.cors.CorsConfiger;


public class hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Blade.of().get("/",ctx -> {ctx.text("Hello Blade");
		
		
		}).listen(9000).start();
		
	}

}
