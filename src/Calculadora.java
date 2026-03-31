import java.util.List;
import java.rmi.RemoteException;

public class Calculadora implements Interfaz {

    @Override
    public float sumar(float numero1, float numero2) throws RemoteException {
        return numero1 + numero2;
    };

    @Override
    public float restar(float numero1, float numero2) throws RemoteException {
        return numero1 - numero2;
    };

    @Override
    public float multiplicar(float numero1, float numero2) throws RemoteException {
        return numero1 * numero2;
    };

    @Override
    public float dividir(float numero1, float numero2) throws RemoteException {
        return numero1 / numero2;
    };

    @Override
    public double sqrt(float numero) throws RemoteException {
        return Math.sqrt(numero);
    };

    @Override
    public float pow(float base, int exponente) throws RemoteException {

        float result = 1;

        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }
        for (int i = 0; i < exponente; i++) {
            result *= base;
        }

        return result;
    };

    @Override
    public float factorial(float numero) throws RemoteException {

        float result = 1;

        for (float i = numero; i > 1; i--) {
            result *= i;
        }

        return result;
    };

    @Override
    public float media(List<Float> numeros) throws RemoteException {

        float media = 0;

        for (Float numero : numeros) {
            media += numero;
        }

        media /= numeros.size();
        return media;
    };

    @Override
    public float maximo(List<Float> numeros) throws RemoteException {

        float result = numeros.get(0);

        for (Float numero : numeros) {
            if (numero > result)
                result = numero;
        }

        return result;
    };

    @Override
    public float minimo(List<Float> numeros) throws RemoteException {

        float result = numeros.get(0);

        for (Float numero : numeros) {
            if (numero < result)
                result = numero;
        }

        return result;
    };

}
