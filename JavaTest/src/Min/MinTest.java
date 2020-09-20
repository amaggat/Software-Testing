package Min;

// deleted old imports from JUnit 4
//import static org.junit.Assert.*;
//import org.junit.*;

// added new imports for JUnit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class MinTest
{
    private List<String> list;   // Test fixture


    @BeforeEach
    public void setUp()
    {
        list = new ArrayList<String>();
    }

    @AfterEach
    public void reset()
    {
        list = null;
    }

    @Test
    public void testForNullList()
    {
        list = null;
        try {
            Min.min (list);
        } catch (NullPointerException e) {
            return;
        }
        fail ("NullPointerException expected");

    }

    @Test
    public void testForNullElement()
    {
        list.add (null);
        list.add ("cat");
        assertThrows(NullPointerException.class, () -> Min.min (list));
    }

    @Test
    public void testForSoloNullElement()
    {
        list.add (null);
        assertThrows(NullPointerException.class, () -> Min.min (list));
    }

    @Test
    @SuppressWarnings ("unchecked")
    public void testMutuallyIncomparable()
    {
        List list = new ArrayList();
        list.add ("cat");
        list.add ("dog");
        list.add (1);
        assertThrows(ClassCastException.class, () -> Min.min (list));
    }

    @Test
    public void testEmptyList()
    {
        assertThrows(IllegalArgumentException.class, () -> Min.min (list));
    }

    @Test
    public void testSingleElement()
    {
        list.add ("cat");
        Object obj = Min.min (list);
        assertTrue (obj.equals ("cat"), "Single Element List");
    }

    @Test
    public void testDoubleElement()
    {
        list.add ("dog");
        list.add ("cat");
        Object obj = Min.min (list);
        assertTrue (obj.equals ("cat"), "Double Element List");
    }
}