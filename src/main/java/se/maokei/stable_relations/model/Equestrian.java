package se.maokei.stable_relations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Data
@AllArgsConstructor
@Table("equestrian")
public class Equestrian {
    private int equestrianId;
    private String nickname;
}
