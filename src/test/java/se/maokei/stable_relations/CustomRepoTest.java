package se.maokei.stable_relations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import se.maokei.stable_relations.model.HorseBreed;
import se.maokei.stable_relations.repository.CustomRepo;
import se.maokei.stable_relations.repository.HorseBreedRepository;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
public class CustomRepoTest {
    @Autowired
    private CustomRepo customRepo;
    @Autowired
    private HorseBreedRepository breedRepo;

    @Test
    public void getHorseTest() {
        Mono<Integer> found = customRepo.getHorseById(1).map(h -> h.getId());
        StepVerifier.create(found).expectNext(1).verifyComplete();
    }

    @Test
    public void horseBreedTest() {
        Mono<Long> count = breedRepo.count();
        Mono<Long> id = customRepo.addHorseBreed(
                HorseBreed.builder().name("SpacePonny").build()
        ).map(Long::new);
        StepVerifier.create(Flux.concat(count, id)).assertNext(c -> {
            Assertions.assertThat(c).isEqualTo(13L);
        }).assertNext(nId -> {
            Assertions.assertThat(nId).isEqualTo(14L);
        }).verifyComplete();
    }
}
