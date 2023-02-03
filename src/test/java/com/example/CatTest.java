package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;

public class CatTest {

    private Feline feline;

    @Before
    public void setUp() {
        this.feline = Mockito.mock(Feline.class);
    }

    @Test
    public void getSoundTest() {

        Cat cat = new Cat(feline);
        String expectSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectSound, actualSound);
    }

    @Test
    public void getFoodTest() throws Exception {

        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        List<String> expectedFood = List.of("Трава", "Различные растения");
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);

    }
}
