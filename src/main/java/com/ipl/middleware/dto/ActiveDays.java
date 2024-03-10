package com.ipl.middleware.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActiveDays {
    private int key;
    private String label;
    private String color;

    public void setColor(String color){
        this.color=color;
    }

    public String getColor(){
        return color;
    }

}
