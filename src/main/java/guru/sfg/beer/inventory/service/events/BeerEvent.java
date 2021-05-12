package guru.sfg.beer.inventory.service.events;

import guru.sfg.common.events.BeerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeerEvent implements Serializable {
    static final Long serialVersionUID = -554544432114554564L;

    private BeerDTO beerDTO;
}
