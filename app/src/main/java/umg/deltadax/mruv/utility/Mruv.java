package umg.deltadax.mruv.utility;

import java.util.ArrayList;

/*
 * ############################################################################
 *   Autor: JoshBucaro
 *   Fecha Creación: 2015/04/25
 *
 *   Funcionalidad: Propiedades y Funciones básicas para desarrollar MRUV
 *
 *   Historial de Modificación:
 *   AUTHOR	    FECHA		    RAZON
 *  JoshBucaro  2015-06-05      Se agrega la propiedad de uso en log
 *
 *
 * ############################################################################
 */
public class Mruv {

    // Propiedades-----
    // ----------------

    private double IniVelocity;
    private double FinVelocity;
    private double Distance;
    private double Time;
    private double Acceleration;
    private ArrayList<String> Log = new ArrayList<String>();

    // Constructores-----
    // ------------------
    public Mruv() {
        this.IniVelocity = 0.0;
        this.FinVelocity = 0.0;
        this.Distance = 0.0;
        this.Time = 0.0;
        this.Acceleration = 0.0;
    }

    public void Init() {
        this.FinVelocity = 0;
        this.IniVelocity = 0;
        this.Distance = 0;
        this.Time = 0;
        this.Acceleration = 0;
    }

    // Accesores-----
    // --------------
    public double getIniVelocity() {
        return this.IniVelocity;
    }

    public void setIniVelocity(double IniVelocity) {
        this.IniVelocity = IniVelocity;
    }

    public double getFinVelocity() {
        return this.FinVelocity;
    }

    public void setFinVelocity(double FinVelocity) {
        this.FinVelocity = FinVelocity;
    }

    public double getDistance() {
        return this.Distance;
    }

    public void setDistance(double Distance) {
        this.Distance = Distance;
    }

    public double getTime() {
        return this.Time;
    }

    public void setTime(double Time) {
        this.Time = Time;
    }

    public double getAcceleration() {
        return this.Acceleration;
    }

    public void setAcceleration(double Acceleration) {
        this.Acceleration = Acceleration;
    }
    public ArrayList<String> getLog(){
        return this.Log;
    }

    // Funciones para resolver los sitemas-----
    // ----------------------------------------
    public double fnCalcIniVelocity1() {
        this.IniVelocity = this.FinVelocity - (this.Acceleration * this.Time);
        this.Log.add("Vo = Vf - (a * t)");
        return this.IniVelocity;
    }
    public double fnCalcIniVelocity2() {
        this.IniVelocity = Math.sqrt(Math.pow(this.FinVelocity, 2) - (2 * this.Acceleration * this.Distance));
        this.Log.add("Vo = raiz((Vf^2) - (2 * a * s))");
        return this.IniVelocity;
    }
    public double fnCalcIniVelocity3() {
        this.IniVelocity = this.Distance - ((1/2) * (this.Distance * Math.pow(this.Time, 2)));
        this.Log.add("Vo = (s - ((1 / 2) * a * (a^2))) / t");
        return this.IniVelocity;
    }
    public double fnCalcIniVelocity4 () {
        this.IniVelocity = ((2 * this.Distance) / this.Time) - this.FinVelocity;
        this.Log.add("Vo = ((2 * s) / t) - Vf");
        return this.IniVelocity;
    }


    public double fnCalcFinVelocity1() {
        this.FinVelocity = this.IniVelocity + (this.Acceleration * this.Time);
        this.Log.add("Vf = Vo + (a * t)");
        return this.FinVelocity;
    }
    public double fnCalcFinVelocity2() {
        this.FinVelocity = Math.sqrt(Math.pow(this.IniVelocity, 2) + (2 * this.Acceleration * this.Distance));
        this.Log.add("Vf = raiz((Vo^2) + (2 * g * s))");
        return this.FinVelocity;
    }
    public double fnCalcFinVelocity3() {
        this.FinVelocity = ((2 * this.Distance) / this.Time) - this.IniVelocity;
        this.Log.add("Vf = ((2 * s) / t) - Vo");
        return this.FinVelocity;
    }


    public double fnCalcTime1() {
        this.Time = (this.FinVelocity - this.IniVelocity) / this.Acceleration;
        this.Log.add("t = (Vf - Vo) / a");
        return this.Time;
    }
    public double fnCalcTime2() {
        return this.Time;
    }
    public double fnCalcTime3() {
        this.Time = (2 * this.Distance) / (this.FinVelocity + this.IniVelocity);
        this.Log.add("t = (2 * s) / (Vf + Vo)");
        return this.Time;
    }


    public double fnCalcAcceleration1() {
        this.Acceleration = (this.FinVelocity - this.IniVelocity) / this.Time;
        this.Log.add("a = (Vf - Vo) / t");
        return this.Acceleration;
    }
    public double fnCalcAcceleration2() {
        this.Acceleration = (Math.pow(this.FinVelocity, 2) - Math.pow(this.IniVelocity, 2)) / (2 * this.Distance);
        this.Log.add("a = (((Vf^2)) - ((Vo^2))) / (2 * s)");
        return this.Acceleration;
    }
    public double fnCalcAcceleration3() {
        this.Acceleration = Distance - (this.IniVelocity * this.Time) / ((1 / 2) * Math.pow(this.Time, 2));
        this.Log.add("g = (h - (Vo * t)) / ((1/2) * (t^2))");
        return this.Acceleration;
    }


    public double fnCalcDistance1() {
        this.Distance = (Math.pow(this.FinVelocity, 2) - Math.pow(this.IniVelocity, 2)) / (2 * this.Acceleration);
        this.Log.add("s = (((Vf^2)) - ((Vo^2))) / (2 * a)");
        return this.Distance;
    }
    public double fnCalcDistance2() {
        this.Distance = (this.IniVelocity * this.Time) + ((1 / 2) * this.Acceleration * (Math.pow(this.Time, 2)));
        this.Log.add("s = (Vo * t) + ((1/2) * (a * ((t^2))))");
        return this.Distance;
    }
    public double fnCalcDistance3() {
        this.Distance = ((this.FinVelocity - this.IniVelocity) / 2) * this.Time;
        this.Log.add("s = ((Vf - Vo) / 2) * t");
        return this.Distance;
    }
}
