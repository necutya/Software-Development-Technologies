package MuseumExhibition;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ExhibitionTest {

    private Exhibition exhibition;
    @Mock
    private Painting painting;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        exhibition = new Exhibition("Test Exhibition");
        for (int i=0; i < 4; i++) {
            exhibition.addExhibit(painting);
        }
    }

    @Test
    public void getExhibitsAmount_checkArrayAmount_True() {
        assertEquals(exhibition.getExhibitsAmount(), 4);
    }

    @Test
    public void addExhibit_addElementToArray_True() {
        exhibition.addExhibit(painting);
        assertEquals(exhibition.getExhibits().size(), 5);
    }


}