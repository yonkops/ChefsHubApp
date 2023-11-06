package com.lcsoft.ChefsHubApp.model.entity;

import com.lcsoft.ChefsHubApp.model.entity.BaseEntity;
import com.lcsoft.ChefsHubApp.model.enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoleType name;

    public Role() {
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }
}
