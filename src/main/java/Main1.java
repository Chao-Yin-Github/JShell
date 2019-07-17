import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Yinchao
 * @date 19-7-17 下午1:01
 */
public class Main1 {
    public static void main(String[] args) {
        String input;
        while (true) {
            System.out.print("JShell>>");
            input = "";
            Scanner in = new Scanner(System.in);
            if (in.hasNextLine()) {
                input = in.nextLine();
            }
            if ("".equals(input)) {
                continue;
            }
            String[] array = input.split(" ");
            if ("hello".equals(array[0]) || "echo".equals(array[0])) {
                for (int i = 1; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                if (1 != array.length) {
                    System.out.println();
                }
            } else if ("grep".equals(array[0])) {
                /*
                TODO wating to be done.
                 */
                System.out.println("grep");
            } else if ("pwd".equals(input)) {
                File directory = new File(".");
                try {
                    System.out.println(directory.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if ("ls".equals(input)) {

            } else {
                System.out.println("JShell: command not found:" + array[0]);
            }
        }
    }
}

