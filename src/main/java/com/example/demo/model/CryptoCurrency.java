package com.example.demo.model;

import com.example.demo.dto.CryptoCurrencyName;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CRYPTO_CURRENCY")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class CryptoCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CRYPTO_CURRENCY_NAME")
    @Enumerated(EnumType.STRING)
    private CryptoCurrencyName cryptoCurrencyName;

    @Column(name = "LAST_PRICE")
    private String lastPrice;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;


    public CryptoCurrency(CryptoCurrencyName cryptoCurrencyName, String lastPrice) {
        this.cryptoCurrencyName = cryptoCurrencyName;
        this.lastPrice = lastPrice;
        this.createDate = LocalDateTime.now();
    }
}
