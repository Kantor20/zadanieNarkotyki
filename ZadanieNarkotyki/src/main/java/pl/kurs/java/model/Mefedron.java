package pl.kurs.java.model;

import pl.kurs.java.interfaces.DrugController;

import java.util.List;

public class Mefedron extends Drug{

    private String mine;

    public Mefedron(String name, List<Ingredients> ingredients, DrugController quality, String typeOfFunnyFace) {
        super(name, ingredients, quality);
        this.mine = typeOfFunnyFace;
    }
}
