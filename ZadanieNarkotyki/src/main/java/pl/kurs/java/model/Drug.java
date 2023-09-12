package pl.kurs.java.model;

import pl.kurs.java.exceptions.BadQualityException;
import pl.kurs.java.interfaces.DrugController;

import java.util.ArrayList;
import java.util.List;

public class Drug {
    private String name;
    private double price;
    private List<Ingredients> ingredients = new ArrayList<>();
    private DrugController goodQuality;
    private Kid kid;

    public Drug(String name, List<Ingredients> ingredients, DrugController quality) {
        this.name = name;
        this.ingredients.addAll(ingredients);
        if(!quality.checkDrug(this)){
            throw new BadQualityException("Bad quality");
        }else{
            this.goodQuality = quality;
        }
        setPrice();
    }


    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setPrice() {
        price = 10 * getIngredients().size();
    }

    public Kid getKid() {
        return kid;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }

}