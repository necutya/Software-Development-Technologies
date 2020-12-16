package MuseumExhibition;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    private Author author1, author2;

    @Before
    public void setUp() {
        author1 = new Author("Test van Testing", new int[]{1819, 2020});
    }

    @Test
    public void constructorWithTwoArguments_CheckValidness_String() {
        assertEquals(author1.getName(), "Test");
        assertEquals(author1.getSurname(), "van Testing");
    }


    @Test
    public void getInitials_CheckWithValidData_True() {
        assertEquals(author1.getInitials(), "T. T.");
    }

    @Test
    public void getInitials_CheckWithInvalidData_True() {
        assertNotEquals(author1.getInitials(), "T.T.");
    }

}