package br.com.rabbit;

import br.com.model.Alimentacao;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class AlimentacaoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("alimentacaoQueue")
    @Autowired
    private Queue queue;

    public void send(Alimentacao alimentacao){
        rabbitTemplate.convertAndSend(this.queue.getName(), alimentacao);
    }
}
