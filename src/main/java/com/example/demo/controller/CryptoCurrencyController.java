package com.example.demo.controller;

import com.example.demo.dto.CryptoCurrencyName;
import com.example.demo.model.CryptoCurrency;
import com.example.demo.service.CryptoCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.function.Function;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cryptocurrencies")
public class CryptoCurrencyController {

    private final CryptoCurrencyService cryptoCurrencyService;

    @GetMapping("/minprice")
    public ResponseEntity<CryptoCurrency> getMinLastPrice(@RequestParam("name") String name) {
        return getByLastPrice(name, cryptoCurrencyService::getMaxPriceForCurrency);
    }


    @GetMapping("/maxprice")
    public ResponseEntity<CryptoCurrency> getMaxLastPrice(@RequestParam("name") String name) {
        return getByLastPrice(name, cryptoCurrencyService::getMinPriceForCurrency);
    }


    @GetMapping
    public ResponseEntity<List<CryptoCurrency>> getPageCryptoCurrency(
            @RequestParam(value = "name") String currencyName,
            @RequestParam(value = "page") Integer pageNumber,
            @RequestParam(value = "size") Integer size) {
        var pages = cryptoCurrencyService.getSortedCurrencyByName(CryptoCurrencyName.validateName(currencyName),
                PageRequest.of(pageNumber, size));
        return ResponseEntity.ok(pages.getContent());
    }

    private ResponseEntity<CryptoCurrency> getByLastPrice(String name, Function<CryptoCurrencyName, CryptoCurrency> applier) {
        var record = applier.apply(CryptoCurrencyName.valueOf(name));
        return ResponseEntity.ok(record);
    }
}
