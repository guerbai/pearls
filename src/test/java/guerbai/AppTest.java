package guerbai;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
//        byte a = 1;
//        byte s = a & 10;
        byte a = 60; /* 60 = 0011 1100 */
        byte b = 13; /* 13 = 0000 1101 */
        byte c = 0;
        c = (byte)(a & b);
        System.out.println(c);
    }
}
