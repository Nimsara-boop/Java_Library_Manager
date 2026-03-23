package librarycentre_package;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterLibraryManagerTest {


    @org.junit.jupiter.api.Test
    void testAddItemToList() {
        WestminsterLibraryManager manager = new WestminsterLibraryManager(5);
        manager.itemList = new ArrayList<>();

        Item item = new Book("the man", "8345");

        manager.addItemToList(item);

        Assertions.assertEquals(1, manager.itemList.size());
        Assertions.assertEquals(item, manager.itemList.get(0));

    }

}