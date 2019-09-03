package util;

/**
 * <p>用于本shell自己维护工作路径的类</p>
 * <p>
 * FIXME 使用static String 存储路径，不是线程安全的，开启多个shell可能会出现问题。
 * </p>
 *
 * @author yinchao
 * @Date 2019/8/12 10:20
 */
public class Pwd {

    //
    /**
     * <p>shell自己维护工作路径</p>
     * FIXME 突然想到用static有一点不太好:开启两个shell,第二个shell路径初始化会改变第一个shell的路径,会混乱掉
     * 根本就不会好吧！！！static根本就不会重复初始化</(=-"-=)>
     */
    private static String AddressPath;

    /**
     * 无参
     *
     * @return 返回当前工作路径
     */
    public static String getAddressPath() {
        return AddressPath;
    }

    /**
     * 通过property初始化,当且仅当shell初始化时调用一次
     */
    public static void init() {
        AddressPath = System.getProperty("user.dir");
    }

    /**
     * 改变当前路径,并处理得到绝对路径
     *
     * @param fileName （前面可能有文件路径）文件名
     * @return 返回文件的绝对路径
     */
    public static String changeAddressPath(String fileName) {
        AddressPath = getAbsoluteAddress(fileName);
        return AddressPath;
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
            if (AddressPath.length() == 1) {
                return AddressPath + fileName;
            } else {
                return AddressPath + "/" + fileName;
            }
        }
    }

    /**
     * cd .. 命令调用
     *
     * @return 父级文件夹
     */
    public static String previousPath() {
        if (AddressPath.lastIndexOf("/") != AddressPath.indexOf("/")) {
            return AddressPath.substring(0, AddressPath.lastIndexOf("/"));
        } else {
            return AddressPath;
        }
    }
}
