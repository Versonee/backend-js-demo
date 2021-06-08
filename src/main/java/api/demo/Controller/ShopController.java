package api.demo.Controller;

import api.demo.Controller.RequestModel.ShopRequestModel;
import api.demo.Model.Shop;
import api.demo.Service.ShopService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@Data
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShopController {

    public final ShopService shopService;

    @GetMapping("/shops")
    @ResponseBody
    public List<Shop> getShops() {
        return shopService.getShops();
    }

    @PostMapping("/add-shop")
    @ResponseBody
    public void addShop(@RequestBody ShopRequestModel shopRequest) {
        shopService.addShop(new Shop(shopRequest.name, Collections.emptyList()));
    }
}
