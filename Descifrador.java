import java.util.Scanner;

public class Descifrador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el mensaje");
        String mensaje = scanner.nextLine();
        System.out.println("Ingrese el número de veces al correr la letra");
        int veces = scanner.nextInt();
        scanner.close();

        StringBuilder mensajeDescifrado = new StringBuilder();

        for (int i = 0; i < mensaje.length(); i++) {
            char letra = mensaje.charAt(i);
            boolean minuscula = (letra >= 'a' && letra <= 'z');
            boolean mayuscula = (letra >= 'A' && letra <= 'Z');

            if (!(minuscula || mayuscula)) {
                mensajeDescifrado.append(letra);
            } else {
                int base = 'a';

                if (mayuscula) {
                    base = 'A';
                }
                int ascii = (int) letra;

                int nuevoAscii = (ascii - base - veces + 26) % 26 + base;
                char nuevoChar = (char) nuevoAscii;
                mensajeDescifrado.append(nuevoChar);
            }
        }

        System.out.println(mensajeDescifrado.toString());
    }
}