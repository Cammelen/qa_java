package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Animal animal;

    private final int ammountOfKittens;
    private final int expectedAmmountOfKittens;

    public FelineTest(int ammountOfKittens, int expectedAmmountOfKittens) {
        this.ammountOfKittens = ammountOfKittens;
        this.expectedAmmountOfKittens = expectedAmmountOfKittens;
    }

    @Parameterized.Parameters
    public static Object[][] ammountKittens() {
        return new Object[][]{
                {10, 10},
                {200, 200}
        };
    }

    @Test
    public void getVerifyGetFood() throws Exception {

        animal.getFood("Травоядное");
        Mockito.verify(animal).getFood("Травоядное");
    }

    @Test
    public void getVerifyTimesGetFood() throws Exception {

        animal.getFood("Хищник");
        animal.getFood("Хищник");
        animal.getFood("Хищник");

        Mockito.verify(animal, Mockito.times(3)).getFood("Хищник");
    }

    @Test
    public void getVerifyAnyGetFood() throws Exception {

        animal.getFood("Хищник");

        Mockito.verify(animal).getFood(Mockito.anyString());
    }

    @Test
    public void getFelineGetKittens() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens(ammountOfKittens);
        assertEquals(expectedAmmountOfKittens, actualKittens);
    }

    @Test
    public void getFelineFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getFelineKittens() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }
}