
import java.io.*;
import java.util.*;
public class mainApp
{
	private static int i=123;
	
	public static void main(String args[] )
	{
		
		FreeClass Product = new FreeClass();
		Product.loadFile("ItemList.txt");
        Scanner in = new Scanner( System.in );
        RentItemClass t = new RentItemClass();
        t.loadRentFile("myRents.txt");
		int rentedItems=0;
		boolean done=false;
		boolean done2;
		int answer;
		while( ! done) {
			System.out.println("Press 0 for DVD");
			System.out.println("Press 1 for Blueray");
			System.out.println("Press 2 for Games");
			System.out.println("Press 3 for the Rented Items");
			System.out.println("Press 9 to Leave!");
			System.out.print("Type the correct number here: ");
			try{
				answer = Integer.parseInt(in.nextLine());
			}
			catch(Exception x)
			{
				answer = 4;
			}
			System.out.println();
			
			if(answer == 0){
				FreeClass.displayItems("DVD");
				done2=false;
				
				
				while(!done2){
					System.out.println();
					System.out.println("Give me the title of the Dvd :");
					String titleOfDvd = in.nextLine();
					DVD dvd = FreeClass.findItemDVD(titleOfDvd);
					if(dvd != null)
					{
						System.out.println(dvd.toString());
						System.out.print("Press 0 to rent it or press 4 for the Main Menu:");
						answer = Integer.parseInt(in.nextLine());
						if(answer == 0)
						{   
							done2 = true;
							if(dvd.checker()){
								Rent rented= new Rent();
								myRent(rented);
								rented.getItem(dvd);
								RentedClass.addNewRent(rented);
								dvd.increaseRentedItem();
								System.out.println("Your rental was successful!");
                                t.updateRent("myRents.txt");
							}else{
								System.out.println("No available copies!" ) ;
							}
						}else if(answer==4)
						{
							done2=true;
						}
					}  
				}
			}
		
			if(answer==1){
				FreeClass.displayItems("BlueRay");
				boolean done3=false;
				
			
				while(! done3){
					System.out.println();
					System.out.println("Give me the title of the BlueRay :");
					String titleOfBlueRay = in.nextLine();
					BlueRay blueray = FreeClass.findItemBlueRay(titleOfBlueRay);
                                        if(blueray != null)
                                        {
                                            System.out.println(blueray.toString());
                                            System.out.print("Press 0 to rent it or press 4 for the Main Menu:");
                                            answer = Integer.parseInt(in.nextLine());
                                            if(answer == 0)
                                            {
                                                done3=true;
                                                if(blueray.checker()){
                                                    Rent rented= new Rent();
                                                    myRent(rented);
                                                    rented.getItem(blueray);
                                                    RentedClass.addNewRent(rented);
                                                    blueray.increaseRentedItem();
                                                    System.out.println("Your rental was successful!");
                                                    t.updateRent("myRents.txt");
                                                    
                                                }else{
                                                    System.out.println("No available copies!" );
                                                }
                                            }else if(answer==4)
                                            {
                                                done3=true;
                                            }
                                        }
				}
			}
			if(answer==2){
				 FreeClass.displayItems("Games");
					boolean done4=false;
					while(! done4){
						System.out.println();
                                                System.out.println("Give me the title of the Game :");
                                                String titleOfGame = in.nextLine();
                                                Games game = FreeClass.findItemGames(titleOfGame);
                                                if(game != null)
                                                {
                                                    System.out.println(game.toString());
                                                    System.out.print("Press 0 to rent it or press 4 for the Main Menu:");
                                                    answer = Integer.parseInt(in.nextLine());
                                                    if(answer == 0)
                                                    {
                                                        done4=true;
                                                        if(game.checker()){
                                                            Rent rented= new Rent();
                                                            myRent(rented);
                                                            rented.getItem(game);
                                                            RentedClass.addNewRent(rented);
                                                            game.increaseRentedItem();
                                                            System.out.println("Your rental was successful!");
                                                            t.updateRent("myRents.txt");

                                                        }else{
                                                            System.out.println("No available copies!" );
                                                        }
                                                    }else if(answer==4)
                                                    {
                                                        done4=true;
                                                    }
                                                }
					}
			}
			if(answer==3){
					RentedClass.displayAllRents();
					boolean notDone = true;	
					while(notDone){
						System.out.print("Choose a Name or press 4 to return : ");
						String name = in.nextLine();
						System.out.println();
                                                if(name.equals("4"))
                                                    notDone = false;
                                                Rent item = RentedClass.findItem(name);
                                                if(item != null){
                                                    notDone = false;
                                                    System.out.println(item.toString());
                                                    System.out.print("Press 1 to return the rented item : ");
                                                    answer = Integer.parseInt(in.nextLine());
                                                    System.out.println();
                                                    if(answer == 1){
                                                            System.out.print("Type the date(d/m/yyyy): ");
                                                            String date = in.nextLine();
                                                            System.out.println(); 
                                                            System.out.println("The final cost is :  " +item.calculateCost(date) +  " Euros ");
                                                            RentedClass.removeRent(item);
                                                            t.updateRent("myRents.txt");                                                            
                                                            break;
                                                    }
                                                    
                                                }   
                                                
					}
			
			}
			if(answer == 9){
			    System.out.println("Thanks for coming!!!");
				break;
			}
			if(answer > 4){
				System.out.println("Type only one of the Upper Numbers!\n");
			}
			
		}
        }

	private static void myRent(Rent rented)
	{
		Scanner in = new Scanner(System.in);
		System.out.println();
		System.out.print("Type your Name: ");
		rented.setName(in.nextLine());
		System.out.print("\nType your Phone Number: ");
		rented.setNumber(in.nextLine());
		System.out.print("Type the date(d/m/yyyy): ");
		rented.setDate(in.nextLine());
		i++;
		rented.setSerialNumber(i);
	}
	
	
}
									
			

		
		
		
		
	
	
	
	

			