import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author IronSid
 * @since 2022-07-31 9:57
 */
public class BuildDir {

    // 题目数
    public static final int T = 4;

    public static void main(String[] args) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMdd"));
        String contest = "contest/src/main/java/Contest" + date;
        int idx = 0;
        String suffix = "";
        while(new File(contest + suffix).exists()) {
            idx++;
            suffix = "_" + idx;
        }
        for (int i = 1; i <= T; i++) {
            String dir = contest + suffix + "/T" + i;
            System.out.println(dir);
            File file = new File(dir);
            file.mkdirs();
        }
    }
}
