package nj.in.retrofitgenericclient.model;

public class MyPojo
{
    private String id;

    private String title;

    private String userId;

    private String completed;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getCompleted ()
    {
        return completed;
    }

    public void setCompleted (String completed)
    {
        this.completed = completed;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", title = "+title+", userId = "+userId+", completed = "+completed+"]";
    }
}