package com.productspringweb.productspringweb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDB extends JpaRepository<Product,Integer>{

  @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:name%")
  List<Product> findByName(@Param("name") String name);//used list because i have multiple product with same name

  @Query("SELECT p FROM Product p WHERE p.warranty<YEAR(CURRENT_DATE)")
  List<Product> findproductsoutofWarranty();

  @Query("SELECT count(p) FROM Product p WHERE p.warranty<YEAR(CURRENT_DATE)")
  int countproductsoutofWarranty();

  @Query("SELECT count(p) FROM Product p")
  int totalproducts();

  @Query("SELECT COUNT(DISTINCT type) FROM Product")
  int totaltypes();

  @Query("SELECT COUNT(DISTINCT place) FROM Product")
  int totalplaces();

  @Query("SELECT p FROM Product p WHERE LOWER(p.place) LIKE %:place%")
  List<Product> findByPlace(@Param("place") String place);
  

  @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:text% OR LOWER(p.type) LIKE %:text% OR LOWER(p.place) LIKE %:text%")
  List<Product> findByText(String text);
    
}
