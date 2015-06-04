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
public class ParabolicShot {

    // Properties-----
    // ---------------
    private double Gravity;
    private double MaxHeight;
    private double MaxDistance;
    private double Angle;

    private double PosX;
    private double PosY;

    private double FinVelocityX;
    private double FinVelocity;
    private double FinVelocityY;
    private double IniVelocity;
    private double IniVelocityX;
    private double IniVelocityY;
    private double TimeUp;
    private double TimeDown;
    private double TotalTime;

    // Constructors-----
    // -----------------
    public ParabolicShot() {
        this.Gravity		= 0;
        this.TimeUp 		= 0;
        this.TimeDown		= 0;
        this.TotalTime		= 0;
        this.MaxHeight		= 0;
        this.MaxDistance	= 0;
        this.Angle			= 0;
        this.PosX			= 0;
        this.PosY			= 0;
        this.FinVelocity	= 0;
        this.FinVelocityX	= 0;
        this.FinVelocityY	= 0;
        this.IniVelocity 	= 0;
        this.IniVelocityX	= 0;
        this.IniVelocityY	= 0;
    }


    // Getters-----
    // ------------
    public double getGravity(){
        return this.Gravity;
    }
    public double getTimeUp(){
        return this.TimeUp;
    }
    public double getTimeDown(){
        return this.TimeDown;
    }
    public double getTotalTime(){
        return this.TotalTime;
    }
    public double getMaxHeight(){
        return this.MaxHeight;
    }
    public double getMaxDistance(){
        return this.MaxDistance;
    }
    public double getAngle(){
        return this.Angle;
    }
    public double getPosX(){
        return this.PosX;
    }
    public double getPosY(){
        return this.PosY;
    }
    public double getFinVelocity(){
        return this.FinVelocity;
    }
    public double getFinVelocityY(){
        return this.FinVelocityY;
    }
    public double getIniVelocity(){
        return this.IniVelocity;
    }
    public double getIniVelocityX(){
        return this.IniVelocityX;
    }
    public double getIniVelocityY(){
        return this.IniVelocityY;
    }



    // SETTERS-----
    // ------------
    public void setGravity(double Gravity){
        this.Gravity = Gravity;
    }
    public void setTimeUp(double TimeUp){
        this.TimeUp = TimeUp;
    }
    public void setTimeDown(double TimeDown){
        this.TimeUp = TimeDown;
    }
    public void setTotalTime(double TotalTime){
        this.TotalTime = TotalTime;
    }
    public void setMaxHeight(double MaxHeight){
        this.MaxHeight = MaxHeight;
    }
    public void setMaxDistance(double MaxDistance){
        this.MaxDistance = MaxDistance;
    }
    public void setAngle(double Angle){
        this.Angle = Angle;
    }
    public void setPosX(double PosX){
        this.PosX = PosX;
    }
    public void setPosY(double PosY){
        this.PosY = PosY;
    }
    public void setFinVelocity(double FinVelocity){
        this.FinVelocity = FinVelocity;
    }
    public void setFinVelocityY(double FinVelocityY){
        this.FinVelocityY = FinVelocityY;
    }
    public void setIniVelocity(double IniVelocity){
        this.IniVelocity = IniVelocity;
    }
    public void setIniVelocityX(double IniVelocityX){
        this.IniVelocityX = IniVelocityX;
    }
    public void setIniVelocityY(double IniVelocityY){
        this.IniVelocityY = IniVelocityY;
    }



    // Forumulas to solve the Systems-----
    // -----------------------------------

    // Gravity
    public double fnCalcGravity1(){
        this.Gravity = ( Math.pow(this.IniVelocityY,2)/(2 * this.MaxHeight) );
        return this.Gravity;
    }
    public double fnCalcGravity2(){
        this.Gravity = (-1) * (this.IniVelocityY / this.TimeUp);
        return this.Gravity;
    }
    public double fnCalcGravity3(){
        this.Gravity = (2 * this.MaxHeight)/Math.pow(this.TimeDown,2);
        return this.Gravity;
    }
    public double fnCalcGravity4(){
        this.Gravity = (-1) * ((2 * this.IniVelocityY) / this.TotalTime);
        return this.Gravity;
    }
    public double fnCalcGravity5(){
//        this.Gravity = (-1 * this.IniVelocityX)((2 * this.IniVelocity * Math.sin(this.Angle))/this.MaxDistance);
        return this.Gravity;
    }

    public double fnCalcGravity6(){
        this.Gravity = (-1) * ((Math.pow(this.IniVelocity,2) * Math.sin(2 * this.Angle))/this.MaxDistance);
        return this.Gravity;
    }

    // Time Up
    public double fnCalcTimeUp1(){
        this.TimeUp = this.TotalTime / 2;
        return this.TimeUp;
    }
    public double fnCalcTimeUp2(){
        this.TimeUp = this.TimeDown;
        return this.TimeDown;
    }
    public double fnCalcTimeUp3(){
        this.TimeUp = (-1) * (this.IniVelocityY/ this.Gravity);
        return this.TimeUp;
    }

    // Time Down
    public double fnCalcTimeDown1(){
        this.TimeDown = this.TotalTime / 2;
        return this.TimeDown;
    }
    public double fnCalcTimeDown2(){
        this.TimeDown = this.TimeUp;
        return this.TimeDown;
    }
    public double fnCalcTimeDown3(){
        this.TimeDown = Math.sqrt((2 * this.MaxHeight) / this.Gravity);
        return this.TimeDown;
    }

    // Total Time
    public double fnCalcTotalTime1(){
        this.TotalTime = this.TimeUp * 2;
        return this.TotalTime;
    }
    public double fnCalcTotalTime2(){
        this.TotalTime = this.TimeDown * 2;
        return this.TotalTime;
    }
    public double fnCalcTotalTime3(){
        this.TotalTime = this.MaxDistance / this.IniVelocityX;
        return this.TotalTime;
    }
    public double fnCalcTotalTime4(){
        this.TotalTime = (-1) * ((2 * this.IniVelocityY) / this.Gravity);
        return this.TotalTime;
    }


    //MaxHeight;
    //MaxDistance;
    //Angle;
    //PosX;
    //PosY;
    //FinVelocity;
    //FinVelocityY;
    //IniVelocity;
    //IniVelocityX;
    //IniVelocityY;
    //TimeUp;

}



/*
VoX = Vo Cos (angulo)
VoY = Vo Sen (angulo)
MaxX = VoX * T
MaxY = (VoY^2) / (2*gravedad)

Tsub = - ( VoY/gravedad  )
tbaj = sqrt(  (2*H)/gravedad   )
Tair = - (  (2 * VoY) / gravedad  )


DX = (VoX)( -(  (2 * Vo * Sen(angulo))/Gravedad     )   )
DX = -(  (Vo^2 * sen(2 * angulo))/ gravedad     )
DX = (VoX) * Taire

*/
