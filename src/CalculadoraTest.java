import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class CalculadoraTest {

    private Calculadora calc;

    @Before
    public void setUp() {
        calc = new Calculadora();
    }

    @Test
    public void sumaTest() throws Exception {
        assertEquals(4, calc.sumar(8, -4), 0.001);
    }

    @Test
    public void restaTest() throws Exception {
        assertEquals(6, calc.restar(2, -4), 0.001);
    }

    @Test
    public void multiplicacionTest() throws Exception {
        assertEquals(-18, calc.multiplicar(6, -3), 0.001);
    }

    @Test
    public void divisionTest() throws Exception {
        assertEquals(-4, calc.dividir(16, -4), 0.001);
    }

    @Test
    public void sqrtTest() throws Exception {
        assertEquals(4, calc.sqrt(16), 0.001);
    }

    @Test
    public void powTest() throws Exception {
        assertEquals(8, calc.pow(2, 3), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void powNegativoTest() throws Exception {
        calc.pow(2, -1);
    }

    @Test
    public void factorialTest() throws Exception {
        assertEquals(120, calc.factorial(5), 0.001);
    }

    @Test
    public void mediaTest() throws Exception {
        List<Float> numeros = Arrays.asList(2f, 4f, 6f);
        assertEquals(4, calc.media(numeros), 0.001);
    }

    @Test
    public void maximoTest() throws Exception {
        List<Float> numeros = Arrays.asList(2f, 10f, 6f);
        assertEquals(10, calc.maximo(numeros), 0.001);
    }

    @Test
    public void minimoTest() throws Exception {
        List<Float> numeros = Arrays.asList(2f, -1f, 6f);
        assertEquals(-1, calc.minimo(numeros), 0.001);
    }

    @Test
    public void divisionPorCeroTest() throws Exception {
        assertTrue(Float.isInfinite(calc.dividir(5, 0)));
    }
    
    @Test
    public void factorialDe1Test() throws Exception {
        assertEquals(1, calc.factorial(1), 0.001);
    }
    
    @Test
    public void listaUnElementoTest() throws Exception {
        List<Float> lista = Arrays.asList(5f);
        assertEquals(5, calc.media(lista), 0.001);
    }
}