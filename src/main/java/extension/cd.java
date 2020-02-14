package extension;

import exception.ArgumentsException;
import util.CheckArguments;
import util.RawApplication;

import java.io.File;

/**
 * @author yinchao
 * @Date 2019/8/12 10:32
 */
public class cd implements RawApplication {
    /**
     * cd [destination] 跳转到目标路径
     * <p>注意，调用System.setProperty(" user.dir ", " xxx ")修改user.dir后，
     * 能影响java.io.File和java.nio.file.Path的后续创建，
     * 但不会影响java.io.FileOutputStream、java.lang.Process等，
     * 即写入文件、子进程等当前目录还是进程启动时的目录，不会随系统属性的修改而修改。</p>
     * <p>所以，使用util中的{@link pwd}进行维护工作路径</p>
     *
     * @param input cd [destination]
     */

    @Override
    public void main(String input) {
        String[] array = input.split(" ");
        try {
            CheckArguments.check(array, 2);
        } catch (ArgumentsException e) {
            System.out.println(e.getMessage());
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少输入");
            return;
        }

        String[] args = array[1].split("/");
        File file;
        String origianlPath = pwd.getAddressPath();

        //特判cd /
        if (array[1].length() == 1 && array[1].startsWith("/")) {
            pwd.changeAddressPath("/");
            return;
        }

        // 预处理绝对路径情况
        if (array[1].startsWith("/")) {
            pwd.changeAddressPath("/");
        }

        for (String arg : args) {
            file = new File(pwd.getAbsoluteAddress(arg));
            if (file.isDirectory()) {
                if ("..".equals(arg)) {
                    pwd.changeAddressPath(pwd.previousPath());
                } else if (".".equals(arg)) {
                    return;
                } else {
                    pwd.changeAddressPath(arg);
                }
            } else {
                System.out.println("cd: 没有那个目录: " + arg);
                // 将修改过的改回原路径
                pwd.changeAddressPath(origianlPath);
                return;
            }
        }
    }
}
