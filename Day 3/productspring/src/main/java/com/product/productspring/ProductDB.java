package com.product.productspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDB extends JpaRepository<Product,Integer>{

  Product findByName(String name);

  @Query("SELECT p FROM Product p WHERE p.warranty<YEAR(CURRENT_DATE)")
  List<Product> findproductsoutofWarranty();

  @Query("SELECT p FROM Product p WHERE LOWER(p.place) LIKE %:place%")
  List<Product> findbyplace(String place);

  @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:text% OR LOWER(p.type) LIKE %:text% OR LOWER(p.place) LIKE %:text%")
  List<Product> findByText(String text);
    
}
