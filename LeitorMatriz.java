import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorMatriz {
    private String[][] matriz;

    public void leMatriz(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            this.matriz = new String[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.matriz[i][j] = scanner.next();
                }
            }
            

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    } 

    public String[][] getMatriz() {
        return this.matriz;
    }

    public void printMatriz() {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}
