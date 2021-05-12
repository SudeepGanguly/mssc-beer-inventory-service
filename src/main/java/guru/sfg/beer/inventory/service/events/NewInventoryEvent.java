package guru.sfg.beer.inventory.service.events;

import guru.sfg.common.events.BeerDTO;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
