package algorithm;

import static java.lang.Math.floor;
import static java.lang.Math.log10;

/**
 * \* User: lucaskc
 * \* Date: 2017/9/24
 * \* Time: 下午5:06
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class NthDigit {
    public int findNthDigit(int n) {
        int number = 0;
        int value = 0;
        while (number < n) {
            value++;
            number += digit(value);
        }
        return findDigit(value, number, n);
    }

    int findDigit(int value, int number, int n) {
        String re = String.valueOf(value);
        int pos = re.length() - 1 - number + n;
        return re.charAt(pos) - '0';
    }

    int digit(int value){
        return (int) (floor(log10(value))+1);
    }

}
