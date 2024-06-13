package se.maokei.stable_relations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("horse")
public class Horse {
    @Id
    private Integer id;
    private String name;
    @Transient
    private HorseBreed horseBreed;
}
