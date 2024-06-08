package pl.jmieszaniec.ecommerce.catalog;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class JdbcProductStorageTest {
    @Test
    void itAllowToStoreProduct() {
        Product product = thereIsExampleProduct();

        ProductStorage hasMapStorage = thereIsExampleHashMapStorage();

        hasMapStorage.add(product);

        List<Product> products = hasMapStorage.allProducts();
        Assertions.assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains("test-it");



    }

    private ProductStorage thereIsExampleHashMapStorage() {
        return new HashMapProductStorage();
    }

    private Product thereIsExampleProduct() {
        return new Product(UUID.randomUUID(), "test-it", "test");
    }

    @Test
    void itAllowsToLoadAllProduct() {

    }

    @Test
    void itAllowsToLoadProductById() {

    }
}
