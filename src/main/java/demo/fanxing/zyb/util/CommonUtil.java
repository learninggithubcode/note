package demo.fanxing.zyb.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyb on 2016/9/4 0004.
 */
public class CommonUtil
{
    public static <T> List<T> makeList(T... args)
    {
        List<T> result = new ArrayList<>();
        for (T t : args)
            result.add(t);
        return result;
    }
}
