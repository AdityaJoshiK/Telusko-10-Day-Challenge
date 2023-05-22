package com.product.productspring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductspringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductspringApplication.class, args);

		ProductService service = context.getBean(ProductService.class);
		// service.show();

		service.addProduct(new Product("USB", "Cable", "Black Drawer", 2024));

		
		List<Product> products = service.getAllProducts();

		
		Product p = service.getProduct("Apple Mouse");
        System.out.println(p);
	}

}
