package com.Mediscreen.PatientAnalysis.Utils;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class AgeCalculatorTest {

    @Test
    public void testAge() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1993);
        c.set(Calendar.MONTH, 6);
        c.set(Calendar.DAY_OF_MONTH, 18);
        assertEquals(AgeCalculator.getAgeFromBirthdate(c.getTime()),29);

    }

    @Test
    public void testAge30() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1993);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 20);
        assertEquals(AgeCalculator.getAgeFromBirthdate(c.getTime()),30);

    }

}