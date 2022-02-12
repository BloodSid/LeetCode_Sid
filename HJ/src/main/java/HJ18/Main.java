package HJ18;

import java.io.*;

/**
 * @author IronSid
 * @since 2022-02-12 16:12
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aip = 0, bip = 0, cip = 0, dip = 0, eip = 0, errIp = 0, privIp = 0;
        String line;
        while ((line = br.readLine()) != null) { // 注意 while 处理多个 case
            String[] s = line.split("[.~]+");
            if (s.length != 8) {
                errIp++;
                continue;
            }
            int[] bytes = new int[8];
            for (int i = 0; i < 8; i++) {
                bytes[i] = Integer.parseInt(s[i]);
            }
            // 忽略【0.*.*.*】和【127.*.*.*】
            if (bytes[0] == 0 || bytes[0] == 127) {
                continue;
            }
            int mask = 0;
            for (int i = 4; i < 8; i++) {
                mask <<= 8;
                mask |= bytes[i];
            }
            // 掩码全0或全1，或前面不是全连续的1，就是非法的
            if (mask == 0 || mask == -1 || Integer.bitCount(~mask + 1) != 1) {
                errIp++;
                continue;
            }
            // ABCDE类分类
            if (bytes[0] >= 1 && bytes[0] <= 126) {
                aip++;
            } else if (bytes[0] >= 128 && bytes[0] <= 191) {
                bip++;
            } else if (bytes[0] >= 192 && bytes[0] <= 223) {
                cip++;
            } else if (bytes[0] >= 224 && bytes[0] <= 239) {
                dip++;
            } else if (bytes[0] >= 240 && bytes[0] <= 255) {
                eip++;
            }
            // 私有IP
            if ((bytes[0] == 10) || (bytes[0] == 172 && bytes[1] >= 16 && bytes[1] <= 31) ||
                    (bytes[0] == 192 && bytes[1] == 168)) {
                privIp++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aip).append(' ').append(bip).append(' ').append(cip).append(' ')
                .append(dip).append(' ').append(eip).append(' ').append(errIp).append(' ')
                .append(privIp);
        System.out.println(sb);
    }
}