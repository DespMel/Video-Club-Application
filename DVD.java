public class DVD extends Movies {
	public DVD(){
	   	super();
	}
	private boolean newRelease;
	public DVD(int year, String title, String company, String director, String scriptWriter,  String star, int time, String category, int copies, boolean newRelease)
	{ 
		super(year, title, company,director, scriptWriter, star, time,category, copies);
		this.newRelease = newRelease;
	}
	
	public void setRelease(boolean newRelease){
		this.newRelease = newRelease;
	}
	
	public boolean getRelease(){
		return newRelease;
	}
	
	public String toString(){
		String myString = super.toString();
		if(newRelease)
			myString += "\nIt's a new Release!!";
		else
			myString += "\nIt's an old Release!!";
		return myString;	
	}
}
	   
