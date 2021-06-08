package api.demo.Controller;

import api.demo.Controller.RequestModel.PromotionRequestModel;
import api.demo.Model.Promotion;
import api.demo.Model.Shop;
import api.demo.Model.Type.PromotionType;
import api.demo.Service.PromotionService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Data
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PromotionController {

    public final PromotionService promotionService;

    @GetMapping("/promotions")
    @ResponseBody
    public List<Promotion> getPromotions() {
        return promotionService.getPromotions();
    }

    @GetMapping("/promotion-types")
    @ResponseBody
    public List<PromotionType> getPromotionTypes() {
        return promotionService.getPromotionTypes();
    }

    @PostMapping("/add-promotion")
    @ResponseBody
    public void addShop(@RequestBody PromotionRequestModel model) {
        promotionService.addPromotion(new Promotion(model.name, PromotionType.valueOf(model.type), model.value));
    }
}

