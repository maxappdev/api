package com.pelican.api.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class UserRole extends BaseModel {

    private String name;

    public String getName() {
        return name;
    }
}
