package se.maokei.stable_relations;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class StableRelationsApplicationTests {

	@Test
	void contextLoads() {
	}
}
