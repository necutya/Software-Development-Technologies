package MuseumExhibition;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class SculptureTest {

    private Sculpture sculpture;

    @Mock
    private Author author;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(author.getBorn_year()).thenReturn(1234);
        when(author.getDeath_year()).thenReturn(1289);
        sculpture = new Sculpture("test_sculpture", author, 1245, MaterialType.Clay);
    }


    @Test
    public void changeCreationYear_ChangeCreationYearOfAnExhibit_CreationYear() throws Exception{
        sculpture.changeCreationYear(1245);
        assertEquals(sculpture.getCreationYear(), 1245);
        verify(author, times(2)).getBorn_year();
        verify(author, times(2)).getDeath_year();
    }

    @Test(expected = YearValidationException.class)
    public void changeCreationYear_ChangeCreationYearOfAnExhibitWithInvalidData_ThrowsYearValidationException()
            throws YearValidationException{
        verify(author, times(1)).getBorn_year();
        verify(author, times(1)).getDeath_year();
        sculpture.changeCreationYear(2000);
    }

    @Test
    public void equals_checkEqualityRegardlessOfMaterial_True() throws Exception{
        Sculpture temp = new Sculpture("test_sculpture", author, 1245, MaterialType.Metal);
        assertEquals(sculpture, temp);
    }

    @Test
    public void testMaterialTypeChanging(){
        sculpture.setMaterial(MaterialType.Stone);
        assertEquals(sculpture.getMaterial(), MaterialType.Stone);
    }

}