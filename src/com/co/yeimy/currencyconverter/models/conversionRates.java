package com.co.yeimy.currencyconverter.models;
import java.util.Map;

import com.co.yeimy.currencyconverter.util.Util;

public class ConversionRates {

    private String base_code;
    private Map<String,String> conversion_rates;
    Util util = new Util();
     
    public ConversionRates(ConversionRatesAPI rate) {
        base_code = rate.base_code();
        conversion_rates = rate.conversion_rates();
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public void setConversion_rates(Map<String, String> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, String> getConversion_rates() {
        return conversion_rates;      
    }
}
