package api.demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShopItem extends BasicModel {
    public float price;
    public int available;
    @OneToOne
    public Shop shop;
    @OneToOne
    public Product product;
    @OneToOne
    public Promotion promotion;


}
