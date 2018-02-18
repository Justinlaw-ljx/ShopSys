package cc.test.vo;

public class Car {
	private String bookId;
	private String bookName;
	private String bookImg;
	private double price;
	private int num;
	private String seller;

	public Car(String bookId, String bookName, String bookImg,double price,int num,String seller) 
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookImg = bookImg;
		this.price=price;
		this.seller=seller;
		this.num=num;
	}
	public void setBookId(String bookId) {
		this.bookId=bookId;
	}

	public String getBookId() {
		return bookId;
	}
	
	public void setBookName(String bookName) {
		this.bookName=bookName;
	}

	public String getBookName() {
		return bookName;
	}
	
	public void setBookImg(String bookImg) {
		this.bookImg=bookImg;
	}
	
	public String getBookImg() {
		return bookImg;
	}
	public void setNum(int num) 
	{
		if(num>0)
		{
		    this.num=num;
		}
		else
		{
			this.num=0;
		}
	}
	
	public int getNum() {
		return num;
	}
	
	public void setSeller(String seller) {
		this.seller=seller;
	}
	public String getSeller()
	{
		return seller;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}

	public double getPrice() {
		return price;
	}

}
