import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    Calculadora calc = new Calculadora();

    @Test
    public void addTest1() {

        final float expected = 4;
        final float actual = calc.sumar(8, -4);

        assertEquals("8 + (-4) = 4", actual, expected);
    };

}
