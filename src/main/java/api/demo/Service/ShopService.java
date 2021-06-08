package api.demo.Service;

import api.demo.Model.Shop;
import api.demo.Repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public List<Shop> getShops() {
        return shopRepository.findAll();
    }

    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }
    public Shop getShop(Long id){
        return shopRepository.getShopById(id);
    }
}
