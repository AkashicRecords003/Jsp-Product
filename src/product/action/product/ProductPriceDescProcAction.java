package product.action.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import product.action.Action;
import product.model.Product;
import product.repository.ProductRepository;

public class ProductPriceDescProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		ProductRepository productRepository = ProductRepository.getInstance();
		
		List<Product> products = productRepository.findAllPriceDesc();
		
		String productsJson = gson.toJson(products);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.println(productsJson);

		
	}

}

