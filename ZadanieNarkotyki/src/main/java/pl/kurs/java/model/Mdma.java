package pl.kurs.java.model;

import pl.kurs.java.interfaces.DrugController;

import java.util.List;

public class Mdma extends Drug {

    private int timeBeingHigh;

    public Mdma(String name, List<Ingredients> ingredients, DrugController quality, int timeBeingHigh) {
        super(name, ingredients, quality);
        this.timeBeingHigh = timeBeingHigh;
    }
}
