package main.java.prime.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculatePrimeBadMonster {

    public int times = 0;
    public CalculatePrimeBadMonster() {
    }

    public List<Integer> excludeNumbers(List<Integer> integers){

        List<Integer> parNumber = new ArrayList<>();

        for(int i = 0; i <= integers.size()-1; i+=6){
            times = times + 1;
            parNumber.add(integers.get(i));

            if (i+2 <= integers.size()-1 ) {
                parNumber.add(integers.get(i + 2));
            }
            if (i+4 <= integers.size()-1 ) {
                parNumber.add(integers.get(i + 4));
            }
        }

        parNumber.remove(0);
        return parNumber;
    }

    public List<Integer> calculateNumber (List<Integer> numbers){

        List<Integer> numbersToMult = new ArrayList<>(numbers);

        Set<Integer> alreadyToMult = new HashSet<>();
        alreadyToMult.add(2);

        Set<Integer> compoundList = new HashSet<>(excludeNumbers(numbers));

        numbers.removeAll(compoundList);
        numbersToMult.removeAll(compoundList);
        numbersToMult.removeAll(alreadyToMult);

        for(int number = 1; number <= numbers.size() - 1; number++) {
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
        return numbers;
    }
}
