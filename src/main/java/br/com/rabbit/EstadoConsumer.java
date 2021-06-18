package br.com.rabbit;

import br.com.model.Estado;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.service.EstadoService;

public class EstadoConsumer {

    @Autowired
    private EstadoService estadoService;

    @RabbitListener(queues = {"${queue.estado.name}"})
    public void receive (@Payload Estado estado){
        System.out.println("Id: "+ estado.get_id() + "\nDescricao: "
                + "\nNome: " + estado.getNome());
        estadoService.save(estado);
    }
}
