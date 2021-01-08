package com.zaitsevGeorgii.task1;

import java.io.InputStream;
import java.util.*;

public class ATM {

    public static Long inputSumForCombinations(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        Long sum;
        System.out.println("Введите сумму");
        try {
            sum = scanner.nextLong();
            if (sum <= 0) {
                throw new RuntimeException("Negative sum");
            }
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат суммы");
            throw e;
        } catch (RuntimeException e) {
            System.out.println("Сумма должна быть положительная");
            throw e;
        }
        return sum;
    }

    public static Long[] inputBanknotesForCombinations(InputStream stream) {
        SortedSet<Long> set = new TreeSet<Long>();
        Scanner scan = new Scanner(stream);

        System.out.println("Введите номиналы для размена через пробел");
        String[] banknotes = scan.nextLine().split(" ");
        for (String banknote : banknotes) {
            try {
                Long num = Long.parseLong(banknote);
                if (num <= 0) {
                    System.out.println("Банкнота '" + num.toString() + "' имеет не положительное значение");
                }
                else {
                    set.add(num);
                }
            } catch (NumberFormatException e) {
                System.out.println("Банкнота '" + banknote + "' имеет неверный формат");
            }
        }
        return set.toArray(new Long[set.size()]);
    }

    public static void addNTimesBanknote(ArrayList<String> list, long n, Long banknotes) {
        for (int i = 0; i < n; i++) {
            list.add(banknotes.toString());
        }
    }

    public static long calculateCombination(long sum, Long[] banknotes, int current_index, ArrayList<String> current_combinations) {
        if (current_index == 0) {
            if (sum % banknotes[0] == 0) {
                ArrayList<String> copy_current_combination = new ArrayList<>(current_combinations);
                addNTimesBanknote(copy_current_combination, sum / banknotes[0], banknotes[0]);
                System.out.println(copy_current_combination);
                return 1;
            } else {
                return 0;
            }
        } else {
            long countCombination = 0;
            for (long i = sum / banknotes[current_index]; i >= 0; i--) {
                ArrayList<String> copy_current_combination = new ArrayList<>(current_combinations);
                addNTimesBanknote(copy_current_combination, i, banknotes[current_index]);
                countCombination += calculateCombination(sum - i * banknotes[current_index], banknotes, current_index - 1, new ArrayList<>(copy_current_combination));
            }
            return countCombination;
        }
    }

    public static void main(String[] args) {
        Long sum = inputSumForCombinations(System.in);
        Long[] banknotes = inputBanknotesForCombinations(System.in);
        if (banknotes.length == 0){
            System.out.println("Набор банкнот пуст");
        }else {
            System.out.println("Для суммы: " + sum.toString());
            System.out.println("И следующего набора банкнот: " + banknotes.toString());
            System.out.println("Существуют следующие варианты размена");
            long result = calculateCombination(sum, banknotes, banknotes.length - 1, new ArrayList<>());
            System.out.println("Игого их: " + result);
        }
    }
}
