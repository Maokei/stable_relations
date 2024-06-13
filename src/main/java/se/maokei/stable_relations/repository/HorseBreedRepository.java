package se.maokei.stable_relations.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import se.maokei.stable_relations.model.HorseBreed;

@Repository
public interface HorseBreedRepository extends ReactiveCrudRepository<HorseBreed, Integer> {
}
