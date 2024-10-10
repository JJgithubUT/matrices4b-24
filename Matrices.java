package EstructuraDeDatos.Matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Matrices {
    // para aprendizaje de las caracteristicas de arreglos bidimensonales
    public static void main(String[] args) throws IOException {
        // matriz cuadrada
        int[][] matriz1 = new int[3][3];
        int numero = 0;

        System.out.println();
        for ( int i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 3; j++ ) {
                matriz1[i][j] = numero;
                numero++;
                System.out.print(matriz1[i][j] + "     ");
            }
            System.out.println();
        }

        System.out.print(matriz1);

        System.out.println();
        int[][] matriz2 = new int[3][5];
        numero = 0;
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                matriz2[i][j] = numero;
                numero++;
                System.out.print(matriz2[i][j] + "     ");
            }
            System.out.println();
        }

        // Ejemplo de una matriz inicializada con valores, llaves {{{{{{{{{{}}}}}}}}}}
        char[][] matriz3 = { {'a', 'b', 'c'}, {'d', 'e'}, {'f'}, {'g', 'h', 'i', 'j'}};
        System.out.println();
        for ( int i = 0; i < matriz3.length; i++ ) {
            for ( int j = 0; j < matriz3[i].length; j++ ) {
                    System.out.print(matriz3[i][j] + "    ");
            }
            System.out.println();
        }

        // Construcción de una matriz iiregular desde teclado
        int[][] matriz4;
        int r, c; // renglores y columnas
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entrada;

        System.out.println("Construcción de una matriz irregular");
        System.out.println("Escribe el numero de renglones:");
        entrada = br.readLine();
        r = Integer.parseInt(entrada);
        // construir matriz cuatro
        matriz4 = new int[r][];
        for ( int i = 0; i < matriz4.length ; i++ ) {
            System.out.print("Escribe columnas para renglon " + (i + 1) + ": ");
            entrada = br.readLine();
            c = Integer.parseInt(entrada);
            matriz4[i] = new int[c];
            for ( int j = 0; j < matriz4[i].length; j++ ) {
                System.out.print("Escribe el valor de ["+i+"]["+j+"]: ");
                entrada = br.readLine();
                matriz4[i][j] = Integer.parseInt(entrada);
            }
        }

        System.out.println();
        for ( int i = 0; i < matriz4.length; i++ ) {
            for ( int j = 0; j < matriz4[i].length; j++ ) {
                System.out.print(matriz4[i][j] + "     ");
            }
            System.out.println();
        }

    }
}