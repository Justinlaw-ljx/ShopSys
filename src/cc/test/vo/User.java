package cc.test.vo;

public class User 
{
	private String name;
	private String password;
	private String kind;
	
	public User(String name,String password,String kind)
	{
		this.name=name;
		this.password=password;
		if(kind.equals("0"))
		{
		    this.kind="���";
		}
		if(kind.equals("1"))
		{
		    this.kind="����";
		}
		if(kind.equals("2"))
		{
		    this.kind="����Ա";
		}
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}
	public void setKind(String kind)
	{
		if(kind.equals("0"))
		{
		    this.kind="���";
		}
		if(kind.equals("1"))
		{
		    this.kind="����";
		}
		if(kind.equals("2"))
		{
		    this.kind="����Ա";
		}
	}
	public String getKind()
	{
		return kind;
	}

}
