package com.co.yeimy.currencyconverter.util;

import java.util.HashMap;
import java.util.Map;

public class Util {
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
}
