package Util;

import Exception.ArgumentsException;

/**
 * @author yinchao
 * @date 2019/8/12 10:57
 */
public class CheckArguments {

    public static void check(String[] array, Integer n) throws ArgumentsException {
        if (array.length > n) {
            throw new ArgumentsException(array[0] + ":too many arguments");
        } else if (array.length < n) {
            try {
                throw new ArgumentsException(array[0] + ": 缺少操作数");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}
