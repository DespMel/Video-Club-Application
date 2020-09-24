public class Games extends Type 
{	
	private String console;
       public Games(){
	   	super();
	}

	public Games(int year,String title, String company, String category, int copies,String console)
	{
		super(year, title, company, category,copies);
		this.console=console;
	}
	  
	public void setConsole(String console) {
		this.console=console;
	} 
	
	public String getConsole(){
		return console;
	}
	
	public String toString()
    {
		String string = super.toString();
		string += " \nThe console is : " +getConsole();
		return string;
	   
    }
}