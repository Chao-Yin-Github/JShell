package extension;

import util.RawApplication;

/**
 * @author yinchao
 * @version 1.0
 * @Date 2019/8/12 10:04
 */
public class echo implements RawApplication {
    /**
     * echo [string] 输出string，后可接[|grep substring]，这将输出所有包含substring的行。
     * <p>FIXME 并未使用管道，后续优化</p>
     *
     * @param input 用户输入
     */
    @Override
    public void main(String input) {
        String[] commands = input.split("\\|");
        commands[0] = commands[0].substring(5);
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
            commands[1] = commands[1].trim();
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
