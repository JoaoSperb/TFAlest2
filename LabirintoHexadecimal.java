public class LabirintoHexadecimal {

    // Função para converter caractere hexadecimal em string binária de 4 bits
    public static String hexParaBin(char hex) {
        int valorDecimal = Character.digit(hex, 16); // Converte para decimal
        return String.format("%4s", Integer.toBinaryString(valorDecimal)).replace(' ', '0'); // Formata como binário
    }

    // Função para exibir conexões de uma matriz hexadecimal
    public static void processarLabirinto(String[][] labirinto) {
        System.out.println("\nConexões binárias das células:");
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                String hex = labirinto[i][j];
                String binario = hexParaBin(hex.charAt(0));
                System.out.print("Célula (" + i + "," + j + "): ");
                System.out.print(binario + " ");

                // Determina conexões
                System.out.print("(Conexões: ");
                if (binario.charAt(0) == '1') System.out.print("Cima ");
                if (binario.charAt(1) == '1') System.out.print("Direita ");
                if (binario.charAt(2) == '1') System.out.print("Baixo ");
                if (binario.charAt(3) == '1') System.out.print("Esquerda ");
                System.out.println(")");
            }
        }
    }
}
