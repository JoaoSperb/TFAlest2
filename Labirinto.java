import java.util.*;

public class Labirinto {

    // Função para converter o valor hexadecimal em binário de 4 bits
    public static String hexToBin(String hex) {
        int value = Integer.parseInt(hex, 16);
        return String.format("%4s", Integer.toBinaryString(value)).replace(' ', '0');
    }

    // Função BFS para percorrer o labirinto e contar as letras maiúsculas
    public static int bfs(String[][] labirinto, boolean[][] visited, int x, int y) {
        // Direções: cima (0), direita (1), baixo (2), esquerda (3)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        // Fila para BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        // Contador de letras maiúsculas
        int countUpper = 0;

        // Realizar BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            // Verificar se a célula contém uma letra maiúscula
            if (Character.isUpperCase(labirinto[cx][cy].charAt(0))) {
                countUpper++;
            }

            // Verificar as células vizinhas
            String cell = labirinto[cx][cy];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // Verificar se a nova posição é válida
                if (nx >= 0 && nx < labirinto.length && ny >= 0 && ny < labirinto[0].length && !visited[nx][ny]) {
                    // Verificar se a direção não está bloqueada
                    if (i == 0 && cell.charAt(0) == '0') { // Cima
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    } else if (i == 1 && cell.charAt(1) == '0') { // Direita
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    } else if (i == 2 && cell.charAt(2) == '0') { // Baixo
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    } else if (i == 3 && cell.charAt(3) == '0') { // Esquerda
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return countUpper;
    }

    // Função principal para processar o labirinto
    public static List<Integer> processLabirinto(int m, int n, String[][] grid) {
        // Convertendo o labirinto de valores hexadecimais para binários
        String[][] labirinto = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                labirinto[i][j] = hexToBin(grid[i][j]);
            }
        }

        // Matriz para marcar as células já visitadas
        boolean[][] visited = new boolean[m][n];

        // Lista para armazenar a contagem de letras maiúsculas em cada zona
        List<Integer> zonesCount = new ArrayList<>();

        // Percorrer todas as células do labirinto
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    // Fazer BFS a partir da célula (i, j)
                    int upperCount = bfs(labirinto, visited, i, j);
                    zonesCount.add(upperCount);
                }
            }
        }

        return zonesCount;
    }

    public static void main(String[] args) {
        // Exemplo de entrada
        int m = 4, n = 4;
        String[][] grid = {
            {"9", "A", "a", "6"},
            {"5", "9", "A", "c"},
            {"5", "5", "F", "3"},
            {"7", "3", "A", "e"}
        };

        // Processar o labirinto e obter o número de letras maiúsculas em cada zona
        List<Integer> result = processLabirinto(m, n, grid);

        // Exibir o resultado
        System.out.println("Número de letras maiúsculas em cada zona: " + result);
    }
}
