package se.maokei.stable_relations.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import se.maokei.stable_relations.model.Horse;

@Repository
public interface HorseRepository extends R2dbcRepository<Horse, Integer> {

}
