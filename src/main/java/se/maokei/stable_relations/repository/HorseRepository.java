package se.maokei.stable_relations.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import se.maokei.stable_relations.model.Horse;

public interface HorseRepository extends ReactiveCrudRepository<Horse, Integer> {

}
