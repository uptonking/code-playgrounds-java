package yao.offer;

/**
 * 字符串转整数
 * Created by yaoooo on 8/11/17.
 */
public class C01StrToInt {


    //注意非空、特殊字符、正负号、单个字符串、上下溢出
    public static int convertStrToInt1(String s) throws Exception {

        ///判断非空
        if (s == null || s.length() == 0) {
            throw new Exception("input cannot be null");
        }

        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;
        final int MAX_D10 = INT_MAX / 10;
        final int MAX_M10 = INT_MAX % 10;
        final int MIN_D10 = -(INT_MIN / 10);
        final int MIN_M10 = -(INT_MIN % 10);


        //代表单个数字所使用的进制的基数，如2，8，10，16，其范围在[2,36]
        final int RADIX = 10;
//        final Character[] radixBaseArray = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//        final Set<Character> radixCharSet = new HashSet<>(Arrays.asList(radixBaseArray));

        int result = 0;
        int len = s.length();
        //字符串访问索引
        int i = 0;
        //待处理的当前字符
        int digit = s.charAt(0);
        //是否为负数，默认当正数处理
        boolean negative = false;


//        final char[] input = s.toCharArray();
//       /// 检查输入字符的有效性
//        for (int i = 0; i < len; i++) {
//            if (i == 0) {
//                if (!(radixCharSet.contains(input[i]) || input[i] == '+' || input[i] == '-')) {
//                    throw new NumberFormatException("输入的数字开头只能含有十进制的0-9以及正负号");
//                }
//            } else {
//                if (!radixCharSet.contains(input[i])) {
//                    throw new NumberFormatException("输入的数字只能含有十进制的0-9");
//                }
//            }
//        }

        if (digit == '-' || digit == '+') {

            if (len == 1) {
                throw new Exception("illegal number input");
            }

            if (digit == '-') {
                negative = true;
            }

            i++;

        }

        if (len > 11) {
            throw new Exception("input number is too long");
        }

        while (i < len) {

            digit = s.charAt(i++) - '0';

            ///判断有效字符
            if (digit >= 0 && digit <= 9) {


                ///判断溢出
                if (!negative && (result > MAX_D10 || (result == MAX_D10 && digit > MAX_M10))) {
                    ///防止上溢出
                    throw new Exception("input number bigger than maximum");
                }
                if (negative && (result > MIN_D10 || (result == MIN_D10 && digit > MIN_M10))) {
                    ///防止下溢出
                    throw new Exception("input number smaller than minimum");
                }
                result = result * RADIX + digit;
            } else {
                throw new Exception(s + " contains invalid character");
            }

        }

        return negative ? -result : result;

    }


    ///from jdk
//    public static int parseInt(String s) throws NumberFormatException {
    public static int convertStrToInt(String s) throws NumberFormatException {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */
        int radix = 10;

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }

        int result = 0;
        //默认都当负数处理
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        //最值除10整数部分
        int multmin;
//        当前处理的字符
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"

                if (firstChar == '-') {
                    //负数时改变最值
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw new NumberFormatException(s);

                if (len == 1) // Cannot have lone "+" or "-"
                    throw new NumberFormatException(s);
                i++;
            }

            multmin = limit / radix;

            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), radix);

                if (digit < 0) {
                    throw new NumberFormatException(s);
                }

                //判断倒数第二位
                if (result < multmin) {
                    throw new NumberFormatException(s);
                }
                result *= radix;

                //判断最后一位
                if (result - digit < limit) {
                    throw new NumberFormatException(s);
                }

                //result初值为0，下面处理后一直为负
                result -= digit;
            }
        } else {
            throw new NumberFormatException(s);
        }

        return negative ? result : -result;
    }


}
