package br.ufrn.extension.gatinhos.rescuesystem.rescue;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RescueRepository extends MongoRepository<Rescue, String> {
}
