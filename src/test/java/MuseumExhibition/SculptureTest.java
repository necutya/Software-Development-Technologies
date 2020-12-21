package MuseumExhibition;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class SculptureTest {

    private Sculpture sculpture;
    private Author author;


    @Before
    public void setUp() {
        author = new Author("Test van Testovich", new int[]{1819, 2020});
        sculpture = new Sculpture(
                "test_sculpture",
                author,
                1245,
                MaterialType.Clay
        );
    }


    @Test
    public void equals_checkEqualityRegardlessOfMaterial_True() throws Exception {
        Sculpture temp = new Sculpture("test_sculpture", author, 1245, MaterialType.Metal);
        assertEquals(sculpture, temp);
    }

    @Test
    public void testMaterialTypeChanging() {
        sculpture.setMaterial(MaterialType.Stone);
        assertEquals(sculpture.getMaterial(), MaterialType.Stone);
    }

}