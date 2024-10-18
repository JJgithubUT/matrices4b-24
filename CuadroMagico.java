import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CuadroMagico {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;
    public static int[] resultados;
    public static int indice = 0;

    public static boolean validar(int r, int c) {
        // Validar que la matriz sea cuadrada
        return r == c;
    }

    public static int[][] llenarDatos(int[][] m) throws IOException {
        // Proceso para pedir los datos del cuadro
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.println("Introduce el valor para la posición [" + i + "][" + j + "]:");
                m[i][j] = Integer.parseInt(bufer.readLine());
            }
        }
        return m;
    }

    public static boolean esMagico(int[][] cuadro) {
        int s;
        for (int i = 0; i < cuadro.length; i++) {
            s = sumaRenglones(i, cuadro);
            if (i == 0) { 
                resultados[indice] = s; // Guardamos el primer resultado
                indice++;
            } else {
                if (s != resultados[0]) {
                    return false; // Si alguna suma es diferente, no es mágico
                }
            }
        }
        return true; // Si todas las sumas son iguales, es mágico
    }

    public static int sumaRenglones(int r, int[][] m) {
        int suma = 0;
        for (int j = 0; j < m[r].length; j++) {
            suma += m[r][j];
        }
        return suma;
    }

    public static void main(String[] args) throws IOException {
        int renglones = 0, columnas = 0;
        int longArreglo; // Tamaño del arreglo de resultados 
        int[][] cuadro;

        // Pedir los valores de renglones y columnas
        System.out.println("Introduce el número de renglones:");
        renglones = Integer.parseInt(bufer.readLine());

        System.out.println("Introduce el número de columnas:");
        columnas = Integer.parseInt(bufer.readLine());

        // Validar que sea una matriz cuadrada
        if (!validar(renglones, columnas)) {
            System.out.println("No cumple con las dimensiones de un cuadro mágico");
            System.exit(1);
        } else {
            // El programa del cuadro mágico
            cuadro = new int[renglones][columnas]; // Crear la matriz
            cuadro = llenarDatos(cuadro);
            longArreglo = renglones + columnas + 2;
            resultados = new int[longArreglo];
            
            if (esMagico(cuadro)) {
                System.out.println("El cuadro es mágico");
            } else {
                System.out.println("El cuadro no es mágico");
            }
        }
    }
}
