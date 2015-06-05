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
    private double TimeUp;
    private double MaxHeight;
    private double MaxDistance;
    private double Angle;

    private double PosX;
    private double PosY;

    private double FinVelocity;
    private double FinVelocityY;
    private double IniVelocity;
    private double IniVelocityX;
    private double IniVelocityY;
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
        this.Gravity = (-1 * this.IniVelocityX)*((2 * this.IniVelocity * Math.sin(Math.toRadians(this.Angle)))/this.MaxDistance);
        return this.Gravity;
    }
    public double fnCalcGravity6(){
        this.Gravity = (-1) * ((Math.pow(this.IniVelocity,2) * Math.sin(2 * Math.toRadians(this.Angle)))/this.MaxDistance);
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

    // Max Height
    public double fnCalcMaxHeight1(){
        this.MaxHeight = Math.pow(this.IniVelocityY,2)/(2 * this.Gravity);
        return this.MaxHeight;
    }

    // Max Distance
    public double fnCalcMaxDistance1(){
        this.MaxDistance = this.IniVelocityX * this.TotalTime;
        return this.MaxDistance;
    }
//    public double fnCalcMaxDistance2(){
//        this.MaxDistance = this.IniVelocityX * this.TotalTime;
//        return this.MaxDistance;
//    }

    // Angle
    public double fnCalcAngle1(){
        this.Angle = Math.acos(this.IniVelocityX / this.IniVelocity);
        return this.Angle;
    }
    public double fnCalcAngle2(){
        this.Angle =Math.asin(this.IniVelocityY/this.IniVelocity);
        return this.Angle;
    }
    public double fnCalcAngle3(){
        this.Angle = Math.asin(((-1) * (this.MaxDistance/this.IniVelocityX) * this.Gravity) / (2 * this.IniVelocity) );
        return this.Angle;
    }
    public double fnCalcAngle4(){
        this.Angle = Math.sin(((-1) * this.MaxDistance) * this.Gravity)/2;
        return this.Angle;
    }

    //FinVelocity
//    public double fnCalcFinVelocity1(){
//        return 0.0;
//    }

    //FinVelocityY


    //IniVelocity
    public double fnCalcIniVelocity1(){
        this.IniVelocity = this.IniVelocityX/(Math.toDegrees(Math.toRadians(Math.cos(this.Angle))));
        return this.IniVelocity;
    }
    public double fnCalcIniVelocity2(){
        this.IniVelocity = this.IniVelocityY/(Math.toDegrees(Math.toRadians(Math.sin(this.Angle))));
        return this.IniVelocity;
    }
    public double fnCalcIniVelocity3(){
        this.IniVelocity = (((-1) * this.MaxDistance) / this.IniVelocityX) * this.Gravity/(2 * Math.sin(Math.toRadians(this.Angle)));
        return this.IniVelocity;
    }
    public double fnCalcIniVelocity4(){
        this.IniVelocity = Math.sqrt((((-1) * this.MaxDistance) * this.Gravity) / Math.sin(2 * Math.toRadians(this.Angle)));
        return this.IniVelocity;
    }

    //IniVelocityX
    public double fnCalcIniVelocityX1(){
        this.IniVelocityX = this.IniVelocity * Math.cos(Math.toRadians(this.Angle));
        return IniVelocityX;
    }
    public double fnCalcIniVelocityX2(){
        this.IniVelocityX = this.MaxDistance / this.TotalTime;
        return this.IniVelocityX;
    }
    public double fnCalcIniVelocityX3(){
        this.IniVelocityX = this.MaxDistance / ( (-1) * (2 * this.IniVelocity * Math.sin(Math.toRadians(this.Angle)) / this.Gravity));
        return this.IniVelocity;
    }

    //IniVelocityY
    public double fnCalcIniVelocityY1(){
        this.IniVelocityY = this.IniVelocity * Math.sin(Math.toRadians(this.Angle));
        return this.IniVelocityY;
    }
    public double fnCalcIniVelocityY2(){
        this.IniVelocityY = Math.sqrt(this.MaxHeight * (2 * this.Gravity));
        return this.IniVelocityY;
    }
    public double fnCalcIniVelocityY3(){
        this. IniVelocityY = (-1) * TimeUp * this.Gravity;
        return this.IniVelocityY;
    }
    public double fnCalcIniVelocityY4(){
        this.IniVelocityY = ((-1) * this.TotalTime * this.Gravity) / 2;
        return this.IniVelocityY;
    }
}