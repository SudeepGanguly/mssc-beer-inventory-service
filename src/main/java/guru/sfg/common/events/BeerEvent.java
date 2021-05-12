package guru.sfg.common.events;

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
