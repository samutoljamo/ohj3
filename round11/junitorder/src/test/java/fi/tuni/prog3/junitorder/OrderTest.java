
package fi.tuni.prog3.junitorder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testAddItemWithString(){
        Item i = new Item("Nimi", 1.3);
        Order o = new Order();
        o.addItems(i, 3);
        assertEquals(true, o.addItems("Nimi", 3));
    }
}
