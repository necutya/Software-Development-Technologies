package MuseumExhibition;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PaintingIT {
    private Painting paiting;
    @Mock
    private Author author;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(author.getBorn_year()).thenReturn(1234);
        when(author.getDeath_year()).thenReturn(1289);
        paiting = new Painting("test_sculpture", author, 1245, 200, 300);
    }

    @Test
    public void changeCreationYear_ChangeCreationYearOfAnExhibit_CreationYear() throws YearValidationException {
        paiting.changeCreationYear(1245);
        assertEquals(paiting.getCreationYear(), 1245);
        verify(author, times(2)).getBorn_year();
        verify(author, times(2)).getDeath_year();
    }

    @Test(expected = YearValidationException.class)
    public void changeCreationYear_ChangeCreationYearOfAnExhibitWithInvalidData_ThrowsYearValidationException()
            throws YearValidationException {
        verify(author, times(1)).getBorn_year();
        verify(author, times(1)).getDeath_year();
        paiting.changeCreationYear(2000);
    }
}
