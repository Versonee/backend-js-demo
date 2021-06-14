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

import javax.transaction.Transactional;
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
        return shopItemService.getShopItems();
    }

    @Transactional
    @DeleteMapping("/delete-shop-item/{id}")
    @ResponseBody
    public void deleteShopItem(@PathVariable Long id) {
        shopItemService.deleteShopItem(id);
    }

    @Transactional
    @PutMapping("/update-shop-item/{id}")
    @ResponseBody
    public void updateShopItem(@PathVariable Long id, @RequestBody ShopItemRequestModel model) {
        ShopItem item = shopItemService.getShopItemById(id);
        item.setAvailable(model.available);
        item.setPrice(model.price);
        item.setProduct(model.product);
        item.setShop(model.shop);
        item.setPromotion(model.promotion);
        shopItemService.addShopItem(item);
    }
}