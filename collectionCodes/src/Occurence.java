import java.util.HashMap;
import java.util.Map;

public class Occurence {
    public static void main(String[] args) {
        String[] arr={"ronaldo","messi","ronaldo","messi","neymar","ronaldo"};
        Map<String,Integer> map=new HashMap<>();
        for (String element:arr){
            if (map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }else {
                map.put(element,1);
            }
        }
        for (String val:map.keySet()){
            System.out.println(val+" count is "+map.get(val));
        }
    }
}