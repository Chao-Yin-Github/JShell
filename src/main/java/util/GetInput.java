package util;

import java.util.Scanner;

/**
 * @author yinchao
 * @version 1.0
 * @Date 2019/8/12 10:11
 */
public class GetInput {
    /**
     * 获取用户输入的字符串
     * <p>FixMe 没有完全处理转移字符的问题，只是简单处理了一下\n</p>
     *
     * @return 用户输入的字符串
     */
    public static String get() {
        System.out.print("JShell>>" + Pwd.getAddressPath() + ">>");
        StringBuilder inputBuilder = new StringBuilder();
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        if (in.hasNextLine()) {
            inputBuilder.append(in.next());
        }
        String input = inputBuilder.toString();
        input = input.trim();
        return processing(input);
    }

    /**
     * 坑:键入\n时，分别输入'\'和'n',而非'\n'
     * <p>使用此函数预处理一下</p>
     */
    private static String processing(String input) {
        input = input.replaceAll("\\\\n", "\n");
        return input;
    }
}
