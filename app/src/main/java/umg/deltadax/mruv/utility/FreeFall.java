package Systems;

/*
 * ############################################################################
 *   Autor: JoshBucaro
 *   Fecha Creación: 2015/04/25
 *
 *   Funcionalidad: Properties y Funciones básicas para desarrollar MRUV
 *
 *   Historial de Modificación:
 *   AUTHOR	 FECHA		  RAZON
 *
 *
 *
 * ############################################################################
 */
public class FreeFall {

	// Properties-----
	// ----------------
	private double Gravity;
	private double Time;
	private double Height;
	private double FinVelocity;
	private double IniVelocity;

	// Constructors-----
	// ------------------
	public FreeFall() {
		this.Gravity		= 0;
		this.Time 			= 0;
		this.Height			= 0;
		this.IniVelocity 	= 0;
		this.FinVelocity	= 0;
	}


	// Setters-----
	// ------------
	public void setGravity(double Gravity){
		this.Gravity = Gravity;
	}
	public void setTime(double Time){
		this.Time = Time;
	}
	public void setHeight(double Height) {
		this.Height = Height;
	}
	public void setFinVelocity(double FinVelocity){
		this.FinVelocity = FinVelocity;
	}
	public void setIniVelocity(double IniVelocity){
		this.IniVelocity = IniVelocity;
	}


	// Getters-----
	// ------------
	public double getGravity(){
		return this.Gravity;
	}
	public double getTime(){
		return this.Time;
	}
	public double getHeight(){
		return this.Height;
	}
	public double getFinVelocity() {
		return this.FinVelocity;
	}
	public double getIniVelocity() {
		return this.IniVelocity;
	}


	// System Solving-----
	// -------------------

	// Gravity---
	// ----------
	public double fnCalcGravity1(){
		this.Gravity = (this.FinVelocity - this.IniVelocity * this.Time) / this.Time;
		return this.Gravity;
	}
	public double fnCalcGravity2(){
		this.Gravity = ((Math.pow(this.FinVelocity, 2)) - (Math.pow(this.IniVelocity, 2))) / (2 * this.Height);
		return this.Gravity;
	}
	public double fnCalcGravity3(){
		this.Gravity = (this.Height - (this.IniVelocity * this.Time)) / ((1/2) * Math.pow(this.Time, 2));
		return this.Gravity;
	}


	// Time---
	// -------
	public double fnCalcTime1(){
		this.Time = (this.FinVelocity - this.IniVelocity) / this.Gravity;
		return this.Time;
	}
	/*public double fnCalcTime2(){
		this.Time =  -- Dafuq con esta
	}*/
	public double fnCalcTime3() {
		this.Time = (2 * this.Height) / (this.FinVelocity + this.IniVelocity);
		return this.Time;
	}


	// Height---
	// ---------
	public double fnCalcHeight1(){
		this.Height = ((Math.pow(this.FinVelocity, 2)) - (Math.pow(this.IniVelocity, 2))) / (2 * this.Gravity);
		return this.Height;
	}
	public double fnCalcHeight2(){
		this.Height = (this.IniVelocity * this.Time) + ((1/2) * (this.Gravity * (Math.pow(this.Time, 2))));
		return this.Height;
	}
	public double fnCalcHeight3() {
		this.Height = ((this.FinVelocity - this.IniVelocity) / 2) * this.Time;
		return this.Height;
	}


	// FinVelocity---
	// --------------
	public double fnCalcFinVelocity1(){
		this.FinVelocity = this.IniVelocity + (this.Gravity * this.Time);
		return this.FinVelocity;
	}
	public double fnCalcFinVelocity2(){
		this.FinVelocity = Math.sqrt(Math.pow(this.IniVelocity,2) + (2 * this.Gravity * this.Height));
		return this.FinVelocity;
	}
	public double fnCalcFinVelocity3() {
		this.FinVelocity = ((2 * this.Height) / this.Time) - this.IniVelocity;
		return this.FinVelocity;
	}


	// IniVelocity---
	// --------------
	public double fnCalcIniVelocity1() {
		this.IniVelocity = this.FinVelocity - (this.Gravity * this.Time);
		return this.IniVelocity;
	}
	public double fnCalcIniVelocity2() {
		this.IniVelocity = Math.sqrt(Math.pow(this.FinVelocity,2) - (2 * this.Gravity * this.Height));
		return this.IniVelocity;
	}
	public double fnCalcIniVelocity3() {
		this.IniVelocity = this.Height - ((1/2) * (this.Gravity * Math.pow(this.Time, 2)));
		return this.IniVelocity;
	}
	public double fnCalcIniVelocity4() {
		this.IniVelocity = ((2 * this.Height) / this.Time) - this.FinVelocity;
		return this.IniVelocity;
	}
}