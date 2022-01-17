package com.example.demo.model.repository;

import com.example.demo.dto.CryptoCurrencyName;
import com.example.demo.model.CryptoCurrency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Integer> {

    @Query(value = "SELECT max(crypto.lastPrice) FROM CryptoCurrency crypto where crypto.cryptoCurrencyName =:name group by crypto.lastPrice")
    CryptoCurrency findMaxLastPrice(@Param("name") CryptoCurrencyName name);


    @Query(value = "SELECT min(crypto.lastPrice) FROM CryptoCurrency crypto where crypto.cryptoCurrencyName =:name group by crypto.lastPrice")
    CryptoCurrency findMinLastPrice(@Param("name") CryptoCurrencyName cryptoCurrencyName);

    Page<CryptoCurrency> findAllByCryptoCurrencyNameOrderByLastPriceAsc(CryptoCurrencyName cryptoCurrencyName, Pageable pageable);

}
