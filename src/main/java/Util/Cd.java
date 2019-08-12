package Util;

import java.io.File;

import Exception.ArgumentsException;

/**
 * @author yinchao
 * @date 2019/8/12 10:32
 * @discription: 调用System.setProperty(" user.dir ", " xxx ")修改user.dir后，
 * 能影响java.io.File和java.nio.file.Path的后续创建，
 * 但不会影响java.io.FileOutputStream、java.lang.Process等，
 * 即写入文件、子进程等当前目录还是进程启动时的目录，不会随系统属性的修改而修改。
 */
public class Cd {
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

        String[] args = array[1].split("/");
        File file;
        String origianlPath = Pwd.getAddressPath();

        //特判cd /
        if(array[1].length()==1&&array[1].startsWith("/")){
            Pwd.changeAddressPath("/");
            return;
        }

        // 预处理绝对路径情况
        if(array[1].startsWith("/")){
            Pwd.changeAddressPath("/");
        }

        for (String arg : args) {
            file = new File(Pwd.getAbsoluteAddress(arg));
            if("".equals(arg)){
//                System.out.println(arg);
//                continue;
            }
            if (file.isDirectory()) {
                if ("..".equals(arg)) {
                    Pwd.changeAddressPath(Pwd.previousPath());
                } else {
                    Pwd.changeAddressPath(arg);
                }
            } else {
                System.out.println("cd: 没有那个目录: " + arg);
                // 将修改过的改回原路径
                Pwd.changeAddressPath(origianlPath);
                return ;
            }
        }
    }
}
