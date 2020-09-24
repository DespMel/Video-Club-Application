import java.util.ArrayList;

public class RentedClass {
    private static ArrayList<Rent> rentedCollection = new ArrayList<Rent>();
    
    public static void displayAllRents(){
        for(Rent r: rentedCollection){
            System.out.println(r.getName());
        }
    }
    
    public static Rent findItem(String name){
        for(Rent r: rentedCollection){
            if(r.getName().equalsIgnoreCase(name))
                return r;
        }
        return null;
    }
    
    public static void addNewRent(Rent r){
        rentedCollection.add(r);
    }
    
    public static void removeRent(Rent r){
        rentedCollection.remove(r);
    }
    
    public static int getSize() {
        return rentedCollection.size();
    }
    
    public static Rent getRent(int i){ 
        return rentedCollection.get(i); 
    }
}
