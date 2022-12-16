package se.maokei.stable_relations.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import se.maokei.stable_relations.model.HorseBreed;

public interface HorseBreedRepository extends ReactiveCrudRepository<HorseBreed, Integer> {
}
