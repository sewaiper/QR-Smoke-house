package ru.sewaiper.smokehouse.model.table;

import ru.sewaiper.smokehouse.util.SmokehouseTestUtils;

import java.util.ArrayList;
import java.util.List;

public class TableGenerator {
    public static WorkTable getTable() {
        WorkTable table = new WorkTable();

        table.setCode(SmokehouseTestUtils.getRandomNumberString(15));

        return table;
    }

    public static List<WorkTable> getTables(int size) {
        List<WorkTable> tables = new ArrayList<>(size);

        for(int i=0; i<size; i++) {
            tables.add(getTable());
        }

        return tables;
    }
}
