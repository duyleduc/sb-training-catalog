package com.training.sbtrainingcatalog.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.sbtrainingcatalog.entities.Product;
import com.training.sbtrainingcatalog.models.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class RabbitMQReceiver {
    @Autowired
    private ProductService productService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "room.queue")
    public void receiver(Message message) throws IOException {
        TestMessage testMessage = objectMapper.readValue(message.getBody(),TestMessage.class);
        log.info("Receiving Message : " + testMessage.getQuantity());

        Product product = productService.getProductByItemID(testMessage.getItemId());
        Long leftQuantity = product.getQuantity() - testMessage.getQuantity();
        product.setQuantity(leftQuantity);

        productService.updateProduct(product,product.getId());

    }
}
