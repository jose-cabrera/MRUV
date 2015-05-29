package umg.deltadax.mruv.utility;

/*
 * ############################################################################
 *   Autor: JoshBucaro
 *   Fecha Creación: 2015/04/25
 *
 *   Funcionalidad: Propiedades y Funciones básicas para desarrollar MRUV
 *
 *   Historial de Modificación:
 *   AUTHOR	 FECHA		  RAZON
 *
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

    // Funciones para resolver los sitemas-----
    // ----------------------------------------
    public double fnCalcIniVelocity1() {
        this.IniVelocity = this.FinVelocity - (this.Acceleration * this.Time);
        return this.IniVelocity;
    }

    public double fnCalcIniVelocity2() {
        this.IniVelocity = Math.sqrt(Math.pow(this.FinVelocity, 2) - (2 * this.Acceleration * this.Distance));
        return this.IniVelocity;
    }

    public double fnCalcIniVelocity3() {
        this.IniVelocity = (this.Distance - ((1 / 2) * this.Acceleration * Math.pow(this.Acceleration, 2))) / this.Time;
        return this.IniVelocity;
    }

    public double fnCalcFinVelocity1() {
        this.FinVelocity = this.IniVelocity + (this.Acceleration * this.Time);
        return this.FinVelocity;
    }

    public double fnCalcFinVelocity2() {
        this.FinVelocity = Math.sqrt(Math.pow(this.IniVelocity, 2) + (2 * this.Acceleration * this.Distance));
        return this.FinVelocity;
    }

    public double fnCalcTime1() {
        this.Time = (this.FinVelocity - this.IniVelocity) / this.Acceleration;
        return this.Time;
    }

    public double fnCalcTime2() {

        return this.Time;
    }

    public double fnCalcAcceleration1() {
        this.Acceleration = (this.FinVelocity - this.IniVelocity) / this.Time;
        return this.Acceleration;
    }

    public double fnCalcAcceleration2() {
        this.Acceleration = (Math.pow(this.FinVelocity, 2) - Math.pow(this.IniVelocity, 2)) / (2 * this.Distance);
        return this.Acceleration;
    }

    public double fnCalcAcceleration3() {
        this.Acceleration = Distance - (this.IniVelocity * this.Time) / ((1 / 2) * Math.pow(this.Time, 2));
        return this.Acceleration;
    }

    public double fnCalcDistance1() {
        this.Distance = (Math.pow(this.FinVelocity, 2) - Math.pow(this.IniVelocity, 2)) / (2 * this.Acceleration);
        return this.Distance;
    }

    public double fnCalcDistance2() {
        this.Distance = (this.IniVelocity * this.Time) + ((1 / 2) * this.Acceleration * (Math.pow(this.Time, 2)));
        return this.Distance;
    }

}
