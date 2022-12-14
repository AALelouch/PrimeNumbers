package main.java.prime.service;

import main.java.prime.model.Number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculateTypeNumber {

    public CalculateTypeNumber() {
    }

    public List<Number> calculatePrimeNumbers(List<Integer> numbers) {

        //The List of integers is mapped to List of Number class
        List<Number> primeNumbers = numbers.stream().map(Number::new).collect(Collectors.toList());

        //We need to know the multiples of each number
        List<Integer> numbersToMult = new ArrayList<>(List.copyOf(numbers));

        //We need to know the compound numbers to evict iterate it
        Set<Integer> compoundNumbers = new HashSet<>();

        Set<Integer> alreadyMult = new HashSet<>();

        for (int number = 0; number<= numbers.size()-1; number++) {

            //Count to know the number of cycles
            Number.TIMES = Number.TIMES + 1;

            //If the number is a compound we will to continue the loop
            if (compoundNumbers.contains(numbers.get(0))) {
                continue;
            }

            //We need to compared when we have the last version of the number list
            List<Integer> listToCompare = primeNumbers.stream().map(Number::getValue)
                    .collect(Collectors.toList());

            //If we have the last version of list of primes, we will to break the loop
            if (new HashSet<>(listToCompare).containsAll(numbersToMult) && Number.TIMES > 1) {
                break;
            }

            //We need to remove all compound numbers to save iterations
            numbersToMult.removeAll(compoundNumbers);
            numbersToMult.removeAll(alreadyMult);

            if (numbers.get(number)*numbersToMult.get(0) > numbers.get(numbers.size() - 1)) {
                break;
            }

            for (int multiplicand: numbersToMult) {

                //Count to know the number of cycles
                Number.TIMES = Number.TIMES + 1;
                int result = numbers.get(number) * multiplicand;

                //We add the result of operation as a compound number
                compoundNumbers.add(result);
                alreadyMult.add(numbers.get(number));

                //If the result of operation is major to the limit of list, we will break the loop
                int nextResult = 0;
                if (numbersToMult.indexOf(multiplicand) < numbersToMult.size() - 1) {
                    nextResult = numbers.get(number) * numbersToMult.get(numbersToMult.indexOf(multiplicand) + 1);
                }

                //We remove the compound number of the list of primes
                primeNumbers.remove(new Number(result));

                if (result > numbersToMult.get(numbersToMult.size() - 1) ||
                        nextResult > numbersToMult.get(numbersToMult.size() - 1)) {
                    break;
                }


            }

            if (number + 1 <= numbers.size() - 1){
                if (compoundNumbers.contains(numbers.get(number + 1))){
                    number = number + 1;
                }
                if (numbers.get(number + 1)*numbersToMult.get(0) > numbers.get(numbers.size() - 1)){
                    break;
                }
            }

        };

        //To know the total of iterations
        //System.out.println(Number.TIMES);
        return primeNumbers;

    }
}
