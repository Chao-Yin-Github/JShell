package extension;

import util.RawApplication;

/**
 * @author yinchao
 * @Date 2020/2/14 13:38
 */
public class exit implements RawApplication {
    @Override
    public void main(String input) {
        System.exit(0);
    }
}
