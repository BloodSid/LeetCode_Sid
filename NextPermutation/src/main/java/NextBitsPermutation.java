import org.junit.Test;

/**
 * @author IronSid
 * @since 2022-01-24 22:12
 */
public class NextBitsPermutation {
    // TODO 按照bitcount 从大到小举出所有的数即x个0和y个1的全排列
    //  下一个排列算法： 从低向高 找到第一个连续的两个比特是“01”，（若找不到，肯定是最后一个排列）
    //  这两位设为ab，然后把a改成1，b改成0，然后把b到最低位的重排成0...01...1的形势，即0都在1前面
    public int nextBitsPermutaion() {
        return 0;
    }

    @Test
    public void test1() {

    }
}
