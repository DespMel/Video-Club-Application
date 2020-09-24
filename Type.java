public class Type 
{
	 public Type(){   	
	}
	
	private int year;
	private String title;
	private String company;
	private String category;
	private int copies;
	private int numberOfRented;
	
	
	
	public Type(int year,String title, String company, String category, int copies) 
	{
		this.year=year;
		this.title=title;
		this.company=company;
		this.category=category;
		this.copies=copies;
		numberOfRented = 0;
	}
	
	
	//This method checks if the selected item can be rented or not
	
	public boolean checker()
	{
		return (numberOfRented == copies) ? false : true;
	}
	
	public void increaseRentedItem()
	{
		numberOfRented++;
	}
	
	
	
	//This method decreases the Rented Items by one
	
	public void decreaseRentedItem()
	{
		numberOfRented--;
	}
	
	public void setTitle(String title){
		this.title=title;
		
	}
	
	public void setCategory(String category){
		this.category=category;
	}
	
	public void setCopies(int copies){
		this.copies=copies;
	}
	
	public int getCopies(){
		return copies;
	}
	
	public String getCategory(){
		return category;
	}
	
	public String getTitle() {
		
		return title;
	}
	
	public void setYear(int year)
	{
		this.year=year;
	}
	
	public int getYear() 
	{
		return year;
	}
	
	public void setCompany(String company)
	{
		this.company=company;
	}
	
	public String getCompany()
	{
		return company;
	}
	
	
	
	public String toString()
    {
		String string = "\nTitle : " + getTitle() + "\nThe year of release is : "+getYear()+ "\nThe company : "+getCompany();     
		string += "\nThe category is : "+ getCategory();
		return string;
    }
}
	
		
	
	
	