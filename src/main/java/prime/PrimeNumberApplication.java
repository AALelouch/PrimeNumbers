package main.java.prime;

import main.java.prime.service.CalculatePrime;
import main.java.prime.service.CalculatePrimeBadMonster;
import main.java.prime.service.CalculateTypeNumber;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberApplication {

    public static void main(String[] args) {

        CalculateTypeNumber calculateTypeNumber = new CalculateTypeNumber();
        CalculatePrime calculatePrime = new CalculatePrime(); //Last release
        CalculatePrimeBadMonster calculatePrimeBadMonster = new CalculatePrimeBadMonster();

        List<Integer> integers = new ArrayList<>();

        for (int i = 2; i<=120; i++){
            integers.add(i);
        }

        //System.out.println(calculatePrime.calculateNumber(integers));
        System.out.println(calculateTypeNumber.calculatePrimeNumbers(integers));
        System.out.println(calculatePrimeBadMonster.calculateNumber(integers));
        System.out.println(calculatePrimeBadMonster.times);

    }

}
