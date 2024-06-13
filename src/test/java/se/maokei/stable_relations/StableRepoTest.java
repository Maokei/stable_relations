package se.maokei.stable_relations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import se.maokei.stable_relations.model.Stable;
import se.maokei.stable_relations.repository.StableRepository;
import se.maokei.stable_relations.repository.StableRepositorySorting;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StableRepoTest {
    @Autowired
    StableRepositorySorting stableRepoSorting;
    @Autowired
    StableRepository stableRepo;

    @Test
    @Order(1)
    public void countStablesTest() {
        Mono<Long> count = stableRepo.findAll().count();
        StepVerifier.create(count)
                .expectNext(4L) //TODO should be 3
                .verifyComplete();
    }

    @Test
    @Order(2)
    public void saveStableTest() {
        String name = "Paradise";
        Stable s = new Stable();
        s.setName(name);
        StepVerifier.create(stableRepo.save(s))
                .assertNext(f ->
                        Assertions.assertThat(
                                f.getName()
                        ).isEqualTo(name)
                ).verifyComplete();
    }

    @Test
    public void getStableById() {
        String target = "Stylish poses";
        Mono<Stable> found = stableRepo.findById(2);

        StepVerifier.create(found).expectNextMatches(res ->
                res.getName().equalsIgnoreCase(target)
        ).verifyComplete();
    }
}
