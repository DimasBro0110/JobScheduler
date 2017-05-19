package com.dimas.brosalin.InMemoryDatagrid.HazelcastDAOLayer;

import java.util.List;

/**
 * Created by DmitriyBrosalin on 19/05/2017.
 */
public interface HazelcastDAO {

    List<String> getMessagesFromCollection();

}
