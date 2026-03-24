import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/*
	Declarar firma de métodos que serán sobrescritos
*/
public interface Interfaz extends Remote {
    float dividir(float numero1, float numero2) throws RemoteException;

    float multiplicar(float numero1, float numero2) throws RemoteException;

    float sumar(float numero1, float numero2) throws RemoteException;

    float restar(float numero1, float numero2) throws RemoteException;

    // Metodos implementados
    double sqrt(float numero) throws RemoteException;

    float pow(float base, int exponente) throws RemoteException;

    float factorial(float numero) throws RemoteException;

    float media(List<Float> numeros) throws RemoteException;

    float maximo(List<Float> numeros) throws RemoteException;

    float minimo(List<Float> numeros) throws RemoteException;

}
