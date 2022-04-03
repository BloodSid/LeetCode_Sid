package leetcode.editor.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * SumOfScoresOfBuiltStringsSolution Tester.
 *
 * @author IronSid
 * @since 04/03/2022
 * @version 1.0
 */
public class SumOfScoresOfBuiltStringsSolutionTest {
    SumOfScoresOfBuiltStringsSolution.Solution solution = new SumOfScoresOfBuiltStringsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: sumScores(String s)
    */
    @Test
    public void testSumScores1() throws Exception {
        String s = "babab";
        long expected = 9;
        long actual = solution.sumScores(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumScores2() throws Exception {
        String s = "azbazbzaz";
        long expected = 14;
        long actual = solution.sumScores(s);
        assertEquals(expected, actual);
    }

    // 为什么缓存法也是哈希却会 WA : 原因 equals函数写错了，当不撞hash的时候不出错，
    // 一撞哈希，判断equals时会错误地返回true，导致二分的流程出错，从而影响最终结果
    @Test
    public void test() {
        String s = "gxgdijkdvkrowkdryvjvmwknnxkmfscftmcsexzzfrtogbriyvrxydrgjlbjqvbgqlhlkyhgfejeehfrkzpwhlkkacentmfloruijkwuokaofcvmchpfxrcfhditludbbtkuqcbyselmpjvzecldbpzssciwsktbcsfgfyxmxyxebomrldncyrbzxxcupnkfbercnzkaozuryhvhjsxltzcsftmgkmnsqhutbhxoenmtbpdnvyoidjhkzrchhkyvzhmofvvnwlcgfoewpadtafynkuhqsdffqlqewkkxzzcaxuklspousqnlngqeqlalncmhmyjudowmdccnqpblddbhykbetnialbbbfzwerddplcmqilmyqflildhrbvkasafkfkeupoubxoywyyyqnmtgzjfbedbpzivmyggvrgmusocgygtzrqsdjydskeigdvmcskriebltocuaqsptxpmtbcshwsefojelvvspflwolrmfcpavicyzoqcvwzhmpmntfvlwxxijwqbwilbwvwiipbtvojvqjkqsonbnrjleafdubvdtcnwtbwwzuewvdrvczbfrbdulvlidjljjqtzeolitpcpzwpffkwwhvdzvzbcoupxiymzwupvmvwhqyzkxkfjmuxrhgjvnzspnxvztoalgdlkkvtlwvenmezlgdimulquztdnlmttqejngxiuanhttignqqtkhpbwsllrdywrkizhallitbxflqugtjjsyfpouqdqvmlweoopboiblmlcpwjeatptzjknjulzpwtqudoficljadkwgmgpditbmbbwwuypxcinskwiuqwhscrmirkerwftakdubonbegkbxkguagvultircjibxdnaikelmoyqrcckapzjtvupvyjqssgnevldilrfpnlzjfpfwexadmobxcfevhfjshqdshvnmmivkpxjojcludgmwyeivxkhwbtnfszujosvlodyvvcluneeloicslhqkrgtfanpydkshcpnvzvglejyyipgknnzhjebaxnextefqmyvwyalqgibulbrypkiymhqbzhavewwwpfaxpbleixuwadoldosmrfbkxuxnprpxcqjzjejnwtphxbjxwuyaevhunsdvvdkmnkinvorwvrisvuxnudwrkfkasaqwqonntoscdkpztfgysajgvhcodtzqajbrwzfjlptvxlwgowedmtjqiindeghairkyahqnqlsfgciygpjnawxiluviyktwgiyjcvzjhbhjeorxcvpcsbxienveredhxhedkvilenugojcgzslllexzmymbnrullioisekpsrdwhjyuilumxcupwtmzwfkskeuafnsogopyvhscsvboqpvfyvqjrejolontxyjaxunpuhcexctyedsbaowkhtlwnfcbendydwxqzmqusulifvzonqpmrweyrxwrbglxxdvyhrpbsbwgtdsryzpxqgyxqzhymyylzjxrerzpuxcaltbknwyaoabocjjdqhbrzsddpiidpfshgajbnfoseaqyugizadidsfxfpxlhtuzdmvhicxrwemsthwanjdcoxwkcrdveochkhwhaomsgkbijmbnouxjsfvyshfgdzqxvssdhwcfwmphfzakswrmbhgyrulfzmjfnuxntufqefsjyofisbwcnzkxxgwgxtteqfwnnyvotlrrjxymwqfjwvmtjyanjddxdzcjblhaqlrchrwslhofixzgohrzybvrxwrzkavxjjtfzhdfigcuhpomdqkcpadazrzswvtyvpfmhgtvxfwywvipdgciddbwmxzlrpfgdrlsomdmmkrsljtkomjnlmeaqjpvwpwtbgvroplbvcktaqnwusdhjtaiswjviysdcftmecenbgxaevwxzhhuueovdtirumlcxylkuogaoceqwfzcqrfgkpwsqcnelxqbjeyzpbsxdfxpxfrmtsdblwuomzbwpkffjxnvurbzpsgtqaptzyyexjxllkecvcemwasqquwwbnxplyqfmzyagrdseutuwxtjsfddwhcsfsxqybkubdnvzeqszjbokbexymeqhsdrrfsgbsxkcbofcqcmnvzopumhoerivqfoxwvtsqvckcukfhevgnougjqifdctdacokxnmdyynptixznrqsouxfqmrksiyfvbffersrlcajqwuounjbgqzqsqvixmaatecnzhtjyijcymxyaoudzcylrqssplgtrfdckdfbacwtfghuigfocdjljfcenagycwmgdvjwyqoxwucnkhadbctgscranujsyyqeujqavbupkrjhvwluitbwzbmsxcelzzwpvfyaclvkhbjyggeiyvzmcabvfjdegwgvekpklququcouxdjtngmpreojxdpyjcquxbombkkxllvdltgubjigqczsmmmodjftmqknlcbvmravdqbagaxpyzqykwglqmovofgekjxdltuqtrfafqccwxoytrmvblulxvzyqacfkppzlnjcwlkjhzramcqbincwkejmasoyexnydftjmtumsxxlbckojemaovmkvhuuyvuarvhynkcibfnkkprvyxforikwfvjhlblihfyxmrhwlfplhyodbreqepmtowjurhwoblwwzjfgyxnotjqmalpveuulfjocpmbarqlaogjoqjqmnqfhnjayaiwmpguawialkvvibfljcodbmjerzjwepgpoqilrsmuldyqithxojxyfnoshztmgyxauhfnpnowrjsnjcknjhhqjjxlhaegbskpznnwvzkcqjbyuxmlbxysdwxbimmklcnovyxuhalfwudiwfnktwxjfrlkylqnemoahddtrcazukhrquoagcislpevhhhwbidfieevhisqioxnxnacjzaxzfvdiwhtlvbftcoqekdumzcmtjpiqxqbkwmamwkaxejtoalylybnhrvsilrjvojrzgzzsomtrphyrmjlltxvnvlzjhhorzjvqgmqqdwyfoiysldomilikclsnjexxjtsxinuoqcyccrjokejddqxrlafhenuxxjbzodnglvuvxterbfhmapthinkcpjkhnzahtqyumhjdfturhgboayocuvyykonxyiwjfriaawmefvordkksrpzegbpvdmqjdllmmhzbkbvcxazldvcbvvecwfwuivogoknibdeuuksnizxkhhkfqrsyijutnntllsppuglnqxbzwjtzinoubjalpchroygeeeglsiavecckmrnhfppyipgbfyhsicbzwvxwqfeitnajvyrxosdizopbculmflpzxfkmvgitbqgeiosiendkhxddqydkiejunlosbcqvqhnmtvowcdvnqypjlpoybejbbxfguctsbogixovozinqmmnolobfsaisoauhvwoqkuggiidbxukrmtqbqgfninjbbgknhedwbzuuwaeyjxkidaijtvksrjlqqvbnagbjaoexvziwkfgxawdhyyovaninqpqqnpuunnrstobwqovimxkfvizyclstsvbwtlcuuqucrmlcvtlqkvlwcuiecshmzhlvdgaupfobutnayvhderopebdkdkjutmzpxyyvasnhouyebtmypkeqsxewrmbkcivvdlooouwltuglmppxpiqotekfajnwppjkfktkwzluwbsiavaflfawkaxrpxwbuosbhzmuonfuanpiytevqtccytljhnluygwqdfmpfecatuttzfhkntnuteapnvawflfgquiqurcklqzxwhydarrcdurzawdampajwbvempodwseiyxcigusgsccphczxhwkbxobasqfjpywpgyojbhvujhcoeyacftwogeigffndunnxdptjrclgpewpiefdgbbwttqzpfgobvirgkhcezstgzonnljgpidsczvfdscdneydngbmpgvhjynwatvknsikwlwhwmwfeyqctccpkjfqfznbzwsahukxbevkomgabevihgsdnnnvxfruizpkudosevrhnqygfzbxikgvovtjxcbnemccwcewvdjmhbfegopmgvybgrdlalhjfmapwrgwtchmanfcmuwtwtrqdczrpftehcukinpjiastdqrzjlrqacovdigqtnvlpzenbqjoiblyxtlobmspfayiaccjagfdljytviufiplwipobqrzlbwjoksfslkzofikayihanuthtcflhejhjhfmdzsbyodutjptyawnvmdvphfjsknqwototaeypbkqaevbhmlklpggprihrdgxupraddppoliuccnvmczfipbcirzzowwkebitbvpzelhkzytlqjmqlkvkihqsydhvryofamxfvtisqnhcxtuqbpfwatfjhkpjmefptylyvzzdkcjphxraedugcwjrnptekhjenztxxacwncbnilbhzxclpnjxysguaoinjrvoznequarcygiziewpufmcszjavjlfvnapwoilqmrplgpadbcjciqoezhzzdjxrarkgmqjgziexfdxyivkhctvqdhpzpxdjxjidypaxowbbkysxavccgxqhhbxvfgwmkazjtlxhbguqsdmoynnzcpaqxuqxwcuzbhlwwviepfwtdlvtbotgvynmxmimlerhnrqpqymwvwnsquehhnrwthfcvnbtwyospcuemjcciycazccczsjlxlrttoqdemiqobiixkqyrxwjiqkgvxaawyazowomkqadvkjuooxziljyaqudgvcgfczlrvvlnayxwznoikuofeoraardgcesfygjpwmhrxvaeqdmyithiedlpgujfhpvjpbnwejyinxunuaxihlzxqygyzckimavsunlrhrkoqtatlfihnmhhbqdlrjsclimlaoesjcaszilvjyhabdvrocrdnjojaqvwqyzjkqscslwdiylngxgoddeaedbajnbidaemdgcuuxijhcbqtslzcjngsuunheyxstdrqfqjvpegfekasdarghfqrpslacloaswhojipkhhampsbqzdojakroemklqecjhdjokzoixjaapulqkewqfbydtzhladtmzdbqxitfkyhsnokojazmvctgfvnisxzgiiurnjzcpfynhlrpxnmpmlppcwnwptwwekxriblsadqkmhuxovhfezrhngsjcumofypktsdxcqodafehmcqaopomdzmbovhaeydzlizfkwkeuzqqlflvcehggkwizgmjztnyopprnhyyommbvdhfurtfnptwomducukhhnzgpqwosevhegyzujepatewjqzvgyqcmusyrhyigiyyzihyibeyngyqjfdorcvphgtsbhtjgalenwuhgpthqjcvsahmxeovljbpxrjlyuiklomcvonhvvdtajiwewvfombfhvbzthtdyxgfwvaeqwgfnquxejfazgycoasqpfpqjihtaulezwecwdnvgfhduuyvduovvnjhqlxowkyswslqpzxkmpzqhfvtxxltdltzejtxnihnwwdxravnfqolvjrrrsdjuihydzzhjsyqgvyjztnlojhffkbdqacvbhfrsdlrjogtitapfofanvhyltsmbbvugqnjumjimkgzfhzvomnmqqotwiyhmwauzvsykhfedvjifqtcyxawpqocsethoxvryhcihtysqiwudhgplxazplxfuyqksztvsxvgtepweyuasymwgrjpceqeefbroesqfinjwciwutzvutemjefesbubumdywwubpliuviekvlsixwwblnwfqsjxrcfjvuwlqvsveiczrjjnjmxszxvimnqvjvtcrelfxdeobgzlnxsudpzhtafekkwwfaddgqqzpxnmsigawqvahzpntnhechjrgpmnjgjbetohivufrczosoxomvsathkufefpvqataanvjuokwjwykhddhpwrjsukyvbrsculglbsizhxpwczfzaiisokuqmvifrjincjdnbptssohzenvwyzakchoopqnlthfovqlivbfyphlrttctojbnqzhmzvivjjbagnyzwmunwlijtktuhrjlwwmasopjqnxezmqqntewspfcbiomnnpoetzswprsbbluxxsnhzkiugihcjfexasmuqkkicjivvltsgudwosgxprgqvtiyvanevuljpbtpbqsnymewbcdlrrinxghpbbplexusaofosrmrfuibpskcxliuzanqxovnxbbaozohaurtuxlwsddgoqyqxenugvflmziombtzxlqexkkaygofibsofyqjjlzstnvmecrtzvuwgsrudlfivvgysrmmaewuncwmygtvcjcxrenipsoppneacfuurtojzciegypqhmcjraqkrqpjlwyyjymeqvwndfszfookdgbaneurkfdfeuhhxueoaqzoibnwgxljckufqvvilzmyybup";
        long expected = 6694;
        long newScore = solution.sumScores(s);
        int[] scores = solution.getScores();
        assertEquals(expected, newScore);
        OldSolution oldSolution = new OldSolution();
        long oldScore = oldSolution.sumScores(s);
        int[] oldScores = oldSolution.getScores();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != oldScores[i]) {
                sb.append("\ni = ").append(i).append(", scores[i] = ").append(scores[i]).
                        append(", oldScores[i] = ").append(oldScores[i]).append('\n');
            }
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        assertEquals(sb.toString(), newScore, oldScore);
    }

}

// 缓存法
class OldSolution{

    private int[] scores;

    class Str {
        int hash;
        char[] value;
        int start, end;

        public Str(char[] value, int start, int end) {
            this.value = value;
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            Str str = (Str) o;
            if (value == str.value && start == str.start && end == str.end) {
                return true;
            }
            for (int i = start, j = str.start; i < end; i++, j++) {
                if (value[i] != str.value[j]) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int h = hash;
            if (h == 0) {
                for (int i = start; i < end; i++) {
                    h = 31 * h + value[i];
                }
                hash = h;
            }
            return h;
        }
    }

    public long sumScores(String s) {
        long score = 0;
        int n = s.length();
        char[] value = s.toCharArray();
        HashSet<Str> pre = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            pre.add(new Str(value, 0, i));
        }
        scores = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = n - i;
            while (l <= r) {
                int mid = l + r >> 1;
                if (pre.contains(new Str(value, i, i + mid))){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            scores[i] = r;
            score += r;
        }
        return score;
    }

    public int[] getScores() {
        return scores;
    }

}
