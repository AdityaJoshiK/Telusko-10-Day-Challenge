package com.product;

import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    
    List<Product> products = new ArrayList<>();
    ProductDB db = new ProductDB();

    public void addProduct(Product p) throws SQLException {
        // products.add(p);
        db.save(p);
    }

    public List<Product> getAllProducts() throws SQLException
    {
        return db.getAll();
    }

    /*Assignment 1-Search By Place */
    public List<Product> getByPlace(String place) {
        List<Product> productsAtPlace = products.stream()
                .filter(product -> product.getPlace().equalsIgnoreCase(place))
                .collect(Collectors.toList());
    
        return productsAtPlace;
    }
    

    /*Assignment 2- Products Which Are Out Of Warranty */
    public List<Product> getOutOfWarranty()
    {
        int year = Year.now().getValue();

        List<Product> productsByWarranty = products.stream()
        .filter(products -> products.getWarranty() < year)
        .collect(Collectors.toList());

        return productsByWarranty;      

    }

    /*Assignment 1 - get Product From DB */
    public Product getProduct(String name) throws SQLException {
        Product p = db.getProduct(name);

        return p;
        
}


    /*Assignment-3:Converted To Stream API */
    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(str)
                        || p.getType().toLowerCase().contains(str)
                        || p.getPlace().toLowerCase().contains(str))
                .collect(Collectors.toList());
    }
    
}
