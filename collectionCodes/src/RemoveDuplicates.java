import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str="portugalportugal";
        List<Character>list=new ArrayList<>();
        for (char character:str.toCharArray()){
            if (!list.contains(character)){
                list.add(character);
                System.out.print(character);
            }
        }
    }
}