package br.com.service;

import br.com.model.Alimentacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rabbit.AlimentacaoProducer;
import br.com.repository.AlimentacaoRepository;

import java.util.List;
import java.util.Optional;

public class AlimentacaoService {

    @Autowired
    private AlimentacaoRepository alimentacaoRepository;

    @Autowired
    private AlimentacaoProducer alimentacaoProducer;

    public void sendAlimentacaoRabbit(Alimentacao alimentacao){
        alimentacaoProducer.send(alimentacao);
    }

    public List<Alimentacao> findAll(){
        return alimentacaoRepository.findAll();
    }

    public void save(Alimentacao alimentacao){
        alimentacaoRepository.save(alimentacao);
    }

    public Optional<Alimentacao> findById(String id){
        return alimentacaoRepository.findById(id);
    }

    public void delete(String id){
        alimentacaoRepository.deleteById(id);
    }

    public void deleteAll(){
        alimentacaoRepository.deleteAll();
    }
}
