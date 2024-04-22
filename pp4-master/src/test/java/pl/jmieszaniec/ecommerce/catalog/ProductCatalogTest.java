package pl.jmieszaniec.ecommerce.catalog;
import org.junit.jupiter.api.Test;
import pl.jmieszaniec.ecommerce.catalog.Product;
import pl.jmieszaniec.ecommerce.catalog.ProductCatalog;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {
    @Test
    void itListsProducts(){
        ProductCatalog catalog= new ProductCatalog();
        List<Product> productList= catalog.allProducts();

        assertThat(productList).hasSize(0);
    }
    @Test
    void itAllowsToAddProduct(){
        ProductCatalog catalog= new ProductCatalog();
        catalog.addProduct("lego set", "nice");
        List<Product> productList= catalog.allProducts();

        assertThat(productList).hasSize(1);
    }
    void itLoadsProductDetails(){
        ProductCatalog catalog= new ProductCatalog();
        String id= catalog.addProduct("Lego set 8083", "nice one");
        Product loadeProduct = catalog.getProduct(id);
        assertThat(id).isEqualTo(loadeProduct.getId());
    }
    void itAllowsToChangePrice(){
        ProductCatalog catalog= new ProductCatalog();
        String id= catalog.addProduct("Lego set 8083", "nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProduct(id);

        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loaded.getPrice());
    }
    private static ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }
}
