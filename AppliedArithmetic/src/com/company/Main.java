package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);

        List<Integer> input = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = adding -> adding.stream()
                .map(el -> el + 1)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>>  multiply = multipling -> multipling.stream()
                .map(el -> el * 2)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> subtract = substraction -> substraction.stream()
                .map(el -> el - 1)
                .collect(Collectors.toList());

        Consumer<Integer> print = num -> System.out.print(num + " ");

        String commands = scan.nextLine();

        while (!commands.endsWith("end")){
            if (commands.equals("add")){
               input = add.apply(input);
            }else if (commands.equals("multiply")){
                input = multiply.apply(input);
            }else if (commands.equals("subtract")){
                input = subtract.apply(input);
            } else if (commands.equals("print")){
                input.forEach(print);
            }
            commands = scan.nextLine();
        }

    }
}
