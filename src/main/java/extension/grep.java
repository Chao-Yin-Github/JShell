package extension;

import exception.ArgumentsException;
import util.CheckArguments;
import util.RawApplication;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author yinchao
 * @version 1.0
 * @Date 2019/8/12 10:18
 */
public class grep implements RawApplication {
    /**
     * grep [substring] [fileName] 从fileName中过滤所有的行
     * <p>FIXME 此处仅仅是过滤，而非正则表达式，后续优化</p>
     *
     * @param input grep [substring] [fileName]
     */
    @Override
    public void main(String input) {
        String[] array = input.split(" ");
        try {
            CheckArguments.check(array, 3);
            FileInputStream fileInputStream = new FileInputStream(pwd.getAbsoluteAddress(array[2]));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            // TODO 同echo,无法解决"匹配问题
            String[] subString = array[1].split("\"");
            StringBuilder subStringBuilder = new StringBuilder();
            for (String sub : subString) {
                subStringBuilder.append(sub);
            }
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(subStringBuilder.toString())) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            File file = new File(pwd.getAbsoluteAddress(array[2]));
            if (file.isDirectory()) {
                System.out.println("grep: " + array[2] + " 是一个目录");
            } else if (!file.isFile()) {
                System.out.println("grep: " + array[2] + " 没有那个文件");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArgumentsException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少参数");
        }
    }

}
