package com.r00t.itemserv.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r00t.itemserv.models.DTO.responsebody.QuantityUpdateDTO;
import com.r00t.itemserv.services.serviceClasses.ItemService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MQConsumer {
    private static final String QUEUE_CREATE_ORDER = "q.checkItem";
    @Autowired
    private ItemService iService;

    @RabbitListener(queues = QUEUE_CREATE_ORDER)
    public void createOrderValidation(QuantityUpdateDTO item) throws Exception {
        log.info("CREATE_ORDER_EVENT: {} ", item);
        iService.UpdateQuantity(item.getItemID(), item.getQuantity().intValue());
    }
}
