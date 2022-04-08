package com.co.pa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    /*
    0     ------  6     3
    1       ---   3     6 _____------ 1 -> (3 goes to the top!)
    2     ------- 7
    3        -    1
    4      ----   4
    5        --   2
    6      ------ 5
      \____________/-----------------

    x- 0 1 2 3 4 5 6           -> size is list.count
    i- 6,3,7,1,4,2,5 . flip(2)
    O- 7,3,6,1,4,2,5

    main()
    {
    List<int> pancakes = new List<int>() { 6,3,7,1,4,2,5 };
    // start: 6,3,7,1,4,2,5
    SortPancakes(pancakes);
    // end = 1,2,3,4,5,6,7
    }


    SortPancakes(pancakes)
    {
        ???
        flip(pancakes, index ?);
        flip(pancakes, index ?);
    }

    1,2,3,4,5,6,7


    */
    public static void main(String[] args) {
        List<Integer> pancakes = Arrays.asList(6,3,7,1,4,2,5);
        sortPancakes(pancakes).forEach(x-> {System.out.println(x);});
    }

    public static List<Integer> sortPancakes(List<Integer> pancakes){
        for(int i = pancakes.size(); i > 0; i--){
            int positionPancake = getPositionPancake(pancakes, i);
            pancakes = flip(pancakes, positionPancake);
            pancakes = flip(pancakes, (i-1));
        }
        return pancakes;
    }

    public static List<Integer> flip(List<Integer> pancakes, int positionToFlip){
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        for(int i = 0; i < pancakes.size(); i++){
            if(i <= positionToFlip) firstList.add(pancakes.get(i));
            else secondList.add(pancakes.get(i));
        }

        pancakes = new ArrayList<>();
        for(int i = (firstList.size() - 1); i >= 0; i--) pancakes.add(firstList.get(i));

        pancakes.addAll(secondList);
        return pancakes;
    }

    public static int getPositionPancake(List<Integer> pancakes, int pancakeToFind){
        return IntStream.range(0, pancakes.size())
                .filter(i -> pancakes.get(i).equals(pancakeToFind))
                .findFirst().getAsInt();
    }
}
