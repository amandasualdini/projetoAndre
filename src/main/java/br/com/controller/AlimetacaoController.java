package br.com.controller;

import br.com.constant.Constant;
import br.com.model.Alimentacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import br.com.service.AlimentacaoService;

import java.util.List;
import java.util.Optional;

public class AlimetacaoController {

    @Autowired
    private AlimentacaoService alimentacaoService;

    @PostMapping(Constant.API_ALIMENTACAO)
    public void save(@RequestBody Alimentacao alimentacao){ alimentacaoService.sendAlimentacaoRabbit(alimentacao);
    }

    @GetMapping(Constant.API_ALIMENTACAO)
    public List<Alimentacao> findAll(){
        return alimentacaoService.findAll();
    }

    @PutMapping(Constant.API_ALIMENTACAO)
    public void update (@RequestBody Alimentacao alimentacao){
        alimentacaoService.save(alimentacao);
    }

    @DeleteMapping(Constant.API_ALIMENTACAO + "/{id}")
    public void delete(@PathVariable("id") String id){
        alimentacaoService.delete(id);
    }

    @GetMapping(Constant.API_ALIMENTACAO + "/{id}")
    @Cacheable("alimentacao")
    public Optional<Alimentacao> findById(@PathVariable("id") String id){
        System.out.println("Find Information.. " + id);
        return alimentacaoService.findById(id);
    }
}
