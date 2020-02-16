package main;

import extension.pwd;
import util.GetInput;
import util.RawApplication;

/**
 * @author Yinchao
 * @Date 2019/8/12 9:40
 */
public class Jshell {

    /**
     * shell 程序入口
     *
     * @param args JShell
     */
    public static void main(String[] args) {
        Jshell jshell = new Jshell();
        jshell.start();
    }

    public void start() {
        String input;
        pwd.init();
        while (true) {
            // 获取输入
            input = GetInput.get();

            if (input.isEmpty()) {
                continue;
            }

            String[] array = input.split(" ");

            RawApplication raw = null;
            try {
                // 通过反射,使用字符串动态生成实例对象
                raw = (RawApplication) Class.forName("extension." + array[0]).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                System.out.println("JShell: command not found: " + array[0]);
                continue;
            }
            // 调用统一的方法
            raw.main(input);
        }
    }
}
