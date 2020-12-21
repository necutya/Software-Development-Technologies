package MuseumExhibition;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExhibitionIT {
    private ArrayList<Exhibit> list;
    private Painting painting;
    private Exhibition exhibition;

    @Before
    public void setUp() {
        list = spy(new ArrayList<>());


        painting = new Painting(
                "test",
                new Author("Test van Testovich", new int[]{1819, 2020}),
                1900,
                12, 13
        );

        exhibition = new Exhibition("Test Exhibition", list);
    }

    @Test
    public void AreProductsAddedToList() {

        exhibition.addExhibit(painting);
        exhibition.addExhibit(painting);

        verify(list, times(2)).add(painting);

        assertEquals(2, list.size());
    }
}
