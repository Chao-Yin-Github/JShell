package util;

/**
 * @author yinchao
 * @date 2019/8/12 10:20
 */
public class Pwd {

    // shell自己维护工作路径
    /**
     * FIXME 突然想到用static有一点不太好:开启两个shell,第二个shell路径初始化会改变第一个shell的路径,会混乱掉
     * */
    private static String AddressPath;

    /**
     * 无参,获得当前工作路径
     *
     * @return
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
     * cd命令调用,改变当前路径,处理得到绝对路径
     *
     * @param str fileName
     * @return
     */
    public static String changeAddressPath(String str) {
        AddressPath = getAbsoluteAddress(str);
        return AddressPath;
    }

    /**
     * 获取到传入文件的绝对路径,与第一个命令不同之处在于前者没有参数,后者有参数
     *
     * @param str 文件名
     * @return
     */
    public static String getAbsoluteAddress(String str) {
        if (str.startsWith("/")) {
            return str;
        } else {
            if (AddressPath.length() == 1) {
                return AddressPath + str;
            } else {
                return AddressPath + "/" + str;
            }
        }
    }

    /**
     * cd .. 命令调用,得到父级文件夹
     */
    public static String previousPath() {
        if (AddressPath.lastIndexOf("/") != AddressPath.indexOf("/")) {
            return AddressPath.substring(0, AddressPath.lastIndexOf("/"));
        } else {
            return AddressPath;
        }
    }
}
