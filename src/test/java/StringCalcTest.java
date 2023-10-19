import org.example.String_Calc;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class StringCalcTest {
    final String_Calc calc=new String_Calc();

    @Test
    public void str_calc_test(){
        assertEquals(0,calc.add(""));
        assertEquals(3,calc.add("3"));
        assertEquals(3,calc.add("1,2"));
        assertEquals(6,calc.add("1,2,3"));
        assertEquals(6,calc.add("1\n2,3"));
        assertEquals(11,calc.add("//[f]\n1f2,3\n5"));
        assertThrows(NumberFormatException.class,()->{calc.add(",1,2");});
        assertThrows(NumberFormatException.class,()->{calc.add("1,\n2");});
        assertThrows(NumberFormatException.class,()->{calc.add("//f]\n1\n22f3,5,6,5");});
        assertThrows(NumberFormatException.class,()->{calc.add("//[f]1\n22f3,5,6,5");});
    }

    }
