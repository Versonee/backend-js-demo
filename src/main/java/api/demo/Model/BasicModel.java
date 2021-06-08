package api.demo.Model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BasicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;
    public Date created;
    public Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
