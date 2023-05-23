package com.productspringweb.productspringweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductController {
    
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{name}")
    public  List<Product> getProduct(@PathVariable String name)
    {
        return service.getProductByName(name);
    }

    @GetMapping("/products/findall/{name}")
    public  List<Product> getByText(@PathVariable String name)
    {
        return service.getProductWithText(name);
    }

    @GetMapping("/products/place/{place}")
    public  List<Product> getPlace(@PathVariable String place)
    {
        return service.getByPlace(place);
    }

    @GetMapping("/products/outwarranty")
    public  List<Product> getOutOfWarranty()
    {
        return service.getOutOfWarranty();
    }

    @GetMapping("/products/countoutwarranty")
    public  int countOutOfWarranty()
    {
        return service.countOutOfWarranty();
    }

    @GetMapping("/products/countproducts")
    public  int countproducts()
    {
        return service.countproducts();
    }

    @GetMapping("/products/counttypes")
    public  int counttypes()
    {
        return service.counttypes();
    }

    @GetMapping("/products/countplaces")
    public  int countplaces()
    {
        return service.countplaces();
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product p)
    {
        service.addProduct(p);
    }
}
