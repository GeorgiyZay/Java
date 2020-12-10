package com.zaitsev.Task1;

import com.ZaitsevGeorgii.Task1.ATM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ATMTest {

    @ParameterizedTest
    @ValueSource(strings = {"676"})
    void testSumInputCorrect(String str){
        InputStream stream = new ByteArrayInputStream(str.getBytes());
        Long result = ATM.inputSumForCombinations(stream);
        Assertions.assertEquals(676, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2"})
    void testSumInputWithNegative(String str){
        InputStream stream = new ByteArrayInputStream(str.getBytes());
        Assertions.assertThrows(RuntimeException.class, () -> ATM.inputSumForCombinations(stream));
    }

    @ParameterizedTest
    @ValueSource(strings = {"sdfs"})
    void testSumInputWithNotLong(String str){
        InputStream stream = new ByteArrayInputStream(str.getBytes());
        Assertions.assertThrows(InputMismatchException.class, () -> ATM.inputSumForCombinations(stream));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 -23 4 2 gff -3 456.99"})
    void testBanknoteInputCorrect(String str){
        InputStream stream = new ByteArrayInputStream(str.getBytes());
        Long[] result = ATM.inputBanknotesForCombinations(stream);
        Long[] result1 = new Long[]{(long)1, (long)2, (long)4};

        Assertions.assertArrayEquals(result1, result);
    }

    @Test
    void testCalculateCombination(){
        Long[] banknote = new Long[]{(long)1, (long)2, (long)3};
        Assertions.assertEquals(14, ATM.calculateCombination(10, banknote, 2, new ArrayList<String>()));
    }
}
