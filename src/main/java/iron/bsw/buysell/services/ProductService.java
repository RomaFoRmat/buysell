package iron.bsw.buysell.services;

import iron.bsw.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID,"PlayStation 4 ", "Slim 500GB", 575, "Zhlobin", "Roman"));
        products.add(new Product(++ID,"Iphone XR ", "Simple description", 1250, "Minsk", "Alex"));
    }

    public List<Product> productList() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
