package com.co.yeimy.currencyconverter.principal;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.co.yeimy.currencyconverter.services.APIExchangeRate;
import com.co.yeimy.currencyconverter.util.Util;

public class Primary {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int opcion = 0;
        double valueUser = 0;
        String moneda = null;
        Util util = new Util();
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
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println(menu);
            opcion = teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("¡Error! Debes ingresar un número.");
        }
        do {
            switch (opcion) {
                case 1 -> moneda = Util.DOLAR;
                case 2 -> moneda = Util.PESO_ARGENTINO;
                case 3 -> moneda = Util.DOLAR;
                case 4 -> moneda = Util.REAL_BRASILENO;
                case 5 -> moneda = Util.DOLAR;
                case 6 -> moneda = Util.PESO_COLOMBIANO;
            }

            if (opcion < 7) {
                System.out.println("\nIngrese el valor que desea convertir: ");
                valueUser = teclado.nextDouble();
                try {
                    APIExchangeRate rate = new APIExchangeRate();
                    System.out.println(util.getCurrencyUser(opcion, moneda,
                            rate.exchangeRate(moneda).getConversion_rates(), valueUser));
                } catch (Exception ex) {
                    System.out.println("Error intente de nuevo.");
                }
            } else {
                System.out.println("Opción incorrecta");
            }
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("¡Error! Debes ingresar un número.");
            }
        } while (opcion != 7);
    }
}