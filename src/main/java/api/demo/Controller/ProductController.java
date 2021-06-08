package api.demo.Controller;

import api.demo.Controller.RequestModel.ProductRequestModel;
import api.demo.Model.Product;
import api.demo.Model.Shop;
import api.demo.Service.ProductService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Data
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    public final ProductService productService;

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getShops() {
        return productService.getProducts();
    }

    @PostMapping("/add-product")
    @ResponseBody
    public void addProduct(@RequestBody ProductRequestModel model) {
        productService.addProduct(new Product(model.name, model.producers));
    }
}
