package extension;

import exception.ArgumentsException;
import util.CheckArguments;
import util.RawApplication;

/**
 * <p>用于本shell自己维护工作路径的类</p>
 * <p>
 * </p>
 *
 * @author yinchao
 * @Date 2019/8/12 10:20
 */
public class pwd implements RawApplication {

    //
    /**
     * <p>shell自己维护工作路径</p>
     * static根本就不会重复初始化</(=-"-=)>
     */
    private static String addressPath;

    /**
     * 无参
     *
     * @return 返回当前工作路径
     */
    public static String getAddressPath() {
        return addressPath;
    }

    /**
     * 通过property初始化,当且仅当shell初始化时调用一次
     */
    public static void init() {
        addressPath = System.getProperty("user.dir");
    }

    /**
     * 改变当前路径,并处理得到绝对路径
     *
     * @param fileName （前面可能有文件路径）文件名
     * @return 返回文件的绝对路径
     */
    public static String changeAddressPath(String fileName) {
        addressPath = getAbsoluteAddress(fileName);
        return addressPath;
    }

    /**
     * 获取到传入文件的绝对路径,与第一个命令不同之处在于前者没有参数,后者有参数
     *
     * @param fileName (前面可能有文件路径)文件名
     * @return 返回出入文件的绝对路径
     */
    public static String getAbsoluteAddress(String fileName) {
        if (fileName.startsWith("/")) {
            return fileName;
        } else {
            if (addressPath.length() == 1) {
                return addressPath + fileName;
            } else {
                return addressPath + "/" + fileName;
            }
        }
    }

    /**
     * cd .. 命令调用
     *
     * @return 父级文件夹
     */
    public static String previousPath() {
        if (addressPath.lastIndexOf("/") != addressPath.indexOf("/")) {
            System.out.println("previous path is " + addressPath.substring(0, addressPath.lastIndexOf('/')));
            return addressPath.substring(0, addressPath.lastIndexOf("/"));
        } else {
            return "/";
        }
    }

    @Override
    public void main(String input) {
        try {
            CheckArguments.check(input.split(" "), 1);
            System.out.println(getAddressPath());
        } catch (ArgumentsException e) {
            e.getMessage();
        }
    }
}
