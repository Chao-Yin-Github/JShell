package Util;

import java.io.*;

import Exception.ArgumentsException;

/**
 * @author yinchao
 * @date 2019/8/12 10:18
 */
public class Grep {
    public static void grepString(String[] array) {
        try {
            CheckArguments.check(array, 3);
            FileInputStream fileInputStream = new FileInputStream(Pwd.getAbsoluteAddress(array[2]));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            // TODO 同echo,无法解决"匹配问题
            String[] subString = array[1].split("\"");
            StringBuilder subStringBuilder = new StringBuilder();
            for(String sub:subString){
                subStringBuilder.append(sub);
            }
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(subStringBuilder.toString())) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            File file = new File(Pwd.getAbsoluteAddress(array[2]));
            if (file.isDirectory()) {
                System.out.println("grep: " + array[2] + " 是一个目录");
            } else if (!file.isFile()) {
                System.out.println("grep: " + array[2] + " 没有那个文件");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                ArgumentsException e) {
            System.out.println(e.getMessage());
        } catch (
                ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少参数");
        }
    }

}
