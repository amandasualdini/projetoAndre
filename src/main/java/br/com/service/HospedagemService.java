package br.com.service;

import br.com.model.Hospedagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rabbit.HospedagemProducer;
import br.com.repository.HospedagemRepository;

import java.util.List;
import java.util.Optional;

@Service

public class HospedagemService {

    @Autowired
    private HospedagemRepository hospedagemRepository;

    @Autowired
    private HospedagemProducer hospedagemProducer;

    public void sendHospedagemRabbit(Hospedagem hospedagem){
        hospedagemProducer.send(hospedagem);
    }

    public List<Hospedagem> findAll(){
        return hospedagemRepository.findAll();
    }

    public void save(Hospedagem hospedagem){
        hospedagemRepository.save(hospedagem);
    }

    public Optional<Hospedagem> findById(String id){
        return hospedagemRepository.findById(id);
    }

    public void delete(String id){
        hospedagemRepository.deleteById(id);
    }

    public void deleteAll(){
        hospedagemRepository.deleteAll();
    }
}
