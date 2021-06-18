package br.com.controller;


import br.com.constant.Constant;
import br.com.model.Hospedagem;
import br.com.model.Alimentacao;
import br.com.service.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import br.com.service.AlimentacaoService;

import java.util.List;
import java.util.Optional;

@RestController
public class HospedagemController {

    @Autowired
    private HospedagemService hospedagemService;

    @Autowired
    private AlimentacaoService alimentacaoService;

    @PostMapping(Constant.API_HOSPEDAGEM)
    public void save(@RequestBody Hospedagem hospedagem){
        hospedagemService.sendHospedagemRabbit(hospedagem);
    }

    @GetMapping(Constant.API_HOSPEDAGEM)
    public List<Hospedagem> findAll(){
        return hospedagemService.findAll();
    }

    @PutMapping(Constant.API_HOSPEDAGEM)
    public void update (@RequestBody Hospedagem hospedagem){
        hospedagemService.save(hospedagem);
    }

    @DeleteMapping(Constant.API_HOSPEDAGEM + "/{id}")
    public void delete(@PathVariable("id") String id){
        hospedagemService.delete(id);
    }

    @GetMapping(Constant.API_HOSPEDAGEM + "/{id}")
    @Cacheable("hospedagem")
    public Optional<Hospedagem> findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return hospedagemService.findById(id);
    }
}
