package com.example.demo.job;

import com.example.demo.dto.CryptoCurrencyName;
import com.example.demo.dto.CurrencyPairsDto;
import com.example.demo.mapper.CryptoCurrencyMapper;
import com.example.demo.service.CryptoCurrencyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyPuller {

    private static final String BASE_LINK = "https://cex.io/api/last_price/%s/USD";

    private final CryptoCurrencyService cryptoCurrencyService;
    private final RestTemplate restTemplate;
    private final ThreadPoolTaskScheduler executor;

    @Scheduled(fixedRate = 1000)
    public void checkLastPrice() {
        executor.execute(() -> Arrays.stream(CryptoCurrencyName.values()).forEach(this::checkLastPriceByName));
    }

    private void checkLastPriceByName(CryptoCurrencyName cryptoCurrencyName) {

        String currencyLink = String.format(BASE_LINK, cryptoCurrencyName);

        var responseEntity = restTemplate.getForEntity(currencyLink, CurrencyPairsDto.class);

        cryptoCurrencyService.saveCryptoCurrency(CryptoCurrencyMapper.fromPair(responseEntity.getBody()));
    }
}