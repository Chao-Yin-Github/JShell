import Util.*;

/**
 * @author Yinchao
 * @date 2019/8/12 9:40
 */
public class Jshell {

    public static void main(String[] args) {
        String input = null;
        Pwd.init();
        while (true) {
            input = GetInput.get();

            if ("".equals(input)) {
                continue;
            }

            String[] array = input.split(" ");

            switch (array[0]) {
                case "hello":
                    Echo.echo(input, 6);
                    break;
                case "echo":
                    Echo.echo(input, 5);
                    break;
                case "grep":
                    Grep.grepString(array);
                    break;
                case "pwd":
                    // TODO 这个判断放到这里其实很突兀,但是一时我也不知道怎么解决,站坑先
                    if (array.length != 1) {
                        System.out.println("pwd: too many arguments");
                        continue;
                    }
                    System.out.println(Pwd.getAddressPath());
                    break;
                case "ls":
                    Ls.main(array);
                    break;
                case "mkdir":
                    Mkdir.main(array);
                    break;
                case "cd":
                    Cd.main(array);
                    break;
                case "cat":
                    Cat.main(array);
                    break;
                case "cp":
                    Cp.main(array);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("JShell: command not found:" + array[0]);
                    break;
            }
        }
    }
}
