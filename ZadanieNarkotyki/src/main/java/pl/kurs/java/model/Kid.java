package pl.kurs.java.model;

import pl.kurs.java.exceptions.TheKidIsAlreadyDeadException;

import java.util.ArrayList;
import java.util.List;

public class Kid {
    private String name;
    private String surname;
    private int age;
    private final List<Drug> drugs = new ArrayList<>();

    public Kid(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public  void buyDrug(Drug drug){
        if (drugs.size() >= 5){
            throw new TheKidIsAlreadyDeadException("Bad quality");
        }
        drugs.add(drug);
        if(drug.getKid() != null){
            throw new IllegalArgumentException("This drug was sold");
        }
        drug.setKid(this);
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

}