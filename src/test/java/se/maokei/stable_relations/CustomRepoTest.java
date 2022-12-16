package se.maokei.stable_relations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import se.maokei.stable_relations.repository.CustomRepo;

@DataR2dbcTest
public class CustomRepoTest {
    @Autowired
    private CustomRepo customRepo;

    @Test
    public void getHorseByIdTest() {
        /*
        customRepo.getHorse(1).subscribe(res -> {
            System.out.println(res);
        });
        */
    }
}
