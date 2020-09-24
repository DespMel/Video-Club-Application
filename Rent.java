import java.util.*;

public class Rent
{
    private String name;
    private int serialNumber;
    private String number;
    private String date;
    private int days;
    private Type myItem;
    private String type;
    private static final int weekCost=4;
    private static final int dayCost=2;


    public void setSerialNumber(int i){
        serialNumber=i;   
    }


    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;	
    }

    public void getItem(DVD myItem){
        this.myItem=myItem;
        type="DVD";
    }
    
    public void getItem(BlueRay myItem){
        this.myItem=myItem;
        type="BlueRay";
    }
    
    public void getItem(Games myItem){
        this.myItem=myItem;
        type="Games";
    }
    
    public String getItemName() {
        return myItem.getTitle();
    } 

    public int getDays(){
        return days;
    }

    public void setNumber(String number){
        this.number=number;
    }

    public String getNumber(){
        return number;
    }

    public void setDate(String date) {
        this.date=date;
    }

    public String getDate(){
        return date;
    }

    public int calculateCost(String Date){
        int weekTemp;
        int duration = calculateDays(Date);
        if(duration <= 7){
            weekTemp = weekCost;
        }
        else
        {
            weekTemp = (duration % 7 != 0) ? ((duration / 7) * weekCost + weekCost) : 
                (duration / 7)* weekCost;
        }
        int dayTemp = duration * dayCost;

        if(type == "Games"){
                return weekTemp;
        }
        else if(type == "BlueRay"){
                return dayTemp;
        }
        else{
                DVD dvd = (DVD)myItem;
                if(dvd.getRelease()){
                        return dayTemp;
                }
                else{
                        return weekTemp;
                }
        }
    }

    private int calculateDays(String Date){
             StringTokenizer string= new StringTokenizer(getDate(),"/");
             int days=Integer.parseInt(string.nextToken());
             int month=Integer.parseInt(string.nextToken());
             int year=Integer.parseInt(string.nextToken());
             StringTokenizer string1 = new StringTokenizer(Date, "/");
             int returnDays=Integer.parseInt(string1.nextToken());
             int returnMonth= Integer.parseInt(string1.nextToken());
             int returnYear= Integer.parseInt(string1.nextToken());

            int difYear=returnYear-year;
            int totalDays;
            if(difYear == 0){
                    if((returnMonth-month) == 0){
                            totalDays = returnDays-days;
                    }
                    else{
                            int temp = 0;
                            int temp1 = month + 1;
                            for(int i=(returnMonth-month-1); i>0; i--){
                                    temp += calculateDaysOfMonth(temp1, year);
                                    temp1++;
                            }	
                            totalDays = (calculateDaysOfMonth(month, year)-days)+ temp +returnDays;
                    }
            }
            else{
                    int monthTemp = 12-month;
                    int count = 0;
                    int tempLastYear = calculateDaysOfMonth(month, year) - days;
                    int temp = month + 1;
                    for(int i=monthTemp; i>0; i--){
                            tempLastYear += calculateDaysOfMonth(temp, year);
                            temp++;
                    }
                    int tempThisYear = returnDays;
                    for(int i=1; i<returnMonth; i++)
                            tempThisYear += calculateDaysOfMonth(i, returnYear);
                    totalDays = tempLastYear + tempThisYear;	
            }
            return totalDays;
    } 

    private int calculateDaysOfMonth(int month, int year){
            boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
             if (month==2 && !isLeapYear){
                    return 28;
             }
             else if(month==2 && isLeapYear){
                    return 29;
             }
             else if((month%2==1 && month <= 7)||(month%2==0 && month >=8)){
                    return 31;
            }
            else{
                    return 30;
            }	
    }

    public String toString()
    {
            String myString = "\nName : " + getName() + "\nPhone Number : " + getNumber() +
                    "\nRent Date : " + getDate() + "\nRented Item : "+ myItem.getTitle();
            return myString;
    }
}

