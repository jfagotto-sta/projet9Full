package com.Mediscreen.PatientAnalysis.Utils;

import java.util.Calendar;
import java.util.Date;

public class AgeCalculator {

    public static int getAgeFromBirthdate(Date dateOfBirth) {

        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        //long age = today.getTime().getTime() - dateOfBirth.getTime();
        //age = age / (1000 * 60 * 60 * 24 * 365);

        birthDate.setTime(dateOfBirth);
        int year1 = today.get(Calendar.YEAR);
        int year2 = birthDate.get(Calendar.YEAR);
        int month1 = today.get(Calendar.MONTH);
        int month2 = birthDate.get(Calendar.MONTH);
        int age = year1 - year2;
        if(month2 > month1) {
            age --;
        } else if(month1 == month2) {
            int j1 = today.get(Calendar.DAY_OF_MONTH);
            int j2 = birthDate.get(Calendar.DAY_OF_MONTH);
            if(j2 > j1) {
                age--;
            }
        }
        return age;
    }
}
