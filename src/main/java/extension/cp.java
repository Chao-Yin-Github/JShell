package extension;

import exception.ArgumentsException;
import util.CheckArguments;
import util.RawApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author yinchao
 * @version 1.0
 * @Date 2019/8/12 19:04
 */
public class cp implements RawApplication {
    /**
     * cp [source] [destination] 把文件从source复制到destination
     * <p>
     * FIXME 没有考虑到非文本文件的问题
     * </p>
     * <p>
     * TODO 后续加入-r命令，使其可以复制文件夹。
     * </p>
     *
     * @param input cp [source] [destination]
     */
    @Override
    public void main(String input) {
        String[] array = input.split(" ");

        try {
            CheckArguments.check(array, 3);
        } catch (ArgumentsException e) {
            System.out.println(e.getMessage());
            return ;
        }

        File file = new File(pwd.getAbsoluteAddress(array[1]));
        if (file.isDirectory()) {
            System.out.println("暂时不能处理文件夹");
            return;
        } else if (!file.exists()) {
            System.out.println("cp: 没有那个文件或目录: " + array[2]);
        }

        File copy = new File(pwd.getAbsoluteAddress(array[2]));
        if (copy.isDirectory()) {
            copy = new File(pwd.getAbsoluteAddress(array[2]) + "/" + array[1]);
        }

        try {
            Files.copy(file.toPath(), copy.toPath());
        } catch (IOException e) {
            System.out.println("可能没有写入权限或其他问题");
        }
    }
}
