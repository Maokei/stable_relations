package se.maokei.stable_relations.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import se.maokei.stable_relations.model.Stable;

public interface StableRepository extends R2dbcRepository<Stable, Integer> {

}
