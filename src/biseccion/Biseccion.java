package biseccion;
import java.util.Scanner;
 
/**
 *
* @author ivan
*/

public class Biseccion {
   double a;
   double b;
   int iteraciones;
   double error;

   public static void main(String[] args) {
      Scanner reader = new Scanner(System.in);
      String c;
      String t;
      String g;
      System.out.println("Ingrese el número de iteraciones ");
      g = reader.nextLine();

      System.out.println("Ingrese el número 1 ");
      c = reader.nextLine();

      System.out.println("Ingrese el número 2 ");
      t = reader.nextLine();

      Biseccion biseccion = new Biseccion();
      biseccion.setIntervalo(Integer.parseInt(c), Integer.parseInt(t));
      biseccion.setIteraciones(Integer.parseInt(g));
      biseccion.setError(10e-4);
      biseccion.solucion();
   }

   public double funcion(double x) {
      double resultado = Math.pow((Math.E), x) - (3 * x);
      return resultado;
   }

   public void solucion() {
      System.out.println("****** Valor 1: " +a);
      System.out.println("****** Valor 2: " +b);
      System.out.println("******Error : " + error);
      System.out.println("\n");
      System.out.println("******Iteraciones : " + iteraciones);
      System.out.println("------------------------------------------------ \n");

      double c = 0;
      double funcion_a = 0;
      double funcion_b = 0;
      double funcion_c = 0;
      int iteracion = 1;

      do {
         c = (a + b) / 2;

         System.out.println("Iteracion (" + iteracion + ") : " + c);
         funcion_a = funcion(a);
         funcion_b = funcion(b);
         funcion_c = funcion(c);

         if (funcion_c * funcion_a < 0) {
            b = c;
            funcion_a = funcion(a);
            funcion_b = funcion(b);
            c = (a + b) / 2;
            funcion_c = funcion(c);
         } else {
            a = c;
            funcion_a = funcion(a);
            funcion_b = funcion(b);
            c = (a + b) / 2;
            funcion_c = funcion(c);
         }
         iteracion++;

      } while (iteracion <= iteraciones && Math.abs(funcion_c) >= error);

   }

   public void setIntervalo(double a, double b) {
      this.a = a;
      this.b = b;
   }

   public void setIteraciones(int iteraciones) {
      this.iteraciones = iteraciones;
   }

   public void setError(double error) {
      this.error = error;
   }

}
