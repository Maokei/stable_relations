package se.maokei.stable_relations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Table("stable")
public class Stable {
    @Id
    private Integer id;
    private String name;
    @Transient
    List<Horse> horses;
}
