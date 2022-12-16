package se.maokei.stable_relations.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class StableEquestrian {
    private int stableId;
    private int equestrianId;
}
