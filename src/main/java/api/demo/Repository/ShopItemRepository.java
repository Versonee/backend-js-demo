package api.demo.Repository;

import api.demo.Model.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {

}
