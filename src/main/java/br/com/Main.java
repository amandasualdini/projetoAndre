package br.com;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class Main {

    @Value("${queue.estado.name}")
    private String estadoQueue;

    @Value("${queue.alimentacao.name}")
    private String alimentacaoQueue;

    @Value("${queue.hospedagem.name}")
    private String hospedagemQueue;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Queue estadoQueue(){
        return new Queue(estadoQueue,true);
    }

    @Bean
    public Queue hospedagemQueue(){
        return new Queue(hospedagemQueue,true);
    }

    @Bean
    public Queue alimentacaoQueue(){
        return new Queue(alimentacaoQueue,true);
    }

}