import java.util.HashMap;
import java.util.Set;

public class Hashmatique{
    public void getSong(){
        HashMap<String, String> songMap = new HashMap<String, String>();
        songMap.put("Beer and nuggets", "I dream of eating chcken nuggets all day. And drinking beer all night");
        songMap.put("Carl's bad", "Chase is pretty good, but oh damn Carl's bad.");
        songMap.put("Oh Mike", "Oh Mike, Why did you have to leave us so soon.");
        songMap.put("New Mexico", "Tell me Jesus, Why am i standing here in the desert of New Mexico. I should've just stayed home that night.");

        String carl = songMap.get("Carl's bad");
        System.out.println(carl);

        Set<String> keys = songMap.keySet();
        for (String key : keys){
            System.out.println(key + ": " + songMap.get(key) + ".");
        }
    }
}