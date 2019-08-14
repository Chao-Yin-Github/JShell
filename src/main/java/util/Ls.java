package util;

import java.io.File;

/**
 * @author yinchao
 * @date 2019/8/12 10:22
 */
public class Ls {
    /**
     * ls [option]
     * <p>ls 显示当期目录下的所有文件</p>
     * <p>ls [destination] 显示目标文件夹下的所有文件</p>
     * <p>
     * FIXME ls现在是默认-l的，即竖着输出，横着输出由于格式问题暂时需要算法的优化
     * </p>
     *
     * @param array ls [option]
     */
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
        if ("".equals(path)) {
            System.out.println(path + ":");
        }
        if (fileList == null) {
            return;
        }
        for (String file : fileList) {
            System.out.println(file);
        }
    }
}
