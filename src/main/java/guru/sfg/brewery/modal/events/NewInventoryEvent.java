package guru.sfg.brewery.modal.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
