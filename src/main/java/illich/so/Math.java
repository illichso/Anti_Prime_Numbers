package illich.so;

import java.math.BigDecimal;
import java.math.MathContext;

public class Math {

    public static BigDecimal divide(long longValueOne, long longValueTwo){
        if(longValueTwo == 0){
            return BigDecimal.ZERO;
        }
        BigDecimal nano = new BigDecimal(longValueOne);
        BigDecimal deviser = new BigDecimal(longValueTwo);
        return nano.divide(deviser, MathContext.DECIMAL128);
    }

    public static BigDecimal divide(BigDecimal one, long longValueTwo){
        if(longValueTwo == 0){
            return BigDecimal.ZERO;
        }
        BigDecimal deviser = new BigDecimal(longValueTwo);
        return one.divide(deviser, MathContext.DECIMAL128);
    }
}
