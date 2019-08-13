package util;

import java.io.File;

import exception.ArgumentsException;

/**
 * @author yinchao
 * @date 2019/8/12 10:24
 */
public class Mkdir {
    public static void main(String[] array) {

        // 有参数即可循环创建
        try {
            CheckArguments.check(array, 2);
        } catch (ArgumentsException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (int i = 1; i < array.length; i++) {
            File file = new File(Pwd.getAbsoluteAddress(array[i]));
            if (file.exists()) {
                System.out.println("mkdir:无法创建目录 " + "\"" + array[i] + "\":文件已存在");
            } else {
                file.mkdir();
                // TODO 由于权限问题无法`mkdir /123`创建根目录的文件夹
                System.out.println("目录创建成功");
            }
        }
    }
}

