package api.demo.Service;

import api.demo.Model.Producer;
import api.demo.Model.ShopItem;
import api.demo.Repository.ProducerRepository;
import api.demo.Repository.ShopItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final ProducerRepository producerRepository;

    public List<Producer> getProducers() {
        return producerRepository.findAll();
    }

    public void addProducer(Producer producer) {
        producerRepository.save(producer);
    }
}