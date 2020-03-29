package com.pelican.api.models;

import javax.persistence.Entity;

@Entity
public class Card extends BaseModel {

    private String frontSide;
    private String backSide;

}
