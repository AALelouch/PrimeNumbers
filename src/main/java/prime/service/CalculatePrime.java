package main.java.prime.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculatePrime {

    int times = 0;
    public CalculatePrime() {
    }

    public List<Integer> calculateNumber (List<Integer> numbers){

        List<Integer> numbersToMult = new ArrayList<>(numbers);

        Set<Integer> alreadyToMult = new HashSet<>();

        Set<Integer> compoundList = new HashSet<>();

        for(int number = 0; number <= numbers.size() - 1; number++) {
            times = times + 1;

            for (int numberToMult = 0; numberToMult <= numbersToMult.size() - 1; numberToMult++) {
                times = times + 1;
                Integer result = numbers.get(number) * numbersToMult.get(numberToMult);

                //System.out.println(numbers.get(number) + " " + numbersToMult.get(numberToMult) + " " + result);

                compoundList.add(result);
                alreadyToMult.add(numbers.get(number));

                numbers.remove(result);

                int nextResult = 0;
                if (numberToMult < numbersToMult.size() - 1) {
                    nextResult = numbers.get(number) * numbersToMult.get(numberToMult + 1);
                }
                if (nextResult > numbers.get(numbers.size() - 1)) {
                    break;
                }

            }

            numbersToMult.removeAll(compoundList);
            numbersToMult.removeAll(alreadyToMult);

            if (numbers.get(number + 1) * numbersToMult.get(0) > numbers.get(numbers.size() -1)){
                break;
            }

        }

        System.out.println(times);
        return numbers;
    }
}
