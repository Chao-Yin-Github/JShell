package Util;

import Exception.ArgumentsException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author yinchao
 * @date 2019/8/12 19:04
 */
public class Cp {
    public static void main(String[] array) {

        try {
            CheckArguments.check(array, 3);
        } catch (ArgumentsException e) {
            System.out.println(e.getMessage());
        }

        File file = new File(Pwd.getAbsoluteAddress(array[1]));
        if (file.isDirectory()) {
            System.out.println("暂时不能处理文件夹");
            return;
        } else if (!file.exists()) {
            System.out.println("cp: 没有那个文件或目录: " + array[2]);
        }

        File copy = new File(Pwd.getAbsoluteAddress(array[2]));
        if (copy.isDirectory()) {
            copy = new File(Pwd.getAbsoluteAddress(array[2]) + "/" + array[1]);
        }

        try {
            Files.copy(file.toPath(), copy.toPath());
        } catch (IOException e) {
            System.out.println("可能没有写入权限或其他问题");
        }
    }
}
