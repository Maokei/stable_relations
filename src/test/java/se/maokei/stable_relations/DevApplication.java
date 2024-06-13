package se.maokei.stable_relations;

import org.springframework.boot.SpringApplication;

public class DevApplication {
    public static void main(String[] args) {
        SpringApplication.from(StableRelationsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}
