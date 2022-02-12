package HJ33;

import java.io.*;

/**
 * @author IronSid
 * @since 2022-02-12 18:20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1;
        while ((line1 = br.readLine()) != null) {
            String line2 = br.readLine();
            int ip1 = 0;
            for (String s : line1.split("\\.")) {
                ip1 <<= 8;
                ip1 |= Integer.parseInt(s);
            }
            int[] mask = {0xFF000000, 0xFF0000, 0xFF00, 0xFF};
            int ip2 = Integer.parseUnsignedInt(line2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append((ip2 & mask[i]) >>> 24 - i * 8).append('.');
            }
            sb.setLength(sb.length() - 1);
            System.out.println(Integer.toUnsignedString(ip1));
            System.out.println(sb);
        }
    }
}
