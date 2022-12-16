package se.maokei.stable_relations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Address {
    private String streetName;
    private String city;
    private String areaCode;
}
