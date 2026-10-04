public class Input {
    public static int readint(String message) { 
        while (true) {
            try {
                String valor = IO.readln(message);
                return Integer.parseInt(valor);
            } catch (Exception e) {
                IO.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }
}