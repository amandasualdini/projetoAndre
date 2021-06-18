package br.com.rabbit;

import br.com.model.Hospedagem;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class HospedagemProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("hospedagemQueue")
    @Autowired
    private Queue queue;

    public void send(Hospedagem hospedagem){
        rabbitTemplate.convertAndSend(this.queue.getName(), hospedagem);
    }
}
