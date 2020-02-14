package extension;

import exception.ArgumentsException;
import util.CheckArguments;
import util.RawApplication;

import java.io.File;

/**
 * @author yinchao
 * @Date 2019/8/12 10:24
 */
public class mkdir implements RawApplication {
    /**
     * mkdir [directoryName1,directoryName2,......]
     * <p>创建新的文件夹，参数个数任意</p>
     *
     * @param input mkdir [directoryName1,directoryName2,......]
     */
    @Override
    public void main(String input) {
        String[] array = input.split(" ");
        // 有参数即可循环创建
        try {
            CheckArguments.check(array, 2);
        } catch (ArgumentsException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (int i = 1; i < array.length; i++) {
            File file = new File(pwd.getAbsoluteAddress(array[i]));
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

