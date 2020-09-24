import java.util.*;
import java.io.*;

public class RentItemClass {
	
	private BufferedReader r;
	private BufferedWriter w;
	private String type = null;
	private String subType = null;
	private String renter = null;
	private String date = null;
	private String title = null;
	private String number = null;
	
	public void loadRentFile(String path) {
		r= null;
		File f = null;
		String line;
		try{
			f = new File(path);
		}
		catch(Exception x) {
			System.err.println("Error 404: File not Found!");
		}
		try{
			r = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		}
		catch(Exception x){
			System.err.println("Error opening file");
		}
		try{
			line = r.readLine();
			try{
				if(line.trim().toUpperCase().trim().equals("RENTAL_LIST")){
								line = r.readLine();
								line = line.replaceAll("\t", "");
								if(line.trim().equals("{")){
					while(line != null){
										line = r.readLine();
										line = line.replaceAll("\t", "");
										if(line.trim().equals("RENTAL")){
												line = r.readLine();
												line = line.replaceAll("\t", "");
												if(line.trim().equals("{")){
														line = r.readLine();
														line = line.replaceAll("\t", "");
														while(!line.trim().equals("}")){
																if(line.toUpperCase().trim().startsWith("ITEM_TYPE ")){
																		type = line.toUpperCase().trim().substring(10);
																}
																else if(line.toUpperCase().trim().startsWith("SUBTYPE ")){
																		subType = line.toUpperCase().trim().substring(8);
																}
																else if(line.toUpperCase().trim().startsWith("NAME ")){
																		renter = line.toUpperCase().trim().substring(5);
																}
																else if(line.toUpperCase().trim().startsWith("DATE ")){
																		date = line.toUpperCase().trim().substring(5);
																}
																else if(line.toUpperCase().trim().startsWith("TITLE ")){
																		title = line.toUpperCase().trim().substring(6);
																}
																else if(line.toUpperCase().trim().startsWith("NUMBER ")){
																		number = line.toUpperCase().trim().substring(7);
																}
																line = r.readLine();
														}
												}
										}
										else if(line.trim().equals("}"))
											break;
										if(type.equals("GAMES")){
												Games item = FreeClass.findItemGames(title);
												Rent r = new Rent();
												r.setName(renter);
												r.getItem(item);
												r.setDate(date);
												r.setNumber(number);
												RentedClass.addNewRent(r);
										}
										else if(type.equals("MOVIES")){
											if(subType.equals("DVD")){
												DVD item = FreeClass.findItemDVD(title);
												Rent r = new Rent();
												r.setName(renter);
												r.getItem(item);
												r.setDate(date);
												r.setNumber(number);
												RentedClass.addNewRent(r);
											}
											else {
												BlueRay item = FreeClass.findItemBlueRay(title);
												Rent r = new Rent();
												r.setName(renter);
												r.getItem(item);
												r.setDate(date);
												r.setNumber(number);
												RentedClass.addNewRent(r);
											}
										}
										type = null;
										subType = null;
										renter = null;
										date = null;
										title = null;
										number = null;
									}
								}
                        }
					}
					catch(Exception  e){
					}
		}
		catch(IOException x) {
			System.err.println("Error during the process");
		}
	}
        public void updateRent(String path){
            r= null;
            File f = null;
            try{
                    f = new File(path);
            }
            catch(Exception x) {
                    System.err.println("Error 404: File not Found!");
            }
            try{
                    w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
            }
            catch(Exception x){
                    System.err.println("Error opening file");
            }
            try{
                w.write("RENTAL_LIST");
                w.newLine();
                w.write("{");
                w.newLine();
                for(int i=0;i<RentedClass.getSize();i++){
                    Rent r = RentedClass.getRent(i);
                    w.write("RENTAL");
                    w.newLine();
                    w.write("{");
                    w.newLine();
                    if(r.getItemName().toUpperCase().equals("HOME") || r.getItemName().toUpperCase().equals("THE AVENGERS")){
                        w.write("ITEM_TYPE MOVIE");
                        w.newLine();
                        w.write("SUB_TYPE DVD");
                        w.newLine();
                    }
                    else if(r.getItemName().toUpperCase().equals("WILD") || r.getItemName().toUpperCase().equals("THE INCREDIBLE HULK")){
                        w.write("ITEM_TYPE MOVIE");
                        w.newLine();
                        w.write("SUB_TYPE BLUERAY");
                        w.newLine();
                    }
                    else{
                         w.write("ITEM_TYPE GAME");
                         w.newLine();
                    }
                    w.write("NAME " + r.getName());
                    w.newLine();
                    w.write("DATE " + r.getDate());
                    w.newLine();
                    w.write("NUMBER " + r.getNumber());
                    w.newLine();
                    w.write("TITLE " + r.getItemName());
                    w.newLine();
                    w.write("}");
                    w.newLine();
                }
                w.write("}");
                w.newLine();
                w.close();
            }
            catch(IOException x) {
                System.err.println("Error during the process");
            }
        }
}