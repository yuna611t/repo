package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SampleTest {
    @Test
    public void testAdd() {
        assertEquals(3, Sample.add(1, 2));
    }
    @Test
    public void testAdd2() {
        assertEquals(2, Sample.add(1,2));
    }
    @Test
    public void testAdd3() {
        assertEquals(5, Sample.add(2,3));
    }
}
~
