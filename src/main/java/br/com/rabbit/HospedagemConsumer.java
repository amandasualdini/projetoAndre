package br.com.rabbit;

import br.com.model.Hospedagem;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.service.HospedagemService;

@Component

public class HospedagemConsumer {

    @Autowired
    private HospedagemService hospedagemService;

    @RabbitListener(queues = {"${queue.hospedagem.name}"})
    public void receive (@Payload Hospedagem hospedagem){
        System.out.println("Id: "+ hospedagem.get_id() + "\nDescricao: "
                + "\nQtde: " + hospedagem.getQtd() + "\nValor: " + hospedagem.getValor()
                + "\nMoeda: " + hospedagem.getMoeda() + "\nTotal: " + hospedagem.getTotal()
                + "\nPagamento: " + hospedagem.getFormaPagamento());
        hospedagemService.save(hospedagem);
    }


}
