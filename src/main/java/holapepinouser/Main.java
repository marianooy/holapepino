package holapepinouser;
import java.util.Scanner;

class BuscadorMaximo{
    public void determinarMaximo()  {
        Scanner entrada = new Scanner( System.in );
        System.out.print( "Escriba tres valores de punto ﬂotante, separados por espacios: " );
        double numero1 = entrada.nextDouble();
        double numero2 = entrada.nextDouble();
        double numero3 = entrada.nextDouble();
        double resultado = maximo( numero1, numero2, numero3 );
        System.out.println( "El maximo es: " + resultado );
    }
        public double maximo( double x, double y, double z ) {
        /*double valorMaximo = x;
        if ( y > valorMaximo ) valorMaximo = y;
        if ( z > valorMaximo )  valorMaximo = z;
        return valorMaximo;*/
        return Math.max(x, Math.max(y, z)); //simplificado
    }
}

public class Main {
    public static void main(String[] args) {
         BuscadorMaximo buscador = new BuscadorMaximo();
         buscador.determinarMaximo();
    }
}
