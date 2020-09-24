public class Movies extends Type 
{
	 public Movies () {   	
	}
	private String director;
	private String scriptWriter;
	private String star;
	private int time;
	
	
	public Movies(int year, String company, String title,  String director, String scriptWriter, String star, int time, String category, int copies)
	{ 
		super(year, title, company, category,copies);
		this.director=director;
		this.scriptWriter=scriptWriter;
		this.star=star;
		this.time=time;
	}
	
	public void setDirector(String director)
	{
		this.director=director;
	}
	
	public String getDirector()
	{
		return director;
	}
	
	public void setScriptWriter(String scriptWriter)
	{
		this.scriptWriter=scriptWriter;
	}
	
	public String getScriptWriter()
	{
		return scriptWriter;
	}
	
	
	public void setStar(String star)
	{
		this.star = star;
	}

	public String getStar()
	{
		return star;
	}
	
	
		public void setMovieTime(int time)
	{
		this.time = time;
	}
	
	
	public int getMovieTime()
	{
		return time;
	}
	
	public String toString()
    {
		String string = super.toString();
		string += " \nThe director is : " +getDirector();
		string += " \nThe script writer is : " +getScriptWriter();
		string += " \nThe star is : " +getStar();
		string += "\nThe movie time is : " +getMovieTime();
		return string;
	   
    }
}
		
	