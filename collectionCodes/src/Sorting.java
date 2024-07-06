import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        Integer []arr={10,9,2,1,0};
        List<Integer>list=new ArrayList<>(Arrays.asList(arr));
        Collections.sort(list);
        System.out.println(list);
    }
}