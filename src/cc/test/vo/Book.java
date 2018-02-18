package cc.test.vo;

public class Book 
{
	private String bookId;
	private String bookName;
	private String bookImg;
	private double price;
	private double sellprice;
	private String seller; 
	private int number;

	public Book(String bookId, String bookName,double price,double sellprice,String bookImg,String seller,int number) 
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookImg = bookImg;
		this.price=price;
		this.sellprice=sellprice;
		this.seller=seller;
		this.number=number;
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

	public void setPrice(double price) {
		this.price=price;
	}

	public double getPrice() {
		return price;
	}
	
	public void setSellprice(double sellprice) {
		this.sellprice=sellprice;
	}

	public double getSellprice() {
		return sellprice;
	}
	
	public void setSeller(String seller) {
		this.seller=seller;
	}

	public String getSeller() {
		return seller;
	}
	
	public void setNumber(int number) {
		this.number=number;
	}

	public int getNumber() {
		return number;
	}

}
