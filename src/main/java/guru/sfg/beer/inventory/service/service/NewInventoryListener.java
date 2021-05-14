package guru.sfg.beer.inventory.service.service;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.brewery.modal.events.BeerDTO;
import guru.sfg.brewery.modal.events.BeerEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewInventoryListener {
    private final BeerInventoryRepository inventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_EVENT_QUEUE)
    public void newInventoryListener(BeerEvent beerEvent){
        log.debug("GotInventory "+beerEvent.toString());

        BeerDTO beerDTO = beerEvent.getBeerDTO();

        inventoryRepository.save(BeerInventory.builder()
                                    .beerId(beerDTO.getId())
                                    .upc(beerDTO.getUpc())
                                    .quantityOnHand(beerDTO.getQuantityOnHand())
                                    .build());
    }
}
