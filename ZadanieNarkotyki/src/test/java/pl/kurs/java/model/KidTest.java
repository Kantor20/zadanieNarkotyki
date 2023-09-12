package pl.kurs.java.model;

import org.junit.Before;
import org.junit.Test;
import pl.kurs.java.exceptions.BadQualityException;
import pl.kurs.java.exceptions.TheKidIsAlreadyDeadException;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KidTest {

    private Kid kidTest;
    private Lsd lsd;
    private Mdma mdma;
    private Mefedron mefedron;


    @Before
    public void init() {
        kidTest = new Kid("Jan", "Nowak", 12);
        lsd = new Lsd("Drug", Arrays.asList(Ingredients.INGREDIENT3, Ingredients.INGREDIENT4), d -> d.getIngredients().size() < 3, 5);
        mdma = new Mdma("Drug", Arrays.asList(Ingredients.INGREDIENT3, Ingredients.INGREDIENT4), d -> d.getIngredients().size() < 3, 5);
        mefedron = new Mefedron("Drug", Arrays.asList(Ingredients.INGREDIENT3, Ingredients.INGREDIENT4), d -> d.getIngredients().size() < 3, "smieszna");
    }

    @Test
    public void shouldAddDrugToTheAssociationList() {
        kidTest.buyDrug(lsd);
        assertEquals(1, kidTest.getDrugs().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenDrugIsSoldAgain() {
        kidTest.buyDrug(lsd);
        kidTest.buyDrug(lsd);
    }

    @Test(expected = TheKidIsAlreadyDeadException.class)
    public void shouldThrowTheKidIsAlreadyDeadExceptionWhenKidBuySixthDrug() {
        for (int i = 0; i < 6; i++) {
            kidTest.buyDrug(new Lsd("Drug", Arrays.asList(Ingredients.INGREDIENT3, Ingredients.INGREDIENT4), d -> d.getIngredients().size() < 3, 5));
        }
    }


    @Test(expected = BadQualityException.class)
    public void shouldThrowBadDrugQualityExceptionWhenQualityIsBad() {
        lsd = new Lsd("Name", Arrays.asList(Ingredients.INGREDIENT3, Ingredients.INGREDIENT4, Ingredients.INGREDIENT3,
                Ingredients.INGREDIENT4), d -> d.getIngredients().size() < 3, 5);
    }

    @Test
    public void shouldDrugsListBeEqualWithAddedDrugs() {
        kidTest.buyDrug(lsd);
        kidTest.buyDrug(mdma);
        kidTest.buyDrug(mefedron);

        assertEquals(3, kidTest.getDrugs().size());

    }
}
