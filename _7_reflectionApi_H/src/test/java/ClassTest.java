import org.example.Songs;
import org.junit.Assert;
import org.junit.Test;

public class ClassTest {
    Songs song1 = new Songs("Нервы", 100000000, "Нервы" );
    Songs song2 = new Songs("ПММЛ", 100000, "Земфира" );
    Songs song3 = new Songs("Луч солнца золотого", 40, "Ол зе тиме" );
    Songs song4 = new Songs("Future lover", 30, "Ксюша и Динара" );
    Songs song5 = new Songs("Future lover", 30, "Ксюша и Динара" );


    @Test
    public void assertionMethod(){
        Assert.assertEquals("ПММЛ", song2.name);


    }
    @Test
    public void assertionMethod1(){
        Assert.assertTrue(song1.listeners>10000);

    }
    @Test
    public void assertionMethod2(){
        Assert.assertNotNull(song4);


    }


}
