package com.example.demo.mapper;


import com.example.demo.dto.CryptoCurrencyName;
import com.example.demo.dto.CurrencyPairsDto;
import com.example.demo.model.CryptoCurrency;

public final class CryptoCurrencyMapper {

    public static CryptoCurrency fromPair(CurrencyPairsDto dto) {
        return new CryptoCurrency(
                CryptoCurrencyName.valueOf(dto.getCurr1()),
                dto.getLprice());
    }
}
