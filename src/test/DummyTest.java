import com.receticas.controller.Dummy;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * =====================================================================================
 * Filename: DummyTest.java
 * Version: 1.0
 * Created: 3/9/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
public class DummyTest {
    @Test
    public void sum() throws Exception {
        Dummy dm = new Dummy();
        assertEquals(7, dm.sum(2,5));
    }
}
