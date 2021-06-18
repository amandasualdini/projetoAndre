package br.com.repository;

import br.com.model.Hospedagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface HospedagemRepository extends MongoRepository<Hospedagem, String> {
}
