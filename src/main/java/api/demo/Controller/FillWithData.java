package api.demo.Controller;


import api.demo.Model.*;
import api.demo.Model.Type.PromotionType;
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
        addPromotions();
        addProducers();
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

    private List<Promotion> addPromotions() {
        List<String> promotions = new ArrayList<>(List.of(
                "Promocja 1",
                "Promocja 2"
        ));
        for (String s : promotions) {
            promotionService.addPromotion(new Promotion(s, PromotionType.BASIC, 10));
        }
        return promotionService.getPromotions();
    }
    private List<Producer> addProducers() {
        List<String> producers = new ArrayList<>(List.of(
                "Producent 1",
                "Producent 2",
                "Producent 3"
        ));
        for (String s : producers) {
            producerService.addProducer(new Producer(s));
        }
        return producerService.getProducers();
    }




}

