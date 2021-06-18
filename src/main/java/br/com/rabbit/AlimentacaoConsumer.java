package br.com.rabbit;

import br.com.model.Alimentacao;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.service.AlimentacaoService;

@Component
public class AlimentacaoConsumer {

    @Autowired
    private AlimentacaoService alimentacaoService;

    @RabbitListener(queues = {"${queue.alimentacao.name}"})
    public void receive (@Payload Alimentacao alimentacao){
        System.out.println("Id: "+ alimentacao.get_id() + "\nDescricao: "
                + "\nQuantidade de Produto: " + alimentacao.getMoeda());
        alimentacaoService.save(alimentacao);
    }
}
