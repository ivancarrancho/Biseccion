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
      System.out.println("Ingrese el número de iteraciones\n ");
      g = reader.nextLine();

      System.out.println("Ingrese el número 1\n ");
      c = reader.nextLine();

      System.out.println("Ingrese el número 2\n ");
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
      System.out.println("******Intervalo : [" + a + ", " + b + "]");
      System.out.println("******Error : " + error);
      System.out.println("******Iteraciones : " + iteraciones);
      System.out.println("------------------------------------------------ \n");

      double c = 0;
      double fa = 0;
      double fb = 0;
      double fc = 0;
      int iteracion = 1;

      do {
         c = (a + b) / 2;

         System.out.println("Iteracion (" + iteracion + ") : " + c);
         fa = funcion(a);
         fb = funcion(b);
         fc = funcion(c);

         if (fc * fa < 0) {
            b = c;
            fa = funcion(a);
            fb = funcion(b);
            c = (a + b) / 2;
            fc = funcion(c);
         } else {
            a = c;
            fa = funcion(a);
            fb = funcion(b);
            c = (a + b) / 2;
            fc = funcion(c);
         }
         iteracion++;

      } while (iteracion <= iteraciones && Math.abs(fc) >= error);

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