package api.demo.Controller;

import api.demo.Controller.RequestModel.FiltersRequestModel;
import api.demo.Controller.RequestModel.ShopItemRequestModel;
import api.demo.Model.Product;
import api.demo.Model.Promotion;
import api.demo.Model.Shop;
import api.demo.Model.ShopItem;
import api.demo.Service.ProductService;
import api.demo.Service.ShopItemService;
import api.demo.Service.ShopService;
import lombok.Data;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Data
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShopItemController {

    public final ShopItemService shopItemService;
    public final ShopService shopService;
    public final ProductService productService;

    @GetMapping("/shop-items")
    @ResponseBody
    public List<ShopItem> getShops() {
        return shopItemService.getShopItems();
    }

    @RequestMapping("/add-shop-item")
    @ResponseBody
    public void addShopItem(@RequestBody ShopItemRequestModel model) {
        shopItemService.addShopItem(new ShopItem(
                model.price,
                model.available,
                model.shop,
                model.product,
                model.promotion));
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<ShopItem> search(@RequestParam("price") int n) {
        System.out.println(n);
        return shopItemService.getShopItems();
    }
}