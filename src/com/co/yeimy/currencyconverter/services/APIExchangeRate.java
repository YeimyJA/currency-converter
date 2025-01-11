package com.co.yeimy.currencyconverter.services;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.lang.reflect.Type;
import com.co.yeimy.currencyconverter.models.ConversionRates;
import com.co.yeimy.currencyconverter.models.ConversionRatesAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class APIExchangeRate {
    public ConversionRates exchangeRate (String moneda) throws Exception{
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b54cf7a367a6adaeb6c79838/latest/"+moneda);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        
        HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);   
        
        Gson gson = new Gson();
        ConversionRatesAPI convertion = gson.fromJson(json, ConversionRatesAPI.class);
        ConversionRates rate = new ConversionRates(convertion);      
        return rate;
        //Type tipoMapa = new TypeToken<Map<String, String>>(){}.getType();
        //Map<String,String> mapa = gson2.fromJson(convertion.conversion_rates(), tipoMapa);
    }
}