import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class OrdenamientoBubble {

    public static int[] bubbleSort(int[] matriz) {
        int auxiliar = 0;
        boolean noCambios = false;
        do {
            noCambios = false;
            for (int i = 0; i < matriz.length - 1; i++) {
                if ( matriz[i] > matriz[i+1]) {
                    auxiliar = matriz[i];
                    matriz[i] = matriz[i+1];
                    matriz[i+1] = auxiliar;
                    noCambios = true;
                }
            }
        } while (noCambios == true);
        return matriz;
    }

    public static int[] copiarMatriz(int[] oldMatriz) {
        int[] newMatriz = new int[oldMatriz.length];
        for (int i = 0; i < oldMatriz.length; i++) {
            newMatriz[i] = oldMatriz[i];
        }
        return newMatriz;
    }

    public static void main(String[] args) throws IOException {

        int [] matriz, matrizOriginal;
        int tamanio;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String leer;

        System.out.print("Tamaño de matriz: ");
        leer = br.readLine();
        tamanio = Integer.parseInt(leer);

        matriz = new int[tamanio];
        matrizOriginal = new int[tamanio];

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Valor de la matriz en [" + (i + 1) + "]: ");
            leer = br.readLine();
            matriz[i] = Integer.parseInt(leer);
        }

        matrizOriginal = copiarMatriz(matriz);
        matriz = bubbleSort(matriz);
        
        System.out.println("\nResultados: ");
        for (int i = 0; i < tamanio; i++) {
            System.out.println("=> " + (i + 1) + ") " + matrizOriginal[i] + " - " + matriz[i]);
        }

    }

}
