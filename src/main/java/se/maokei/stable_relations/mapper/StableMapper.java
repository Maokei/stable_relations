package se.maokei.stable_relations.mapper;

import io.r2dbc.spi.Row;
import se.maokei.stable_relations.model.Stable;

import java.util.function.BiFunction;

public class StableMapper implements BiFunction<Row, Object, Stable> {
    @Override
    public Stable apply(Row row, Object o) {

        return null;
    }
}
