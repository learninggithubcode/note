package demo.jvm.chapter3;

/**
 * 验证-XX:MaxTenuringThreshold参数
 *
 * 在以下环境中，-XX:MaxTenuringThreshold=1和-XX:MaxTenuringThreshold=15运行结果一致，没有复现作者所描述的情况
 * java version "1.7.0_71"
 * Java(TM) SE Runtime Environment (build 1.7.0_71-b14)
 * Java HotSpot(TM) 64-Bit Server VM (build 24.71-b01, mixed mode)
 * 
 * jvm参数：-Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 *
 * @author xiongl
 * @create 2016-08-21 16:00
 */
public class TestTenuringThreshold1
{
    private static final int _1MB = 1024 * 1024;
    
    public static void main(String[] args)
    {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
