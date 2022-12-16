package se.maokei.stable_relations.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import se.maokei.stable_relations.model.Stable;

@Repository
public interface StableRepository extends ReactiveSortingRepository<Stable, Integer> {
    @Query("SELECT * FROM stable.stable INNER JOIN horse on stable.id = horse.stable_id ORDER BY stable.name")
    Flux<Stable> findAllStables();

    //@Query("select t.* from tag t join item_tag it on t.id = it.tag_id where it.item_id = :item_id order by t.name")
    //Flux<Stable> findTagsByItemId(Long itemId);
}

