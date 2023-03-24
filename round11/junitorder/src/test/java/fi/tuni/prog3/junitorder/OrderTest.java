
package fi.tuni.prog3.junitorder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

import fi.tuni.prog3.junitorder.Order;
import fi.tuni.prog3.junitorder.Order.Item;
import fi.tuni.prog3.junitorder.Order.Entry;



public class OrderTest{
    @Test
    public void testAddItem(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        assertEquals(true, o.addItems(i, 3));
    }

    @Test
    public void testNegativeAddItem(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        assertThrows(IllegalArgumentException.class, () -> {
            o.addItems(i, -3);
        });
    }
    @Test
    public void testItemWithDifferentCount(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        Item i2 = new Item("Nimi", 1.4);
        assertThrows(IllegalStateException.class, () -> {
            o.addItems(i2, 3);
        });
    }

    @Test
    public void testAddItemString(){
        Order o = new Order();
        // throws exception because there is no such item
        assertThrows(NoSuchElementException.class, () -> {
            o.addItems("Nimi", 3);
        });
    }
    
    @Test
    public void testAddItemStringNegative(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            o.addItems("Nimi", -3);
        });
    }
    @Test
    public void testAddItemWithString(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        assertEquals(true, o.addItems("Nimi", 3));
    }
    @Test
    public void testGetEntries(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        assertEquals(1, o.getEntries().size());
    }

    @Test
    public void testGetEntries2(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i, 3);
        assertEquals(1, o.getEntries().size());
    }

    @Test
    public void testGetEntries3(){
        Item i = new Item("Nimi", 1.3);
        Item i2 = new Item("Nimi2", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i2, 3);
        assertEquals(2, o.getEntries().size());
    }

    @Test
    public void testGetEntriesCount(){
        Item i = new Item("Nimi", 1.3);
        Item i2 = new Item("Nimi2", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i2, 3);
        assertEquals(2, o.getEntryCount());
    }

    @Test
    public void testGetItemCount(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i, 3);
        assertEquals(6, o.getItemCount());
    }

    @Test
    public void testTotalPrice(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i, 3);
        assertEquals(7.8, o.getTotalPrice(), 0.001);
    }

    @Test
    public void testIsEmpty(){
        Order o = new Order();
        assertEquals(true, o.isEmpty());

        Item i = new Item("Nimi", 1.3);
        o.addItems(i, 3);
        assertEquals(false, o.isEmpty());
    }

    @Test
    public void testRemoveItems(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i, 3);
        assertEquals(true, o.removeItems("Nimi", 3));
    }

    @Test
    public void testRemoveItemsNegative(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            o.removeItems("Nimi", -3);
        });
    }
    @Test
    public void testRemoveNoelement(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        o.addItems(i, 3);
        assertThrows(NoSuchElementException.class, () -> {
            o.removeItems("Nimi2", 3);
        });
    }

    @Test
    public void testItemNullName(){
        assertThrows(IllegalArgumentException.class, () -> {
            Item i = new Item(null, 1.3);
        });
    }
    @Test
    public void testItemNegativePrice(){
        assertThrows(IllegalArgumentException.class, () -> {
            Item i = new Item("Nimi", -1.3);
        });
    }
    @Test
    public void testItemGetName(){
        Item i = new Item("Nimi", 1.3);
        assertEquals("Nimi", i.getName());
    }

    @Test
    public void testItemGetPrice(){
        Item i = new Item("Nimi", 1.3);
        assertEquals(1.3, i.getPrice(), 0.001);
    }

    @Test
    public void testItemEquals(){
        Item i = new Item("Nimi", 1.3);
        Item i2 = new Item("Nimi", 5);
        assertEquals(true, i.equals(i2));
    }

    @Test
    public void testItemEquals2(){
        Item i = new Item("Nimi", 5);
        Item i2 = new Item("Nimi2", 5);
        assertEquals(false, i.equals(i2));
    }
    @Test
    public void testEntryNegativeCount(){
        Item i = new Item("Nimi", 1.3);
        assertThrows(IllegalArgumentException.class, () -> {
            Entry e = new Entry(i, -3);
        });
    }

    @Test
    public void testGetItemName(){
        Item i = new Item("Nimi", 1.3);
        Entry e = new Entry(i, 3);
        assertEquals("Nimi", e.getItemName());
    }

    @Test
    public void testGetUnitPrice(){
        Item i = new Item("Nimi", 1.3);
        Entry e = new Entry(i, 3);
        assertEquals(1.3, e.getUnitPrice(), 0.001);
    }

    @Test
    public void testGetItem(){
        Item i = new Item("Nimi", 1.3);
        Entry e = new Entry(i, 3);
        assertEquals(i, e.getItem());
    }

    @Test
    public void testGetCount(){
        Item i = new Item("Nimi", 1.3);
        Entry e = new Entry(i, 3);
        assertEquals(3, e.getCount());
    }

    @Test
    public void testToString(){
        Item i = new Item("Nimi", 1.3);
        Entry e = new Entry(i, 3);
        assertEquals("3 units of Item(Nimi, 1.30)", e.toString());
    }
}
