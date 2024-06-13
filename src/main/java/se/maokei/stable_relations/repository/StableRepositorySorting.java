package se.maokei.stable_relations.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.maokei.stable_relations.model.Stable;

@Repository
public interface StableRepositorySorting extends ReactiveSortingRepository<Stable, Integer> {
    @Query("SELECT * FROM stable.stable INNER JOIN horse on stable.id = horse.stable_id ORDER BY stable.name")
    Flux<Stable> findAllStables();

    @Query("INSERT INTO stable VALUES (stable.name)")
    Mono<Stable> save(Stable stable);
}

