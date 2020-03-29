package com.pelican.api.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue
    private long id;

    private Date created_at;

    private Date updated_at;

    private ModelStatus status;

    public long getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public ModelStatus getStatus() {
        return status;
    }
}
