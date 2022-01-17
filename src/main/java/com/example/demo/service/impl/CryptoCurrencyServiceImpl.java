package com.example.demo.service.impl;

import com.example.demo.dto.CryptoCurrencyName;
import com.example.demo.model.CryptoCurrency;
import com.example.demo.model.repository.CryptoCurrencyRepository;
import com.example.demo.service.CryptoCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {

    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    @Override
    public CryptoCurrency getMaxPriceForCurrency(CryptoCurrencyName cryptoCurrencyName) {
        return cryptoCurrencyRepository.findMaxLastPrice(cryptoCurrencyName);
    }

    @Override
    public CryptoCurrency getMinPriceForCurrency(CryptoCurrencyName cryptoCurrencyName) {
        return cryptoCurrencyRepository.findMinLastPrice(cryptoCurrencyName);
    }

    @Override
    public Page<CryptoCurrency> getSortedCurrencyByName(CryptoCurrencyName cryptoCurrencyName, Pageable pageable) {
        return cryptoCurrencyRepository.findAllByCryptoCurrencyNameOrderByLastPriceAsc(cryptoCurrencyName, pageable);
    }

    @Override
    public CryptoCurrency saveCryptoCurrency(CryptoCurrency cryptoCurrency) {
        return cryptoCurrencyRepository.save(cryptoCurrency);
    }
}
