package me.dio.rest.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import me.dio.rest.domain.model.common.EntityCommon;

import java.math.BigDecimal;

@Entity(name = "tb_card")
public class Card extends EntityCommon {

    @Column(unique = true, nullable = false)
    private String number;

    @Column(name = "additional_limit", precision = 2, scale = 13, nullable = false)
    private BigDecimal limit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
