package se.maokei.stable_relations.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.maokei.stable_relations.repository.HorseBreedRepository;
import se.maokei.stable_relations.repository.HorseRepository;

@RequiredArgsConstructor
@Service
public class HorseService {
    private final HorseRepository horseRepository;
    private final HorseBreedRepository horseBreedRepository;

    public void getAllHorses() {

    }
}
