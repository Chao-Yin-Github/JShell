package util;

import exception.ArgumentsException;

/**
 * @author yinchao
 * @Date 2019/8/12 10:57
 */
public class CheckArguments {

    /**
     * 检测array是否有n个值
     *
     * @param array 命令的字符串数组
     * @param n     目标个数
     * @throws ArgumentsException 自定义参数异常
     */
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
