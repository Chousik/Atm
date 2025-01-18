import exception.LowCash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class TestAtm {
    @Test
    void testGet_LowCash(){
        HashMap<Nominal, Integer> nominalIntegerHashMap = new HashMap<>();
        nominalIntegerHashMap.put(Nominal.R50, 1);
        nominalIntegerHashMap.put(Nominal.R100, 1);
        nominalIntegerHashMap.put(Nominal.R500, 1);
        nominalIntegerHashMap.put(Nominal.R1000, 1);
        nominalIntegerHashMap.put(Nominal.R5000, 1);
        Atm atm = new Atm(nominalIntegerHashMap);
        Assertions.assertThrows(LowCash.class, ()->atm.get(10000));
    }
    @Test
    void testGet(){
        HashMap<Nominal, Integer> nominalIntegerHashMap = new HashMap<>();
        nominalIntegerHashMap.put(Nominal.R50, 1);
        nominalIntegerHashMap.put(Nominal.R100, 1);
        nominalIntegerHashMap.put(Nominal.R500, 1);
        nominalIntegerHashMap.put(Nominal.R1000, 1);
        nominalIntegerHashMap.put(Nominal.R5000, 1);
        Atm atm = new Atm(nominalIntegerHashMap);
        HashMap<Nominal, Integer> result = atm.get(650);
        HashMap<Nominal, Integer> assertResult = new HashMap<>();
        assertResult.put(Nominal.R50, 1);
        assertResult.put(Nominal.R100, 1);
        assertResult.put(Nominal.R500, 1);
        Assertions.assertEquals(assertResult, result);
    }
    @Test
    void test_LowCash5250(){
        HashMap<Nominal, Integer> nominalIntegerHashMap = new HashMap<>();
        nominalIntegerHashMap.put(Nominal.R100, 5);
        nominalIntegerHashMap.put(Nominal.R5000, 1);
        Atm atm = new Atm(nominalIntegerHashMap);
        Assertions.assertThrows(LowCash.class, ()->atm.get(5250));
        HashMap<Nominal, Integer> assertResult = new HashMap<>();
        assertResult.put(Nominal.R100, 5);
        assertResult.put(Nominal.R5000, 1);
        HashMap<Nominal, Integer> result = atm.get(5500);
        Assertions.assertEquals(assertResult, result);
    }
}
