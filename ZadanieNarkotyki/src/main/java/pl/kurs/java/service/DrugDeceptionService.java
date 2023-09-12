package pl.kurs.java.service;

import pl.kurs.java.interfaces.DrugDeceptionController;
import pl.kurs.java.model.Drug;
import pl.kurs.java.model.Ingredients;

public class DrugDeceptionService {
    private DrugDeceptionController drugDeceptionController;

    public DrugDeceptionService(DrugDeceptionController drugFactoryController) {
        this.drugDeceptionController = drugFactoryController;
    }

    public void makeMoreDrugs(Drug d, Ingredients s){
        drugDeceptionController.addIngredients(d , s);
        d.getIngredients().add(s);
    }

}