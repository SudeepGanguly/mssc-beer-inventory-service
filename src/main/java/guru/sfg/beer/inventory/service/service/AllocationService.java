package guru.sfg.beer.inventory.service.service;

import guru.sfg.brewery.modal.BeerOrderDto;

public interface AllocationService {
    Boolean allocateOrder(BeerOrderDto beerOrderDto);

    void deallocateOrder(BeerOrderDto beerOrder);
}
