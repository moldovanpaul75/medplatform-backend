package ro.tuc.ds2020.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);


    @RabbitListener(queues = "spring-boot")
    public void messageReceiver(String message) {
        LOGGER.info(message);
    }

}
