package se.maokei.stable_relations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Builder
@Table("horsebreed")
public class HorseBreed {
    @Id
    private Integer id;
    private String name;
}
