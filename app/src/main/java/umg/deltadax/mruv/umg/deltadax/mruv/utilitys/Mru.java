package umg.deltadax.mruv.umg.deltadax.mruv.utilitys;

/**
 * Created by Jos�Pablo on 26/05/15.
 */
public class Mru {

    // Propiedades de la clase-----
    // ----------------------------

    private double Distance;
    private double Velocity;
    private double Time;

    // Constructor-----
    // ----------------
    public Mru() {
        this.Distance = 0.0;
        this.Velocity = 0.0;
        this.Time = 0.0;
    }

    public Mru(double Distance, double Velocity, int Time) {
        this.Distance = Distance;
        this.Velocity = Velocity;
        this.Time = Time;
    }

    public void Init() {
        this.Distance = 0;
        this.Velocity = 0;
        this.Time = 0;
    }

    // Accesores de Propiedades-----
    // -----------------------------
    public double getDistance() {
        return this.Distance;
    }

    public void setDistance(double Distance) {
        this.Distance = Distance;
    }

    public double getVelocity() {
        return this.Velocity;
    }

    public void setVelocity(double Velocity) {
        this.Velocity = Velocity;
    }

    public double getTime() {
        return this.Time;
    }

    public void setTime(double Time) {
        this.Time = Time;
    }

    // Funciones propias de Soluci�n-----
    // ----------------------------------
    public double fnCalcTime() {
        this.Time = this.Distance / this.Velocity;
        return this.getTime();
    }

    public double fnCalcDistance() {
        this.Distance = this.Time * this.Velocity;
        return this.getDistance();
    }

    public double fnCalcVelocity() {
        this.Velocity = this.Distance / this.Time;
        return this.getVelocity();
    }

}
