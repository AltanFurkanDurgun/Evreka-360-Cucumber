package com.evreka.Step_Def;

import com.github.javafaker.Faker;

public class training {

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println("faker.nation().capitalCity() = " + faker.nation().capitalCity());

        System.out.println("faker = " + faker.name().lastName());
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        // loading waitlere bak
        //SERVİCE POİNT  ENTİES 362 YE BAK
    }
}
