package util;

/**
 * @author yinchao
 * @date 2019/8/12 10:04
 */
public class Echo {
    public static void echo(String input, Integer n) {
        String[] commands = input.split("\\|");
        commands[0] = commands[0].substring(n);
        // FIXME 现在是把echo 后面的所有字符拼接起来，但是无法输出‘"’，而且也无法检测双引号匹配问题。
        String[] strings = commands[0].split("\"");
        String command = "";
        for (String arr : strings) {
            if (!arr.isEmpty()) {
                command += arr;
            }
        }
        if (commands.length == 1) {
            System.out.println(command);
        } else {
            String[] array = command.split("\n");
            String[] secondCommand = commands[1].split(" ");
            if ("grep".equals(secondCommand[0])) {
                if (secondCommand.length == 2) {
                    for (String arr : array) {
                        if (arr.contains(secondCommand[1])) {
                            System.out.println(arr);
                        }
                    }
                } else {
                    System.out.println("grep:error too many arguments.");
                }
            } else {
                System.out.println("管道暂时只支持grep命令");
            }
        }
    }
}
