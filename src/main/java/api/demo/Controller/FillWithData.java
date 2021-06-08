package api.demo.Controller;


import api.demo.Model.*;
import api.demo.Service.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@RestController
@Data
public class FillWithData {

    public final ShopService shopService;
    public final ShopItemService shopItemService;
    public final PromotionService promotionService;
    public final ProducerService producerService;
    public final ProductService productService;

    @CrossOrigin(origins = "*")
    @GetMapping("/generate-data")
    @ResponseBody
    public String generateShops() {
        addShops();
        addShopItems();
        addPromotions();
        addProducers();
        addProducts();
        return "Przykładowe dane zostały wygenerowane i zapisane w bazie";
    }

    private List<Shop> addShops() {
        List<String> shops = new ArrayList<>(List.of(
                "Biedronka",
                "Stokrotka",
                "Tesco",
                "Kaufland"
        ));
        for (String s : shops) {
            shopService.addShop(new Shop(s, Collections.emptyList()));
        }
        return shopService.getShops();
    }
    private List<ShopItem> addShopItems() {
        for (int i = 0; i < 20; i++) {
            shopItemService.addShopItem(new ShopItem());
        }
        return shopItemService.getShopItems();
    }

    private List<Promotion> addPromotions() {
        for (int i = 0; i < 2; i++) {
            promotionService.addPromotion(new Promotion());
        }
        return promotionService.getPromotions();
    }
    private List<Producer> addProducers() {
        for (int i = 0; i < 10; i++) {
            producerService.addProducer(new Producer());
        }
        return producerService.getProducers();
    }
    private List<Product> addProducts() {
        for (int i = 0; i < 10; i++) {
            productService.addProduct(new Product());
        }
        return productService.getProducts();
    }



}

