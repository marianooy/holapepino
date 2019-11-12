package holapepinouser;

import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Client
{
    private static int clientId;
    private static String clientName;
    private static double profit;

    private Client(int id, String name, double profit){clientId = id; clientName = name; this.profit = profit ;}

    public static void main(String[] args){
       final String prefix = "MR. ";
       System.out.println(process("HOLA MundO", prefix::concat));
       System.out.println(process("HOLA MundO", String::toLowerCase));
       System.out.println(process2("HOLA MundO", 2, String::substring));

       String[] names = {"Mr marino", "Ms maria", "Dr mariano"};
        Arrays.sort(names, Comparator.comparing(Client::firstName).reversed().thenComparing(Client::title)
        );
        System.out.println(Arrays.toString(names));
        System.out.println(Client.matchResults());
    }

    private static String process(String str, Function<String, String> processor){
        return processor.apply(str);
    }
    private static String process2(String str, int substring, BiFunction<String, Integer, String> processor){
        return processor.apply(str, substring);
    }
    public static String firstName(String name){
        return name.split("")[1];
    }
    public static String title(String name){
        return name.split("")[0];
    }
    public static String matchResults(){
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        boolean allEven = intList.stream().allMatch(i -> i % 2 ==0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2==0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 ==0);
        String result = String.valueOf(allEven) + " " + String.valueOf(oneEven) + " " + String.valueOf(noneMultipleOfThree);

        return result;
    }
}