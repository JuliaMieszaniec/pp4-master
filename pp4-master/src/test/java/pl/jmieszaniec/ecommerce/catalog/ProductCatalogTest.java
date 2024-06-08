package pl.jmieszaniec.ecommerce.catalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {
    private ProductCatalog ProductCatalog() {
        return new ProductCatalog(new ArrayListProductStorage());
    }
    @Test
    void itListsProducts(){
        ProductCatalog catalog= ProductCatalog();
        List<Product> products= catalog.allProducts();

        assert products.isEmpty();
    }
    @Test
    void itAllowsToAddProduct(){
        ProductCatalog catalog= ProductCatalog();
        catalog.addProduct("lego set", "nice");
        List<Product> allProducts= catalog.allProducts();

        assertThat(allProducts).hasSize(1);
    }
    void itLoadsProductById(){
        ProductCatalog catalog= ProductCatalog();
        String id= catalog.addProduct("Lego set 8083", "nice one");
        Product loadedProduct = catalog.getProductBy(id);
        assertThat(loadedProduct.getId()).isEqualTo(id);
    }
    void itAllowsToChangePrice(){
        ProductCatalog catalog= ProductCatalog();
        String id= catalog.addProduct("Lego set 8083", "nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProductBy(id);

        assertThat(BigDecimal.valueOf(10.10)).isEqualTo(loaded.getPrice());
    }

}
