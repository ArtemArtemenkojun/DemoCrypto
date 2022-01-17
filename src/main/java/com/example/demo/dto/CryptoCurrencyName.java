package com.example.demo.dto;

public enum CryptoCurrencyName {
    BTC, ETH, XRP;

    public static CryptoCurrencyName validateName(String name) {
        try {
            return CryptoCurrencyName.valueOf(name.toUpperCase());
        } catch (Exception exception) {
            throw new RuntimeException("This currency not allowed.");
        }
    }
}
