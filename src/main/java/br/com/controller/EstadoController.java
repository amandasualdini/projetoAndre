package br.com.controller;

import br.com.constant.Constant;
import br.com.model.Estado;
import br.com.model.Hospedagem;
import br.com.model.Alimentacao;
import br.com.utils.PlanilhaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import br.com.service.EstadoService;
import br.com.service.HospedagemService;
import br.com.service.AlimentacaoService;

import java.util.List;
import java.util.Optional;

public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @Autowired
    private HospedagemService hospedagemService;

    @Autowired
    private AlimentacaoService alimentacaoService;


    @PostMapping(Constant.API_ESTADO)
    public void save(@RequestBody Estado estado, Hospedagem hospedagem){
        estadoService.sendEstadoRabbit(estado);
    }

    @GetMapping(Constant.API_ESTADO)
    public List<Estado> findAll(){
        int cont = 0;
        if(cont == 0){
            estadoService.saveExcel();
            cont++;
        }
        return estadoService.findAll();

    }

    @PutMapping(Constant.API_ESTADO)
    public void update (@RequestBody Estado estado){
        estadoService.save(estado);
    }

    @DeleteMapping(Constant.API_ESTADO + "/{id}")
    public void delete(@PathVariable("id") String id){
        estadoService.delete(id);
    }

    @GetMapping(Constant.API_ESTADO + "/{id}")
    @Cacheable("estado")
    public Optional<Estado> findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return estadoService.findById(id);
    }
}
