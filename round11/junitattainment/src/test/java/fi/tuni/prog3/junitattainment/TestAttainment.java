import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import fi.tuni.prog3.junitattainment.Attainment;

// attainment is at round11/junitattainment/testfiles/0/Attainment.class

public class TestAttainment {
    @Test
    public void testGetCourseName() {
        Attainment a = new Attainment("Nimi", "123456", 5);
        assertEquals("Nimi", a.getCourseName());
    }
    @Test
    public void testGetStudentNumber() {
        Attainment a = new Attainment("Nimi", "123456", 5);
        assertEquals("123456", a.getStudentNumber());
    }

    @Test
    public void testGetGrade(){
        Attainment a = new Attainment("Nimi", "123456", 5);
        assertEquals(5, a.getGrade());
    }

    @Test
    public void testToString(){
        Attainment a = new Attainment("Nimi", "123456", 5);
        assertEquals("Nimi 123456 5", a.toString());
    }
    @Test
    public void testIllegalArgument(){
        assertThrows(IllegalArgumentException.class, () -> {
            Attainment a = new Attainment("Nimi", "123456", 6);
        });
    }
    @Test
    public void testCompare(){
        Attainment a = new Attainment("Nimi", "123456", 5);
        Attainment b = new Attainment("Nimi", "123456", 5);
        assertEquals(0, a.compareTo(b));
    }

    @Test
    public void testCompare2(){
        Attainment a = new Attainment("Nimi", "abc", 5);
        Attainment b = new Attainment("Nimi", "abd", 5);
        assertEquals(-1, a.compareTo(b));
    }
    @Test
    public void testCompare3(){
        Attainment a = new Attainment("Nimi", "abc", 5);
        Attainment b = new Attainment("Nimi2", "abc", 5);
        assertEquals(-1, a.compareTo(b));
    }
    @Test
    public void testCompare4(){
        Attainment a = new Attainment("Nimib", "abc", 5);
        Attainment b = new Attainment("Nimia", "abd", 5);
        assertEquals(-1, a.compareTo(b));
    }


}
