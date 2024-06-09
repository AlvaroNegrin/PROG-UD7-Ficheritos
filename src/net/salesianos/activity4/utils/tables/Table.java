package net.salesianos.activity4.utils.tables;

import java.io.Serializable;

public class Table implements Serializable{
    private String color;
    private int feetNum;

    public Table(String color, int feetNum) {
        this.color = color;
        this.feetNum = feetNum;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setFeetNum(int feetNum) {
        this.feetNum = feetNum;
    }

    public int getFeetNum() {
        return this.feetNum;
    }

    @Override
    public String toString() {
        return "\nColor: " + this.color + "\nNúmero de patas: " + this.feetNum;
    }
}
