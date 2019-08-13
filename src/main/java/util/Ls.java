package util;

import java.io.File;

/**
 * @author yinchao
 * @date 2019/8/12 10:22
 */
public class Ls {
    public static void main(String[] array) {
        if (array.length == 1) {
            ls("");
        } else {
            File file = null;
            for (String arr : array) {
                file = new File(Pwd.getAbsoluteAddress(arr));
                if (file.exists()) {
                    ls(arr);
                }
            }
        }
    }

    private static void ls(String path) {
        String[] fileList = new File(Pwd.getAbsoluteAddress(path)).list();
        if ("" != path) {
            System.out.println(path + ":");
        }
        if (fileList == null) {
            return;
        }
        for (String file : fileList) {
            System.out.print(file + "    ");
        }
        System.out.println();
    }
}
