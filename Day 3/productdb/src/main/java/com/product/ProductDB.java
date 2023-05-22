package com.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn = null;

    public ProductDB(){
        try {
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya","root","2107");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void save(Product p) throws SQLException {
        String query = "INSERT INTO aditya.Product (name, type, place, warranty) VALUES (?,?,?,?);";

        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, p.getName());
        st.setString(2, p.getType());
        st.setString(3, p.getPlace());
        st.setInt(4, p.getWarranty());
        st.execute();
    }

    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();

        String query = "Select name,type,place,warranty From aditya.product";

        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();

        while(rs.next())
        {
            Product p = new Product();
            p.setName(rs.getString("name"));
            p.setType(rs.getString("type"));
            p.setPlace(rs.getString("place"));
            p.setWarranty(rs.getInt("warranty"));
            products.add(p);
        }

        return products;
    }

    public Product getProduct(String name) throws SQLException {
        String query = "Select name,type,place,warranty From aditya.product where name=?";

        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, name);
        ResultSet rs = st.executeQuery();

        while(rs.next())
        {
            Product p = new Product();
            p.setName(rs.getString("name"));
            p.setType(rs.getString("type"));
            p.setPlace(rs.getString("place"));
            p.setWarranty(rs.getInt("warranty"));
            return p;
        }

        return null;
    }
    
}
