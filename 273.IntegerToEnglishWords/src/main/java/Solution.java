
/**
 * @author IronSid
 * @create 2021-06-26 23:35
 */
public class Solution {
    StringBuilder sb = new StringBuilder();

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int[] parts = new int[4];//{billion,million,thousand,one}
        for (int i = 3; num != 0 && i >= 0; i--) {
            parts[i] = num % 1000;
            num /= 1000;
        }
        for (int i = 0; i < 4; i++) {
            if (parts[i] != 0) {
                thousand(parts[i]);
                switch (i) {
                    case 0:
                        sb.append("Billion ");
                        break;
                    case 1:
                        sb.append("Million ");
                        break;
                    case 2:
                        sb.append("Thousand ");
                        break;
                    case 3:
                        break;
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return new String(sb);
    }


    void thousand(int n) {//0-999
        if (n >= 100) {
            ten(n / 100);
            sb.append("Hundred ");
            n = n % 100;
        }
        hundred(n);
    }

    void hundred(int n) {//0-99
        if (n >= 20 && n < 100) {
            switch (n / 10) {
                case 2:
                    sb.append("Twenty ");
                    break;
                case 3:
                    sb.append("Thirty ");
                    break;
                case 4:
                    sb.append("Forty ");
                    break;
                case 5:
                    sb.append("Fifty ");
                    break;
                case 6:
                    sb.append("Sixty ");
                    break;
                case 7:
                    sb.append("Seventy ");
                    break;
                case 8:
                    sb.append("Eighty ");
                    break;
                case 9:
                    sb.append("Ninety ");
                    break;
            }
            ten(n % 10);
        }
        if (n >= 10 && n <= 19) {
            switch (n) {
                case 10:
                    sb.append("Ten ");
                    break;
                case 11:
                    sb.append("Eleven ");
                    break;
                case 12:
                    sb.append("Twelve ");
                    break;
                case 13:
                    sb.append("Thirteen ");
                    break;
                case 14:
                    sb.append("Fourteen ");
                    break;
                case 15:
                    sb.append("Fifteen ");
                    break;
                case 16:
                    sb.append("Sixteen ");
                    break;
                case 17:
                    sb.append("Seventeen ");
                    break;
                case 18:
                    sb.append("Eighteen ");
                    break;
                case 19:
                    sb.append("Nineteen ");
                    break;

            }
        }
        if (n < 10) {
            ten(n);
        }
    }

    void ten(int n) {
        switch (n) {
            case 0:
                break;
            case 1:
                sb.append("One ");
                break;
            case 2:
                sb.append("Two ");
                break;
            case 3:
                sb.append("Three ");
                break;
            case 4:
                sb.append("Four ");
                break;
            case 5:
                sb.append("Five ");
                break;
            case 6:
                sb.append("Six ");
                break;
            case 7:
                sb.append("Seven ");
                break;
            case 8:
                sb.append("Eight ");
                break;
            case 9:
                sb.append("Nine ");
                break;

        }
    }
}

