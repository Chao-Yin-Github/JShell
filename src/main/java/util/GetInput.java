package util;

import java.util.Scanner;

/**
 * @author yinchao
 * @date 2019/8/12 10:11
 */
public class GetInput {
    public static String get() {
        System.out.print("JShell>>" + Pwd.getAddressPath() + ">>");
        StringBuilder inputBuilder = new StringBuilder();
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        if (in.hasNextLine()) {
            inputBuilder.append(in.next());
        }
        String input = inputBuilder.toString();
        input.trim();
        return processing(input);
    }

    /**
     * 大坑键入\n时，分别输入'\'和'n',而非'\n'
     */
    private static String processing(String input) {
        input = input.replaceAll("\\\\n", "\n");
        return input;
    }
}
