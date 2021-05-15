package guru.sfg.beer.inventory.service.service;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.brewery.modal.events.AllocateBeerOrderRequest;
import guru.sfg.brewery.modal.events.AllocateBeerOrderResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AllocationListener {

    private final JmsTemplate jmsTemplate;
    private final AllocationService allocationService;

    @JmsListener(destination = JmsConfig.ALLOCATE_BEER_ORDER_QUEUE)
    public void listen(AllocateBeerOrderRequest request){
        AllocateBeerOrderResult.AllocateBeerOrderResultBuilder builder =
                                             AllocateBeerOrderResult.builder();

        builder.beerOrderDto(request.getBeerOrderDto());

        try{
            Boolean allocationResult = allocationService.allocateOrder(request.getBeerOrderDto());

            if(allocationResult){
                //As if allocation done , there is no pending
                builder.pendingInventory(false);
            } else {
                builder.pendingInventory(true);
            }
        } catch(Exception e){
            log.debug("Allocation failed for Order Id: "+request.getBeerOrderDto().toString());
            builder.allocationError(true);
        }

        //Sending back the result
        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESULT_QUEUE,
                                                builder.build());
    }
}
