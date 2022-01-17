package com.example.demo.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyPairsDto {

//    @SerializedName("lprice")
//    private String lastPrice;
//
//    @SerializedName("curr1")
//    private String cryptoCurrencyName;
//
//    @SerializedName("curr2")
//    private String usdCurrency;

    private String lprice;

    private String curr1;

    private String curr2;
}
