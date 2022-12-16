package se.maokei.stable_relations.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.maokei.stable_relations.model.Horse;
import se.maokei.stable_relations.model.HorseBreed;
import se.maokei.stable_relations.model.Stable;

import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CustomRepo {
    private final DatabaseClient client;

    public Flux<Stable> getAllStables() {
        String query = "SELECT stable.id, stable.name sname, horse.id hid, horse.name hname, horsebreed.id bid, horsebreed.name bname FROM stable.stable INNER JOIN horse ON stable.id = horse.stable_id INNER JOIN horsebreed ON horse.horsebreed_id = horsebreed.id ORDER BY stable.id";
        return client.sql(query)
                .fetch()
                .all()
                .bufferUntilChanged(result -> result.get("id"))
                .map(r -> Stable.builder()
                        .id((int) r.get(0).get("id"))
                        .name((String) r.get(0).get("sname"))
                        .horses(
                                r.stream().map(hr -> Horse.builder()
                                        .id((int) hr.get("hid"))
                                        .name((String) hr.get("hname"))
                                        .horseBreed(HorseBreed.builder().id((int) hr.get("bid")).name((String) hr.get("bname")).build())
                                        .build()
                                ).collect(Collectors.toList())
                        ).build());
    }

    public Flux<HorseBreed> getAllHorseBreeds() {
        String query = "SELECT * FROM horsebreed";
        return this.client
                .sql(query)
                .fetch()
                .all()
                .map(row -> HorseBreed
                        .builder()
                        .id((int) row.get("id"))
                        .name((String) row.get("name"))
                        .build()
                );

    }

    public Mono<Horse> getHorseById(int id) {
        String query = "SELECT horse.id, horse.name, horse.horsebreed_id, horsebreed.name bname FROM horse INNER JOIN horsebreed ON horse.horsebreed_id = horsebreed.id WHERE horse.id = :id";
        return client.sql(query)
                .bind("id", id)
                .fetch().one().switchIfEmpty(Mono.empty()).map(row -> Horse.builder()
                        .id((int) row.get("id"))
                        .name((String) row.get("name"))
                        .horseBreed(
                                HorseBreed.builder()
                                        .id((int) row.get("horsebreed_id"))
                                        .name((String) row.get("bname"))
                                        .build()
                        ).build());
    }

    public Mono<Horse> getHorse(int id) {
        String query = "SELECT * FROM horse WHERE id = :id";
        return this.client
                .sql(query)
                .bind("id", id)
                .fetch()
                .one()
                .map(row -> Horse
                        .builder()
                        .id((int) row.get("id"))
                        .name((String) row.get("name"))
                        .build()
                );
    }

    public Flux<Horse> getAllHorses() {
        String query = "SELECT * FROM horse";
        return this.client
                .sql(query)
                .fetch()
                .all()
                .map(row -> Horse
                        .builder()
                        .id((int) row.get("id"))
                        .name((String) row.get("name"))
                        .build()
                );
    }
}
