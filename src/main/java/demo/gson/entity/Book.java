package demo.gson.entity;

public class Book
{
    private String id;
    
    private String name;
    
    private boolean isNew;
    
    public Book(String id, String name, boolean isNew)
    {
        this.id = id;
        this.name = name;
        this.isNew = isNew;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public boolean isNew()
    {
        return isNew;
    }
    
    public void setNew(boolean aNew)
    {
        isNew = aNew;
    }
    
    @Override
    public String toString()
    {
        return "Book{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", isNew=" + isNew + '}';
    }
}
