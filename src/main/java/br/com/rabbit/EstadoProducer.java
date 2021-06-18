package br.com.rabbit;


import br.com.model.Estado;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EstadoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("estadoQueue")
    @Autowired
    private Queue queue;

    public void send(Estado estado){
        rabbitTemplate.convertAndSend(this.queue.getName(), estado);
    }
}
