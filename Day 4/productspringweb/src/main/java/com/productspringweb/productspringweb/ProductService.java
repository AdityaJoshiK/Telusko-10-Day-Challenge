package com.productspringweb.productspringweb;

import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    
       @Autowired
       ProductDB db;

       public void show()
       {
        System.out.println("in show");
       }
//     List<Product> products = new ArrayList<>();
//     ProductDB db = new ProductDB();

    public void addProduct(Product p)  {
        db.save(p);
    }

    public List<Product> getAllProducts()
    {
        System.out.println("\nHi\n");
        return db.findAll();
    }

    /*Assignment 1-Search By Place */
    public List<Product> getByPlace(String place) {
        // return db.findbyplace(place.toLowerCase());
        return db.findByPlace(place);
    }
    

    /*Assignment 2- Products Which Are Out Of Warranty */
    public List<Product> getOutOfWarranty()
    {
        return db.findproductsoutofWarranty();

    }

    public int countOutOfWarranty()
    {
        return db.countproductsoutofWarranty();

    }

    public int countproducts()
    {
        return db.totalproducts();

    }

    public int counttypes()
    {
        return db.totaltypes();

    }
    public int countplaces()
    {
        return db.totalplaces();

    }

    /*Assignment 1 - get Product From DB */
    public  List<Product> getProductByName(String name) {
        return db.findByName(name);
        
}


    /*Assignment-3:Converted To Stream API */
    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        return db.findByText(str);
    }
    
}
