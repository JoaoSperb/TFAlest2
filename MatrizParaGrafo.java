import java.util.function.BiPredicate;

public class MatrizParaGrafo {
    public Grafo converteMatrizParaGrafo(String[][] matriz) {
        Grafo grafo = new Grafo();

        // Adicionar vértices
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                grafo.addVertex(matriz[i][j]);
            }
        }

        // Adicionar arestas com base no filtro
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (binario.charAt(0) == '1' && i-1 >= 0) grafo.addEdge(matriz[i][j], matriz[i-1][j]);
                if (binario.charAt(1) == '1' && j+1 <= matriz.length) grafo.addEdge(matriz[i][j], matriz[i][j+1]);
                if (binario.charAt(2) == '1' && i+1 <= matriz.lenght) grafo.addEdge(matriz[i][j], matriz[i+1][j]);
                if (binario.charAt(3) == '1' && j-1 >= 0) grafo.addEdge(matriz[i][j], matriz[i][j-1]);
            }
        }

        return grafo;
    }
}
