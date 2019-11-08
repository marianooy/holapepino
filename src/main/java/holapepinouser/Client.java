package holapepinouser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;


public class Client
{
    private static int clientId;
    private static String clientName;
    private static double clientProfit;

    private Client(int id, String name, double profit){clientId = id; clientName = name; clientProfit = profit;}

    public static void main(String[] args){
       final String prefix = "MR. ";
       System.out.println(process("HOLA MundO", prefix::concat));
       System.out.println(process("HOLA MundO", String::toLowerCase));
       System.out.println(process2("HOLA MundO", 2, String::substring));

       String[] names = {"Mr marino", "Ms maria", "Dr mariano"};
        Arrays.sort(names, Comparator.comparing(Client::firstName).reversed().thenComparing(Client::title)
        );
        System.out.println(Arrays.toString(names));
        System.out.println(Client.machResuls());
        Client.whenIncrementProfitForEachClient_thenApplyNewBonus();
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
    public static String machResuls(){
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        boolean allEven = intList.stream().allMatch(i -> i % 2 ==0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2==0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 ==0);
        String result = String.valueOf(allEven) + " " + String.valueOf(oneEven) + " " + String.valueOf(noneMultipleOfThree);

        return result;
    }
    private static ArrayList<Client> clientes()
    {
     ArrayList<Client> myClientList = new ArrayList<Client>();
     myClientList.add(new Client(1, "Jose Jose", 10000));
     myClientList.add(new Client(2, "Juan Gabriel", 20000));
     myClientList.add(new Client(3, "Armando Manzanero", 30000));

      return  myClientList;
    }

    public static void whenIncrementProfitForEachClient_thenApplyNewBonus(){
        Client.clientes().stream().forEach(e -> e.bonusIncrement(20.0));
        //Client.clientes().clear();
    }

    private void bonusIncrement(double percentage) {
            clientProfit = clientProfit + (clientProfit/percentage);
    }
}