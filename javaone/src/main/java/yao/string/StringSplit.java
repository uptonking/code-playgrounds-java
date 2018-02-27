package yao.string;

/**
 * Created by yaoo on 2/27/18
 */
public class StringSplit {

    /**
     * 根据指定分割符，去掉最后一个分割符尾部的数据
     * 会忽略重复分割符之后的内容
     * /a/b/c.d => a/b
     */
    public static String removeTailByDelimiter(String str, String regex) {
        StringBuffer result = new StringBuffer();
        String[] arr = str.split(regex);
        //todo 检查最后一个分割符后有无内容
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            result.append(arr[i]);
            if (!arr[i].equals("") && i != len - 2) {
                result.append(regex);
            }
        }
        return result.toString();
    }

}
