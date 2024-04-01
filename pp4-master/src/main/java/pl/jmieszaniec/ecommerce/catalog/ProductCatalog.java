package pl.jmieszaniec.ecommerce.catalog;

import pl.jmieszaniec.ecommerce.catalog.Product;

import java.math.BigDecimal;
import java.util.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private  ArrayList<Product> products;
    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }
    public ProductCatalog(){
        this.products= new ArrayList<>();
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct= new Product(id, name, description);

        products.add(newProduct);
        
        return newProduct.getId();
    }



    public Product getProduct(String id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }
    public void changePrice(String id, BigDecimal newPrice) {
        Product loaded = this.getProduct(id);
        loaded.changePrice(newPrice);
    }
}
