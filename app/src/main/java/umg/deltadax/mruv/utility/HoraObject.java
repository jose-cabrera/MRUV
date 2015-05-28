package umg.deltadax.mruv.utility;

/**
 * Objeto para manipular horas en int
 * @author josepablocabreragarcia
 *
 */
public class HoraObject {

	private int hora;
	private int minutos;
	private int segundos;

	public HoraObject() {
	}

	public HoraObject(int hora, int minutos, int segundos) {
		setHora(hora);
		setMinutos(minutos);
		setSegundos(segundos);
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

}
