package br.com.service;

import br.com.model.Estado;
import br.com.utils.PlanilhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.rabbit.EstadoProducer;
import br.com.repository.EstadoRepository;

import java.util.List;
import java.util.Optional;

@Service

public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoProducer estadoProducer;

    public void sendEstadoRabbit(Estado estado){
        estadoProducer.send(estado);
    }


    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    public void save(Estado estado){
        estadoRepository.save(estado);
    }

    public Optional<Estado> findById(String id){
        return estadoRepository.findById(id);
    }

    public void delete(String id){
        estadoRepository.deleteById(id);
    }

    public void deleteAll(){
        estadoRepository.deleteAll();
    }

    public void saveExcel(){
        for(int i = 0; i < PlanilhaUtils.lerPlanilha().size(); i++){
            estadoRepository.save(PlanilhaUtils.lerPlanilha().get(i));
        }
    }

}
