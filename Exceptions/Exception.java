import java.util.*;

public class Exception{
    public void testMeDaddy(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        try{
            for (int i=0; i<myList.size(); i++){
            Integer castedValue = (Integer) myList.get(i);
            }
        } 
        catch(ClassCastException e){
                System.out.println("AHHHHHHHHHHHHHH");
        }
    }
}