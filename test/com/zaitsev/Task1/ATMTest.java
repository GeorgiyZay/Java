package com.zaitsev.Task1;

import com.ZaitsevGeorgii.Task1.ATM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class ATMTest {

    @ParameterizedTest
    @ValueSource(strings = {"676", "sadasd", "121sda", "-211", "23342.1213", "102"})
    void testSumInputCorrect(String str){
        InputStream stream = new ByteArrayInputStream(str.getBytes());
        Long result = ATM.inputSumForCombinations(stream);
        Assertions.assertEquals(676, result);
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
    void testAddBanknoteToCombination(){
        Long[] trueResult = new Long[]{(long)1, (long)1, (long)1};
        ArrayList<String> result = new ArrayList<>();
        ATM.addNTimesBanknote(result, 3, (long)1 );
        Assertions.assertEquals(trueResult.length, result.size());
    }

    @Test
    void testCalculateCombination(){
        Long[] banknote = new Long[]{(long)1, (long)2, (long)3};
        Assertions.assertEquals(14, ATM.calculateCombination(10, banknote, 2, new ArrayList<String>()));
    }
}
