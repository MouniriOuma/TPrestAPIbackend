package com.ws.tprestapi;

import java.util.ArrayList;
import java.util.List;
public class ProductDAO {
    private static ProductDAO instance;
    private static List<Product> data = new ArrayList<>();
    static {
        data.add(new Product(1, "TV", 3000," TV sumsung 42'"));
        data.add(new Product(2, "Chargeur", 200,"Chargeur type C 3m"));
    }
    private ProductDAO() {
    }
    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }
    public List<Product> listAll() {
        return new ArrayList<Product>(data);
    }
    public int add(Product product) {
        if (product != null) {
            int newId = data.size() + 1;
            product.setId(newId);
            data.add(product);
            return newId;
        } else {
            return -1;
        }
    }
    public Product get(int id) {
        Product productToFind = new Product(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }
    public boolean delete(int id) {
        Product productToFind = new Product(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }
        return false;
    }
    public boolean update(Product product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }

}

