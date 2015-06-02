/**
 * Created by Josh on 31/05/2015.
 */
import Interactions.InteractFreeFall;
import java.util.Scanner;
import java.lang.System.*;

public class HowTo {
    public static void main(String args[]){
        InteractFreeFall InteractFreeFallObj = new InteractFreeFall();
        Scanner sc = new Scanner(System.in);

        InteractFreeFallObj.iniFlags();
        System.out.print("Fin Velocity: ");
        InteractFreeFallObj.setFinVelocity(sc.nextDouble());

        System.out.print("Ini Velocity: ");
        InteractFreeFallObj.setIniVelocity(sc.nextDouble());

        System.out.print("Gravity: ");
        InteractFreeFallObj.setGravity(sc.nextDouble());


        InteractFreeFallObj.fnSolveSystem();
        System.out.println("Altura: " + InteractFreeFallObj.getHeight());
        System.out.println("Tiempo: " + InteractFreeFallObj.getTime());
        //System.out.print(InteractFreeFallObj.getHeight());
        sc.next();
    }


}
