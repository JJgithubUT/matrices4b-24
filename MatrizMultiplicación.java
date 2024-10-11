package EstructuraDeDatos.Matrices;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MatrizMultiplicación {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrizA, matrizB, matrizC;
        int r1, c1, r2, c2;
        String leer;

        System.out.println("-----Programa para multiplicar matrices-----");

        System.out.print("Introduce las filas de la matriz A: ");
        leer = br.readLine();
        r1 = Integer.parseInt(leer);
        System.out.print("Introduce las columnas de la matriz A: ");
        leer = br.readLine();
        c1 = Integer.parseInt(leer);

        matrizA = new int[r1][c1];

        System.out.print("Introduce las filas de la matriz B: ");
        leer = br.readLine();
        r2 = Integer.parseInt(leer);
        System.out.print("Introduce las columnas de la matriz B: ");
        leer = br.readLine();
        c2 = Integer.parseInt(leer);
        
        matrizB = new int[r2][c2];

        if (r1 == c2 || r2 == c1) {

            matrizC = new int[r1][c2];

            System.out.println("-----Introducir los valores de la matriz A------");
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[i].length; j++) {
                    System.out.print("MatrizA, celda ["+i+","+j+"]: ");
                    leer = br.readLine();
                    matrizA[i][j] = Integer.parseInt(leer);
                }
            }

            System.out.println("-----Introducir los valores de la matriz B------");
            for (int i = 0; i < matrizB.length; i++) {
                for (int j = 0; j < matrizB[i].length; j++) {
                    System.out.print("MatrizB, celda ["+i+","+j+"]: ");
                    leer = br.readLine();
                    matrizB[i][j] = Integer.parseInt(leer);
                }
            }

            System.out.print("\n-----Multipliación de las matrices-----\n");
            for (int i = 0; i <  matrizA.length; i++) {
                for (int j = 0; j < matrizB[i].length; j++) {
                    for (int k = 0; k < matrizB.length; k++) {
                        matrizC[i][j] = matrizC[i][j] + matrizA[i][k] * matrizB[k][j];
                    }
                }
            }

            System.out.print("\n-----Impresión de matriz 'C'-----\n");
            for (int i = 0; i < matrizC.length; i++) {
                for (int j = 0; j < matrizC[i].length; j++) {
                    System.out.print(matrizC[i][j] + "     ");
                }
                System.out.print("\n");
            }

        } else {
            System.out.println("Error");
        }

        System.out.println("-----Fin del programa-----");

    }
}
