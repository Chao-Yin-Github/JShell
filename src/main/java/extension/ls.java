package extension;

import util.RawApplication;

import java.io.File;

/**
 * @author yinchao
 * @Date 2019/8/12 10:22
 */
public class ls implements RawApplication {
    /**
     * ls [option]
     * <p>ls 显示当期目录下的所有文件</p>
     * <p>ls [destination] 显示目标文件夹下的所有文件</p>
     * <p>
     * todo ls现在是默认-l的，即竖着输出，横着输出由于格式问题暂时需要算法的优化
     * </p>
     *
     * @param input ls [option]
     */
    @Override
    public void main(String input) {
        String[] array = input.split(" ");
        if (array.length == 1) {
            ls("");
        } else {
            File file = null;
            for (String arr : array) {
                file = new File(pwd.getAbsoluteAddress(arr));
                if (file.exists()) {
                    ls(arr);
                }
            }
        }
    }

    private void ls(String path) {
        String[] fileList = new File(pwd.getAbsoluteAddress(path)).list();
        if (fileList == null) {
            return;
        }
        for (String file : fileList) {
            System.out.println(file);
        }
    }
}
