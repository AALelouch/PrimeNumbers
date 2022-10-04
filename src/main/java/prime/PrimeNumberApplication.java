package main.java.prime;

import main.java.prime.service.CalculateTypeNumber;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberApplication {

    public static void main(String[] args) {

        CalculateTypeNumber calculateTypeNumber = new CalculateTypeNumber();

        List<Integer> integers = new ArrayList<>();

        for (int i = 2; i<=120; i++){
            integers.add(i);
        }

        System.out.println(calculateTypeNumber.calculatePrimeNumbers(integers));

    }

}
