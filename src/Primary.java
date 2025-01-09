import java.util.Scanner;

public class Primary {
    public static void main(String[] args){
        int opcion = 0;
        String moneda = null;

        System.out.println("**********************");
        System.out.println("\nBienvenid@ al Conversor de Moneda");

        String menu = """
                *** Escriba el numero de la opción para convertir la moneda deseada ***
                1 - Dolar ==> Peso Argentino
                2 - Peso Argentino ==> Dolar
                3 - Dolar ==> Real Brasileño
                4 - Real Brasileño ==> Dolar
                5 - Dolar ==> Peso Colombiano
                6 - Peso Colombiano ==> Dolar
                7 - Salir
                """;              
        @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);
            while (opcion != 7) {
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
                
                switch (opcion) {
                    case 1 -> moneda = "USD";
                    case 2 -> moneda = "ARS";
                    case 3 -> moneda = "UPS";
                    case 4 -> moneda = "BRL";
                    case 5 -> moneda = "UPS";
                    case 6 -> moneda = "COP";
                    default -> {
                        System.out.println("Opción incorrecta");    
                    }
                }
                APIExchangeRate rate = new APIExchangeRate();
                rate.exchangeRate(moneda);
            } catch (Exception ex) {
                System.out.println("Error intente de nuevo.");
            }
        }                      
    }
}
