package me.dio.rest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import me.dio.rest.domain.model.common.EntityCommon;

import java.math.BigDecimal;

@Entity(name = "tb_account")
public class Account extends EntityCommon {

    @Column(unique = true, nullable = false)
    private String number;

    @Column(length = 4, nullable = false)
    private String agency;

    @Column(precision = 2, scale = 13)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 2, scale = 13)
    private BigDecimal limit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
