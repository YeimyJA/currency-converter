package com.co.yeimy.currencyconverter.models;
import java.util.Map;

public record ConversionRatesAPI(String base_code, Map<String,String> conversion_rates) {
    
}
