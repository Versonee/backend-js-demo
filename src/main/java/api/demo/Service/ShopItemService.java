package api.demo.Service;

import api.demo.Model.ShopItem;
import api.demo.Repository.ShopItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopItemService {
    private final ShopItemRepository shopItemRepository;

    public List<ShopItem> getShopItems() {
        return shopItemRepository.findAll();
    }

    public void addShopItem(ShopItem shopItem) {
        shopItemRepository.save(shopItem);
    }
    public void deleteShopItem(Long id){
        shopItemRepository.deleteShopItemById(id);
    }
    public ShopItem getShopItemById(Long id){
        return shopItemRepository.getShopItemById(id);
    }
}
