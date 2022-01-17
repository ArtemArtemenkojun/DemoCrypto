package com.example.demo.service;

import com.example.demo.dto.CryptoCurrencyName;
import com.example.demo.model.CryptoCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CryptoCurrencyService {

    CryptoCurrency getMaxPriceForCurrency(CryptoCurrencyName cryptoCurrencyName);

    CryptoCurrency getMinPriceForCurrency(CryptoCurrencyName cryptoCurrencyName);

    Page<CryptoCurrency> getSortedCurrencyByName(CryptoCurrencyName cryptoCurrencyName, Pageable pageable);

    CryptoCurrency saveCryptoCurrency(CryptoCurrency cryptoCurrency);

}
