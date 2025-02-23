package me.dio.rest.domain.model.common;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseItem extends EntityCommon {

    private String icon;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
