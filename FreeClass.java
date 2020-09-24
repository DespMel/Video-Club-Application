import java.util.*;
import java.io.*;

public class FreeClass {
	
	private static ArrayList<Type> StoreProducts =new ArrayList<Type>();
			
		  public static void displayItems(String theName){
        for(Type item : StoreProducts){
            if(theName == "BlueRay"){
                try{ 
			
                    BlueRay temp = (BlueRay)item;
                    System.out.println(temp.getTitle());
					
                }
                catch(Exception x){}
            }else if(theName == "DVD"){
                try{
                    DVD temp = (DVD)item;
                    System.out.println(temp.getTitle());
					
                }
                catch(Exception x){}
            }else{
                try{
                    Games temp = (Games)item;
                    System.out.println(temp.getTitle());
                }
                catch(Exception x){}
            }
        }
    }

		
	public void loadFile(String path) {
			
		File f = null;
		BufferedReader reader = null;
		Type product = null;
		String line;
		
		String itemType=null;
		String subType=null;
		String title=null;
		int year=0;
		String star=null;
		String director=null;
		String scriptWriter=null;
		String category=null;
		int copies=0;
		String company=null;
		int time=0;
		String console=null;
		
		try {
		 f = new File(path);
		 }
		 
		 catch (NullPointerException e) {
		 System.err.println("File not found.");
		 }
		 
		 try {
		
		 reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		 } 
		 catch (FileNotFoundException e) {
		 System.err.println("Error opening file!");
		 }
		 
		try {
			line = reader.readLine();
			if(line.trim().equalsIgnoreCase("ITEMLIST")){
				while(line!=null){
					line=reader.readLine();
					if(line.equals("{")){
						while(line!=null){
							line=reader.readLine();
							//if(line.trim().equalsIgnoreCase("ITEM")){// This If statement is not working 
								line=reader.readLine();
								if(line!=null){
									if(line.equals("{")){
										while(!line.equals("}")){
											
											if(line.toUpperCase().trim().startsWith("ITEM_TYPE ")){
												itemType=line.substring(10).trim();
											}
											else if(line.toUpperCase().trim().startsWith("SUB_TYPE")){
												subType=line.substring(9).trim();
											}
											else if(line.toUpperCase().trim().startsWith("TITLE")){
												title=line.trim().substring(5).trim();
											}
											else if (line.toUpperCase().trim().startsWith("YEAR")){
												year=Integer.parseInt(line.trim().substring(5).trim());
											}
											else if (line.toUpperCase().trim().startsWith("STAR")){
												star=line.trim().substring(5).trim();
											}
											else if (line.toUpperCase().trim().startsWith("DIRECTOR")){
												director=line.trim().substring(9).trim();
											}
											else if (line.toUpperCase().trim().startsWith("SCRIPTWRITER")){
												scriptWriter=line.trim().substring(13).trim();
											}					
											else if (line.toUpperCase().trim().startsWith("CATEGORY")){
												category=line.substring(9).trim();
											}
											else if(line.toUpperCase().trim().startsWith("COPIES")){
												copies=Integer.parseInt(line.trim().substring(7).trim());
											}
											else if(line.toUpperCase().trim().startsWith("COMPANY")){
												company=line.substring(8).trim();
											}
											
											else if(line.toUpperCase().trim().startsWith("TIME")){
												time=Integer.parseInt(line.substring(5).trim());
											}
											else if(line.toUpperCase().trim().startsWith("CONSOLE")){
												console=line.substring(8).trim();
											}
											line=reader.readLine();
												
										}
										if(itemType != null && title !=null && year !=0){
											if(itemType.equalsIgnoreCase("movie")){
												if(subType.equals("DVD")){
													 product= new DVD();                                                                       
													 product.setTitle(title);
													 product.setYear(year);
													 product.setCompany(company);
													 product.setCategory(category);
													 ((DVD) product).setDirector(director);
													 ((DVD) product).setScriptWriter(scriptWriter);
													 ((DVD) product).setStar(star);
													 ((DVD) product).setMovieTime(time);
													 product.setCopies(copies);
													 StoreProducts.add(product);
												}
												else if(subType.equals("BlueRay")){
													 product = new BlueRay();
													 product.setTitle(title);
													 product.setYear(year);
													 ((BlueRay) product).setStar(star);
													 ((BlueRay) product).setDirector(director);
													 ((BlueRay) product).setScriptWriter(scriptWriter);
													 product.setCategory(category);
													 product.setCopies(copies);
													 product.setCompany(company);
													 ((BlueRay) product).setMovieTime(time);
													 StoreProducts.add(product);
												}
											}
											else if(itemType.equals("game"))
											{	 
												 product= new Games();
												 product.setTitle(title);
												 product.setYear(year);
												 product.setCategory(category);
												 product.setCopies(copies);
												 product.setCompany(company);
												 ((Games) product).setConsole(console);
												 StoreProducts.add(product);
											}
											else{
												System.out.println(" Τhe item type is incorrect ! " );
											}
										}
										else{
											System.out.println(" The item could not be created!");
										}
										itemType=null;
										subType=null;
										title=null;
										year=0;
										star=null;
										director=null;
										scriptWriter=null;
										category=null;
										copies=0;
										company=null;
										time=0;
										console=null;
									}
								}
							//}
						}
					}
				}
			}		
		}
				
		 catch (IOException e) {
			 System.out.println("Sudden end");
		 }
		 try {
			reader.close();
		 } catch (IOException e) {
			System.err.println("Error closing file.");
		 }			 
	}	
	public Type get(int i){
		 return StoreProducts.get(i);
	}
	public int size() {
		 return StoreProducts.size();
	}
	
    public static BlueRay findItemBlueRay(String name){
        for(int i=0;i<StoreProducts.size();i++){
                if(StoreProducts.get(i).getTitle().equalsIgnoreCase(name))
                    return (BlueRay)StoreProducts.get(i);
        }
        return null;
    }
    
    public static DVD findItemDVD(String name){
        for(int i=0;i<StoreProducts.size();i++){
                if(StoreProducts.get(i).getTitle().equalsIgnoreCase(name))
                    return (DVD)StoreProducts.get(i);
        }
        return null;
    }
    
    public static Games findItemGames(String name){
        for(int i=0;i<StoreProducts.size();i++){
                if(StoreProducts.get(i).getTitle().equalsIgnoreCase(name))
                    return (Games)StoreProducts.get(i);
        }
        return null;
    }
    
    public static void addFreeItem(BlueRay item){
        StoreProducts.add(item);
    }
    
    public static void addFreeItem(DVD item){
        StoreProducts.add(item);
    }
    
    public static void addFreeItem(Games item){
        StoreProducts.add(item);
    }

	}