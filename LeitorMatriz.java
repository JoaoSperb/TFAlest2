import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorMatriz {

    public static String[][] leMatriz(String filePath) {
        String[][] matriz;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            matriz = new String[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matriz[i][j] = scanner.next();
                }
            }
            
            scanner.close();
            return matriz;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return null;
    } 


    public void printMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}
