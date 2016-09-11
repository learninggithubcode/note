package demo.fanxing.zyb;

/**
 * Created by zhangyb on 2016/9/4 0004.
 */
public class LinkedList<T>
{
    private static class Node<U>
    {
        U item;
        
        Node<U> next;
        
        Node()
        {
            item = null;
            next = null;
        }
        
        Node(U item, Node<U> next)
        {
            this.item = item;
            this.next = next;
        }
        
        boolean end()
        {
            return item == null && next == null;
        }
    }
    
    private Node<T> top = new Node<>();
    
    public void push(T item)
    {
        top = new Node<>(item, top);
    }
    
    public T pop()
    {
        T result = top.item;
        if (!top.end())
        {
            top = top.next;
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        LinkedList<String> lss = new LinkedList<>();
        for (String s : "a b c".split(" "))
        {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null)
        {
            System.out.println(s);
        }
    }
}
