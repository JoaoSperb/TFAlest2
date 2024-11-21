public class App {
    public static void main(String[] args) {
        LeitorMatriz leitorMatriz = new LeitorMatriz();
        String[][] matriz = leitorMatriz.leMatriz("caso1.txt");
        leitorMatriz.printMatriz(matriz);

    }
}
