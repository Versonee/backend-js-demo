package api.demo.Service;

import api.demo.Model.Promotion;
import api.demo.Model.ShopItem;
import api.demo.Model.Type.PromotionType;
import api.demo.Repository.PromotionRepository;
import api.demo.Repository.ShopItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public List<Promotion> getPromotions() {
        return promotionRepository.findAll();
    }

    public void addPromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    public List<PromotionType> getPromotionTypes() {
        return new ArrayList<>(List.of(
                PromotionType.BASIC,
                PromotionType.PERCENT
        ));
    }
}