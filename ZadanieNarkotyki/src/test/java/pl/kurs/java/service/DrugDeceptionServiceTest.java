package pl.kurs.java.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.kurs.java.interfaces.DrugController;
import pl.kurs.java.interfaces.DrugDeceptionController;
import pl.kurs.java.model.Ingredients;
import pl.kurs.java.model.Lsd;
import pl.kurs.java.model.Mdma;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DrugDeceptionServiceTest {

    private DrugDeceptionService drugDeceptionService;


    @Mock
    private DrugDeceptionController drugDeceptionControllerMock;

    @Mock
    private DrugController drugControllerMock;

    @Mock
    private Lsd lsdMock;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        drugDeceptionService = new DrugDeceptionService(drugDeceptionControllerMock);
    }


    @Test
    public void shouldOpenAddFlourMethod() {
        drugDeceptionService.makeMoreDrugs(lsdMock, Ingredients.FLOUR);
        Mockito.verify(drugDeceptionControllerMock).addIngredients(lsdMock, Ingredients.FLOUR);
    }

    @Test
    public void shouldReturnTrueWhenIngredientIsAdded() {
        Mdma mdma = new Mdma("Drug", Arrays.asList(Ingredients.INGREDIENT3, Ingredients.INGREDIENT4, Ingredients.INGREDIENT1),
                d -> d.getIngredients().size()<6, 5);
        drugDeceptionService = new DrugDeceptionService((d,s) -> d.getIngredients().add(s));
        drugDeceptionService.makeMoreDrugs(mdma, Ingredients.FLOUR);
        assertEquals(5, mdma.getIngredients().size());
    }

}
