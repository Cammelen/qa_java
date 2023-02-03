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
public class LionTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getLionKittens() {
        Lion lion = new Lion(feline);
        int expectedLionKittens = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualLionKittens = lion.getKittens();
        assertEquals(expectedLionKittens, actualLionKittens);
    }

    String sex;
    boolean expectedhasMane;

    public LionTest(String sex, boolean expectedhasMane) {
        this.sex = sex;
        this.expectedhasMane = expectedhasMane;
    }

    @Parameterized.Parameters
    public static Object[][] maneData() {
        return new Object[][]{
                {"Самец", false},
                {"Самка", false},
        };
    }

    @Test
    public void getMane() {


        Lion lion = new Lion(feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedhasMane, actualHasMane);
    }

    @Test
    public void getForMaleFood() {

        try {
            Lion lion = new Lion("Самец");
            boolean expectMale = true;
            boolean actualMale = lion.doesHaveMane();
            assertEquals(expectMale, actualMale);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    @Test
    public void getForFemaleFood() {

        try {
            Lion lion = new Lion("Самка");
            boolean expectFemale = false;
            boolean actualFemale = lion.doesHaveMane();
            assertEquals(expectFemale, actualFemale);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
}