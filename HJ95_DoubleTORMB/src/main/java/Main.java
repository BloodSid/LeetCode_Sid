import java.util.Scanner;

/**
 * https://www.nowcoder.com/ta/huawei
 *
 * @author IronSid
 * @create 2021-06-29 0:03
 */
public class Main {
    static StringBuffer sb;
    static char[] digit = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    static char Shi = '拾',
            B = '佰',
            Q = '仟',
            W = '万',
            Y = '亿';

    public static void main(String[] args) {
        //壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String v = in.next();
            sb = new StringBuffer("人民币");
            int len = v.indexOf('.');
            if (len < 0) {
                len = v.length();
            }
            int p = (len - 1) / 4 + 1;
            char[][] n = new char[p][4];
            int kongbai = len - p * 4;
            //把数字从高到低分成若干行，每行4个 如 {1, 2345, 6789}
            for (int i = 0; i < n.length; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i * 4 + j + kongbai >= 0)
                        n[i][j] = v.charAt(i * 4 + j + kongbai);
                }
            }
            for (int i = 0; i < n.length; i++) {
                for (int j = 0; j < 4; j++) {
                    //从第一行的第一个字开始
                    if (i == 0 && j == 0) {
                        j = -kongbai;
                    }
                    //写上数字,如果是零且前一个也是零则不写
                    //即 不是零或前一个不是零 则写
                    if (n[i][j] != '0' || sb.charAt(sb.length() - 1) != '零') {
                        s(n[i][j]);
                    }
                    //如果不是 零，写上 千百十
                    if (n[i][j] != '0') {
                        if (j == 0) {
                            sb.append('仟');
                        } else if (j == 1) {
                            sb.append('佰');
                        } else if (j == 2) {
                            if (n[i][j] == '1') {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            sb.append('拾');
                        }
                    }
                    //写上万和亿
                    if (j == 3) {
                        //从下往上数的行编号
                        int column = n.length - i;
                        if (sb.charAt(sb.length() - 1) == '零') {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        if (column % 2 == 0) {
                            //该行不能都是零 才能写万
                            if (n[i][0] != '0' || n[i][1] != '0'
                                    || n[i][2] != '0' || n[i][3] != '0') {
                                sb.append('万');
                            }
                        } else {
                            if (column != 1) {
                                sb.append('亿');
                            }
                        }
                    }
                }
            }
            sb.append('元');
            //小于一元时
            if (sb.length() == 4) {
                sb.deleteCharAt(sb.length() - 1);
            }

            //角分的判断
            if (len == v.length())
                sb.append('整');
            else {
                if ((v.charAt(len + 1)) != '0') {
                    s(v.charAt(len + 1));
                    sb.append('角');
                }
                if (len + 2 < v.length() && (v.charAt(len + 2)) != '0') {
                    s(v.charAt(len + 2));
                    sb.append('分');
                }
                if (sb.charAt(sb.length() - 1) == '元')
                    sb.append('整');
            }

            System.out.println(sb);
        }


    }

    //    static void s(int i) {//十1-9
//        sb.append(digit[i]);
//    }
    static void s(char i) {//十1-9
        sb.append(digit[i - '0']);
    }
}