import exception.IncorrectSum;
import exception.LowCash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
public class Atm {
    private final HashMap<Nominal, Integer> nominalIntegerHashMap;

    public Atm(Map<Nominal, Integer> nominalIntegerHashMap) {
        this.nominalIntegerHashMap = new HashMap<>(nominalIntegerHashMap);
    }

    public HashMap<Nominal, Integer> get(Integer need) {
        if (need<0){
              throw new IncorrectSum("Сумма должна быть больше 0");
        }
        HashMap<Nominal, Integer> result = new HashMap<>();
        for (Nominal nominal: Arrays.stream(Nominal.values()).sorted((x, y) -> y.nominal.compareTo(x.nominal)).toList()){
            int max = getMax(need, nominal);
            if (max > 0) {
                need -= max * nominal.nominal;
                result.put(nominal, max);
            }
        }
        if (need != 0){
            throw new LowCash("В банкомате нет нужных купюр");
        }
        for (Nominal nominal: Nominal.values()){
            int minus = result.getOrDefault(nominal, 0);
            if (minus != 0){
                nominalIntegerHashMap.put(nominal, nominalIntegerHashMap.get(nominal) - minus);
            }
        }
        return result;
    }
    public Integer getMax(Integer need, Nominal nominal){
        int maxDivide = need / nominal.nominal;
        return Math.min(maxDivide, nominalIntegerHashMap.getOrDefault(nominal,0));
    }
}
