package com.co.yeimy.currencyconverter.util;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static final String DOLAR = "USD";
    public static final String PESO_ARGENTINO = "ARS";
    public static final String REAL_BRASILENO = "BRL";
    public static final String PESO_COLOMBIANO = "COP";
    double total = 0;

    public Map<String, String> StringToMap(String string) {
        Map<String, String> mapa = new HashMap<>();

        String[] pares = string.split(",");

        for (String par : pares) {
            String[] entrada = par.split("=");
            if (entrada.length == 2) {
                mapa.put(entrada[0], entrada[1]);
            }
        }
        return mapa;
    }

    public String getCurrencyUser(int opcion, String moneda, Map<String,String> listMap, double valueUser){
        String currencyUser = "";
        if (opcion ==1 & moneda.equals(DOLAR)) {
            total =  valueUser * Double.valueOf(listMap.get(PESO_ARGENTINO));
            currencyUser = "El valor de: "+ valueUser + " " + DOLAR + " equivale al valor final de : " + total + " "+ PESO_ARGENTINO;
        }
        if (opcion ==2 & moneda.equals(PESO_ARGENTINO)) {
            total =  valueUser * Double.valueOf(listMap.get(DOLAR));
            currencyUser = "El valor de: "+ valueUser + " " + PESO_ARGENTINO + " equivale al valor final de : " + total + " "+ DOLAR;
        }
        if (opcion ==3 & moneda.equals(DOLAR)) {
            total =  valueUser * Double.valueOf(listMap.get(REAL_BRASILENO));
            currencyUser = "El valor de: "+ valueUser + " " + DOLAR + " equivale al valor final de : " + total + " "+ REAL_BRASILENO;
        }
        if (opcion ==4 & moneda.equals(REAL_BRASILENO)) {
            total =  valueUser * Double.valueOf(listMap.get(DOLAR));
            currencyUser = "El valor de: "+ valueUser + " " + REAL_BRASILENO + " equivale al valor final de : " + total + " "+ DOLAR;
        }
        if (opcion ==5 & moneda.equals(DOLAR)) {
            total =  valueUser * Double.valueOf(listMap.get(PESO_COLOMBIANO));
            currencyUser = "El valor de: "+ valueUser + " " + DOLAR + " equivale al valor final de : " + total + " "+ PESO_COLOMBIANO;
        }
        if (opcion ==6 & moneda.equals(PESO_COLOMBIANO)) {
            total =  valueUser * Double.valueOf(listMap.get(DOLAR));
            currencyUser = "El valor de: "+ valueUser + " " + PESO_COLOMBIANO + " equivale al valor final de : " + total + " "+ DOLAR;
        }
        return currencyUser;
    }
}
