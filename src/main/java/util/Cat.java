package util;

import exception.ArgumentsException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yinchao
 * @Date 2019/8/12 10:33
 */
public class Cat {
    /**
     * cat [fileName] 输出文本文件
     *
     * @param array cat [fileName]
     */
    public static void main(String[] array) {
        try {
            CheckArguments.check(array, 2);
        } catch (ArgumentsException e) {
            System.out.println(e.getMessage());
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少输入");
            return;
        }

        try {
            if (new File(Pwd.getAbsoluteAddress(array[1])).isDirectory()) {
                System.out.println("cat: " + array[1] + ": 是一个目录");
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Pwd.getAbsoluteAddress(array[1])));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException!!!");
        }
    }
}
