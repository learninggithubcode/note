package demo.jvm.chapter3;

/**
 * 验证：如果Survivor空间中相同年龄所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该年龄的对象就可以直接进入老年代
 *
 * jvm参数：-Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
 * @author xiongl
 * @create 2016-08-21 16:41
 */
public class TestTenuringThreshold2
{
    private static final int _1MB = 1024 * 1024;
    
    public static void main(String[] args)
    {
        byte[] allocation1, allocation2, allocation3,allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }
}
