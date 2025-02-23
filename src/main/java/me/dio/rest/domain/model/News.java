package me.dio.rest.domain.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import me.dio.rest.domain.model.common.BaseItem;

@Entity(name = "tb_news")
public class News extends BaseItem {
}
