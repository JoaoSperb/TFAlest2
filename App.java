public class App {
    public static void main(String[] args) {
        LeitorMatriz leitorMatriz = new LeitorMatriz();
        LabirintoHexadecimal processadorLabirinto = new LabirintoHexadecimal();
        String[][] matriz = leitorMatriz.leMatriz("caso1.txt");
        
        String[][] matrizBinaria = processadorLabirinto.processarLabirinto(matriz);
        System.out.println("\nMatriz hexadecimal:");
        leitorMatriz.printMatriz(matriz);
        System.out.println("\nMatriz binária:");
        leitorMatriz.printMatriz(matrizBinaria);

    }
}
