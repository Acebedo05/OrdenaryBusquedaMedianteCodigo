package daw;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acebedo
 */
public class Ej1 {

    public static void main(String[] args) {
        // Inicializo TAMAÑO.
        final int TAMANO = 15;

        // Creo un array con el tamaño adecuado.
        double[] miarray = new double[TAMANO];

        // Relleno todas las posiciones con 7.5
        for (int i = 0; i < miarray.length; i++) {
            miarray[i] = 7.5;
        }

        // Creo un array copia de miarray.
        double[] miarraycopia = miarray.clone();

        // Imprimo ambos arrays por consola usando toString().
        System.out.println("----------------");
        System.out.println("Miarray: " + Arrays.toString(miarray) + ".");
        System.out.println("----------------");
        System.out.println("MiarrayCopia: " + Arrays.toString(miarraycopia) + ".");
        System.out.println("----------------");

        // Comparo ambos arrays para ver si son iguales.
        if (Arrays.equals(miarray, miarraycopia)) {
            System.out.println("Ambos arrays son iguales.");
        } else {
            System.out.println("Ambos arrays son diferentes.");
        }

        System.out.println("----------------");

        // Cambiar un valor en una posición aleatoria de miarray.
        Random random = new Random();
        int posicion = random.nextInt(TAMANO);
        miarray[posicion] = 6.3;

        // Imprimo ambos arrays por consola usando toString().
        System.out.println("----------------");
        System.out.println("Miarray: " + Arrays.toString(miarray) + ".");
        System.out.println("----------------");
        System.out.println("MiarrayCopia: " + Arrays.toString(miarraycopia) + ".");
        System.out.println("----------------");

        // Comparo ambos arrays para ver si son iguales.
        if (Arrays.equals(miarray, miarraycopia)) {
            System.out.println("Ambos arrays son iguales.");
        } else {
            System.out.println("Ambos arrays son diferentes.");
        }

        System.out.println("----------------");

        // Genero un array int con valores aleatorios.
        int[] arrayAleatorio = new int[TAMANO];
        llenarArrayAleatorio(arrayAleatorio);

//        // Ordeno el array.
//        Arrays.sort(arrayAleatorio);
//        System.out.println("----------------");
//        System.out.println("Array ordenado: " + Arrays.toString(arrayAleatorio) + ".");
//        System.out.println("----------------");
        // Ordeno el array (Burbuja).
        int tpm;
        for (int i = 0; i < arrayAleatorio.length; i++) {
            for (int j = i + 1; j < arrayAleatorio.length; j++) {
                if (arrayAleatorio[i] > arrayAleatorio[j]) {
                    tpm = arrayAleatorio[i];
                    arrayAleatorio[i] = arrayAleatorio[j];
                    arrayAleatorio[j] = tpm;
                }
            }
        }
        System.out.println("----------------");
        System.out.println("Array ordenado: " + Arrays.toString(arrayAleatorio));
        System.out.println("----------------");

        // Preguntar al usuario.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número a buscar: ");
        int numeroBuscar = scanner.nextInt();

        int ubicacion = Arrays.binarySearch(arrayAleatorio, numeroBuscar);

        if (ubicacion < 0) {
            System.out.println("El numero no se encuentra en el array.");
        } else {
            System.out.println("El numero se encuentra en la posición " + ubicacion + " del array.");
        }

        System.out.println("----------------");
        System.out.println("----------------");
        boolean igualarrays = compararArray(miarray, miarraycopia);
        if (igualarrays == true) {
            System.out.println("Ambos arrays son iguales.");
        } else {
            System.out.println("Ambos arrays son diferentes.");
        }
        System.out.println("----------------");
        System.out.println("----------------");

        int resultado = binarySearch(arrayAleatorio);

        if (resultado != -1) {
            System.out.println("El numero se encuentra en la posición " + resultado + " del array.");
        } else {
            System.out.println("El numero no se encuentra en el array.");
        }
    }

    public static void llenarArrayAleatorio(int[] array) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            int aleatorio = random.nextInt(10, 101);
            array[i] = aleatorio;
        }
    }

    public static boolean compararArray(double[] arrayUno, double[] arrayDos) {
        boolean igual = false;

        for (int i = 0; i < arrayUno.length; i++) {
            if (arrayUno[i] == arrayDos[i]) {
                igual = true;
            } else {
                igual = false;
                break;
            }
        }

        return igual;
    }

    public static int binarySearch(int[] array) {
        // Inicializo las variables.
        int mitad = 0;
        int izquierda = 0;
        int derecha = array.length - 1;
        boolean numEncotrado = false;
        int index = -1;

        System.out.println("Array ordenado: " + Arrays.toString(array));
        System.out.println("----------------");

        // Preguntar al usuario.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número a buscar: ");
        int numeroBuscar = scanner.nextInt();

        while ((izquierda <= derecha) && (!numEncotrado)) {
            mitad = (izquierda + derecha) / 2;
            if (array[mitad] == numeroBuscar) {
                numEncotrado = true;
                index = mitad;
            } else if (array[mitad] > numeroBuscar) {
                derecha = mitad - 1;
            } else {
                izquierda = mitad + 1;
            }
        }
        return index;
    }

}
