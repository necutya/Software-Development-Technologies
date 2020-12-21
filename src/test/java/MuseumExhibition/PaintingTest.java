package MuseumExhibition;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaintingTest {

    private Painting paiting;

    private Author author;

    @Before
    public void setUp() {
        author = new Author("Test van Testovich", new int[]{1819, 2020});
        paiting = new Painting("test_sculpture", author, 1245, 200, 300);
    }


    @Test
    public void equals_checkEqualityRegardlessOfSize_True() {
        Painting temp = new Painting("test_sculpture", author, 1245, 800, 900);
        assertEquals(paiting, temp);
    }

}