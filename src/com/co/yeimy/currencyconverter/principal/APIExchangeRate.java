package com.co.yeimy.currencyconverter.principal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class APIExchangeRate {
    public void exchangeRate (String moneda) throws Exception{
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b54cf7a367a6adaeb6c79838/latest/"+moneda);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        
        HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Primary miPrimary = gson.fromJson(json, Primary.class);
        }
    }