package api.demo.Model;

import api.demo.Model.Type.PromotionType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Promotion extends BasicModel {
    public String name;
    public PromotionType type;
    public int promotionValue;
}
