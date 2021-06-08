package api.demo.Service;

import api.demo.Model.Product;
import api.demo.Model.ShopItem;
import api.demo.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProduct(Long id){
        return productRepository.getProductById(id);
    }
}
