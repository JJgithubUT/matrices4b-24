import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CuadroMagico {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static int[] resultados;
    public static int indice = 0;

    // Validar que sea una matriz cuadrada
    public static boolean validar(int r, int c) {
        return r == c;
    }

    // Proceso para pedir los datos del cuadro
    public static int[][] llenarDatos(int[][] m) throws IOException {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.println("Introduce el valor para la posición [" + i + "][" + j + "]:");
                m[i][j] = Integer.parseInt(bufer.readLine());
            }
        }
        return m;
    }

    // Verifica si el cuadro es mágico
    public static boolean esMagico(int[][] cuadro) {
        int n = cuadro.length;
        int sumaObjetivo = sumaRenglones(0, cuadro); // Suma de la primera fila como referencia

        // Verificación de las filas
        for (int i = 0; i < n; i++) {
            int sumaFila = sumaRenglones(i, cuadro);
            System.out.println("Suma de la fila " + i + ": " + sumaFila);
            if (sumaFila != sumaObjetivo) return false;
        }

        // Verificación de las columnas
        for (int i = 0; i < n; i++) {
            int sumaColumna = sumaColumnas(i, cuadro);
            if (sumaColumna != sumaObjetivo) return false;
        }

        // Verificación de las diagonales
        if (sumaDiagonalPrincipal(cuadro) != sumaObjetivo || sumaDiagonalSecundaria(cuadro) != sumaObjetivo) {
            return false;
        }

        return true;
    }

    // Suma de los elementos de una fila
    public static int sumaRenglones(int r, int[][] m) {
        int suma = 0;
        for (int j = 0; j < m[r].length; j++) {
            suma += m[r][j];
        }
        return suma;
    }

    // Suma de los elementos de una columna
    public static int sumaColumnas(int c, int[][] m) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            suma += m[i][c];
        }
        return suma;
    }

    // Suma de la diagonal principal
    public static int sumaDiagonalPrincipal(int[][] m) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            suma += m[i][i];
        }
        return suma;
    }

    // Suma de la diagonal secundaria
    public static int sumaDiagonalSecundaria(int[][] m) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            suma += m[i][m.length - 1 - i];
        }
        return suma;
    }

    public static void main(String[] args) throws IOException {
        int renglones = 0, columnas = 0;
        int[][] cuadro;

        // Pedir los valores de renglones y columnas
        System.out.println("Introduce el número de filas:");
        renglones = Integer.parseInt(bufer.readLine());

        System.out.println("Introduce el número de columnas:");
        columnas = Integer.parseInt(bufer.readLine());

        // Validar que sea una matriz cuadrada
        if (!validar(renglones, columnas)) {
            System.out.println("No cumple con las dimensiones de un cuadro mágico (debe ser cuadrado)");
            System.exit(1);
        } else {
            // El programa del cuadro mágico
            cuadro = new int[renglones][columnas]; // Crear la matriz
            cuadro = llenarDatos(cuadro);

            if (esMagico(cuadro)) {
                System.out.println("El cuadro es mágico");
            } else {
                System.out.println("El cuadro no es mágico");
            }
        }
    }
}
