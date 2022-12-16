package se.maokei.stable_relations.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import se.maokei.stable_relations.model.Horse;
import se.maokei.stable_relations.model.HorseBreed;
import se.maokei.stable_relations.model.Stable;
import se.maokei.stable_relations.repository.CustomRepo;
import se.maokei.stable_relations.repository.HorseBreedRepository;
import se.maokei.stable_relations.repository.HorseRepository;
import se.maokei.stable_relations.repository.StableRepository;

@RestController
@RequestMapping(value = "/stable")
@RequiredArgsConstructor
@Slf4j
public class StableController {
    private final StableRepository stableRepository;
    private final HorseRepository horseRepository;
    private final HorseBreedRepository horseBreedRepository;
    private final CustomRepo customRepo;

    @GetMapping
    public Flux<Stable> getAllStables() {
        return this.customRepo.getAllStables();
    }

    @GetMapping("/horse")
    public Flux<Horse> getAllHorses() {
        //return horseRepository.findAll();
        return customRepo.getAllHorses();
    }

    @GetMapping("/horse/{id}")
    public Mono<ResponseEntity<Horse>> getHorseById(@PathVariable("id") int id) {
        return this.customRepo.getHorseById(id).map(ResponseEntity::ok).switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).<Horse>body(null)));
    }

    @GetMapping("/hbreed")
    public Flux<HorseBreed> getAllBreedsCustom() {
        return this.customRepo.getAllHorseBreeds();
    }

    @GetMapping("/horsebreed")
    public Flux<HorseBreed> getAllBreeds() {
        return horseBreedRepository.findAll();
    }

    @GetMapping("/horsebreed/{id}")
    public Mono<HorseBreed> getAllBreeds(@PathVariable("id") Integer id) {
        return horseBreedRepository.findById(id);
    }
}
