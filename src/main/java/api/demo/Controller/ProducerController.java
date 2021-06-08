package api.demo.Controller;

import api.demo.Controller.RequestModel.PromotionRequestModel;
import api.demo.Model.Producer;
import api.demo.Model.Shop;
import api.demo.Service.ProducerService;
import api.demo.Service.ShopService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Data
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProducerController {

    public final ProducerService producerService;

    @GetMapping("/producers")
    @ResponseBody
    public List<Producer> getShops() {
        return producerService.getProducers();
    }

    @PostMapping("/add-producer")
    @ResponseBody
    public void addProducer(@RequestBody PromotionRequestModel model) {
        producerService.addProducer(new Producer(model.name));
    }
}
