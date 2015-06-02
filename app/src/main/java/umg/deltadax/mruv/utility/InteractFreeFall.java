
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
public class InteractFreeFall {

    // Used System-----
    // ----------------
    private FreeFall FreeFallObj = new FreeFall();

    // Properties-----
    // ---------------
    private double Gravity;
    private double Time;
    private double Height;
    private double FinVelocity;
    private double IniVelocity;
    // Flags to Know when a value is set-----
    // --------------------------------------
    private boolean FlgGravity;
    private boolean FlgTime;
    private boolean FlgHeight;
    private boolean FlgFinVelocity;
    private boolean FlgIniVelocity;

    // constructor-----
    // ----------------
    public InteractFreeFall() {
        this.Gravity = 0;
        this.Time = 0;
        this.Height = 0;
        this.FinVelocity = 0;
        this.IniVelocity = 0;
    }

    // Setters-----
    // ------------
    public void setGravity(double Gravity) {
        this.Gravity = Gravity;
        this.FlgGravity = true;
    }

    public void setTime(double Time) {
        this.Time = Time;
        this.FlgTime = true;
    }

    public void setHeight(double Height) {
        this.Height = Height;
        this.FlgHeight = true;
    }

    public void setFinVelocity(double FinVelocity) {
        this.FinVelocity = FinVelocity;
        this.FlgFinVelocity = true;
    }

    public void setIniVelocity(double IniVelocity) {
        this.IniVelocity = IniVelocity;
        this.FlgIniVelocity = true;
    }

    // Getters-----
    // ------------
    public double getGravity() {
        return this.Gravity;
    }

    public double getHeight() {
        return this.Height;
    }

    public double getTime() {
        return this.Time;
    }

    public double getFinVelocity() {
        return this.FinVelocity;
    }

    public double getIniVelocity() {
        return this.IniVelocity;
    }

    // Initializer-----
    // ----------------
    public void iniFlags() {
        this.FlgGravity = false;
        this.FlgTime = false;
        this.FlgHeight = false;
        this.FlgFinVelocity = false;
        this.FlgIniVelocity = false;
    }

    // Move values to System Solver----
    // --------------------------------
    public void MoveToSystem() {
        FreeFallObj.setGravity(Gravity);
        FreeFallObj.setTime(Time);
        FreeFallObj.setHeight(Height);
        FreeFallObj.setFinVelocity(FinVelocity);
        FreeFallObj.setIniVelocity(IniVelocity);
    }

    // Main method to solve the system, It uses an infinite loop-----
    // and only exits when ALL the system variables are solved-------
    // --------------------------------------------------------------
    public void fnSolveSystem() {
        MoveToSystem();
        while (true) {
            // Exit Sequence-----
            // ------------------
            if (this.FlgIniVelocity && this.FlgFinVelocity && this.FlgTime && this.FlgHeight && this.FlgGravity)
                break;

            // Calculate Height-----
            // ---------------------
            if (!this.FlgHeight) {
                if (this.FlgFinVelocity && this.FlgIniVelocity && this.FlgGravity)
                    this.setHeight(FreeFallObj.fnCalcHeight1());

                if (this.FlgIniVelocity && this.FlgTime && FlgGravity)
                    this.setHeight(FreeFallObj.fnCalcHeight2());

                if (this.FlgFinVelocity && this.FlgIniVelocity && this.FlgTime)
                    this.setHeight(FreeFallObj.fnCalcHeight3());
            }

            // Calculate Gravity-----
            // ----------------------
            if (!this.FlgGravity) {
                if (this.FlgFinVelocity && this.FlgIniVelocity && this.FlgTime)
                    this.setGravity(FreeFallObj.fnCalcGravity1());

                if (this.FlgFinVelocity && this.FlgIniVelocity && this.FlgTime && this.FlgHeight)
                    this.setGravity(FreeFallObj.fnCalcGravity2());

                if (this.FlgHeight && this.FlgIniVelocity && this.FlgTime)
                    this.setGravity(FreeFallObj.fnCalcGravity3());
            }

            // Calculate Time-----
            // -------------------
            if (!this.FlgTime) {
                if (this.FlgFinVelocity && this.FlgIniVelocity && this.FlgGravity)
                    this.setTime(FreeFallObj.fnCalcTime1());
                // Aqui va la mitica función
                if (this.FlgHeight && this.FlgFinVelocity && this.FlgIniVelocity)
                    this.setTime(FreeFallObj.fnCalcTime3());
            }

            // Calculate Final Velocity-----
            // -----------------------------
            if (!this.FlgFinVelocity) {
                if (this.FlgIniVelocity && this.FlgTime && this.FlgGravity)
                    this.setFinVelocity(FreeFallObj.fnCalcFinVelocity1());

                if (this.FlgIniVelocity && this.FlgGravity && this.FlgHeight)
                    this.setFinVelocity(FreeFallObj.fnCalcFinVelocity2());

                if (this.FlgHeight && this.FlgTime && this.FlgIniVelocity)
                    this.setFinVelocity(FreeFallObj.fnCalcFinVelocity3());
            }

            // Calculate Initial Velocity-----
            // -------------------------------
            if (!this.FlgIniVelocity) {
                if (this.FlgFinVelocity && this.FlgGravity && this.FlgTime)
                    this.setIniVelocity(FreeFallObj.fnCalcIniVelocity1());

                if (this.FlgFinVelocity && this.FlgGravity && this.FlgHeight)
                    this.setIniVelocity(FreeFallObj.fnCalcIniVelocity2());

                if (this.FlgHeight && this.FlgGravity && this.FlgTime)
                    this.setIniVelocity(FreeFallObj.fnCalcIniVelocity3());

                if (this.FlgHeight && this.FlgTime && this.FlgFinVelocity)
                    this.setIniVelocity(FreeFallObj.fnCalcIniVelocity4());
            }
        }
    }
}