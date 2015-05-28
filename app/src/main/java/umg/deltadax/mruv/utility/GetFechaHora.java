package umg.deltadax.mruv.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Obtiene la fecha y la hora en diferentes formatos de forma sencilla
 * 
 * @author josepablocabreragarcia
 */
public class GetFechaHora {

	private static Calendar calendar = Calendar.getInstance();

	private static final String TAG = "getFechaHora";

	public static String getDiaDeLaSemana(int day) {
		String dia = "";

		switch (day) {
		case Calendar.MONDAY: // 2
			dia = "Lunes";
			break;

		case Calendar.TUESDAY: // 3
			dia = "Martes";
			break;

		case Calendar.WEDNESDAY: // 4
			dia = "Miércoles";
			break;

		case Calendar.THURSDAY: // 5
			dia = "Jueves";
			break;

		case Calendar.FRIDAY: // 6
			dia = "Viernes";
			break;

		case Calendar.SATURDAY: // 7
			dia = "Sábado";
			break;

		case Calendar.SUNDAY: // 1
			dia = "Domingo";
			break;
		}

		return dia;
	}

	/**
	 * Obtiene un objeto fecha
	 * 
	 * @param timeToFormat
	 *            formato yyyy-MM-dd HH:mm:ss
	 * @return objeto de date con la fecha seteada
	 */
	public static Date getSimpleDate(String timeToFormat) {
		SimpleDateFormat iso8601Format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

		Date date = null;

		try {
			date = iso8601Format.parse(timeToFormat);
		} catch (ParseException e) {

			date = null;
		}

		return date;
	}

	/**
	 * Obtiene un objeto calendar
	 * 
	 * @param timeToFormat
	 *            formato yyyy-MM-dd HH:mm:ss
	 * @return objeto de date con la fecha seteada
	 */
	public static Calendar getSimpleDate(int year, int month, int day) {

		Calendar calendar = null;

		try {
			calendar = Calendar.getInstance(Locale.US);
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.MONTH, month - 1);
			calendar.set(Calendar.DAY_OF_MONTH, day);
		} catch (Exception e) {

			calendar = null;
		}

		return calendar;
	}

	/**
	 * Obtiene la fecha
	 * 
	 * @return objeto FechaObject
	 */
	public static FechaObject getFechaObject() {
		int month = calendar.get(Calendar.MONTH) + 1;

		return new FechaObject(calendar.get(Calendar.DAY_OF_MONTH), month,
				calendar.get(Calendar.YEAR));
	}

	/**
	 * Obtiene la fecha de un String separado por el parametro separador, con
	 * formato anio mes dia
	 * 
	 * @return un objeto de fecha
	 */
	public static FechaObject getFechaObjectFromStringYMD(String fecha,
			String separador) {

		try {
			String[] split = fecha.split(separador);

			return new FechaObject(Integer.parseInt(split[2]),
					Integer.parseInt(split[1]), Integer.parseInt(split[0]));
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Obtiene la fecha de un String separado por el parametro separador, con
	 * formato dia mes anio
	 * 
	 * @return un objeto de fecha
	 */
	public static FechaObject getFechaObjectFromStringDMY(String fecha,
			String separador) {

		try {
			String[] split = fecha.split(separador);

			return new FechaObject(Integer.parseInt(split[0]),
					Integer.parseInt(split[1]), Integer.parseInt(split[2]));
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Obtiene la fecha en formato YYYY/MM/DD
	 * 
	 * @return String YYYY/MM/DD
	 */
	public static String getFechaYMD() {
		int month = calendar.get(Calendar.MONTH) + 1;
		String sMonth = month + "";
		String dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
			dia = "0" + dia;
		}
		if (month < 10)
			sMonth = "0" + month;

		return calendar.get(Calendar.YEAR) + "/" + sMonth + "/" + dia;
	}

	/**
	 * Obtiene la fecha en formato YYYYMMDD con el signo de separacion que desee
	 * 
	 * @return String YYYYsignoSeparacionMMsignoSeparacionDD
	 */
	public static String getFechaYMD(String signoSeparacion) {
		int month = calendar.get(Calendar.MONTH) + 1;
		String sMonth = month + "";
		String dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
			dia = "0" + dia;
		}
		if (month < 10)
			sMonth = "0" + month;

		return calendar.get(Calendar.YEAR) + signoSeparacion + sMonth
				+ signoSeparacion + dia;
	}

	/**
	 * Obtiene la fecha en formato DD/MM/YYYY
	 * 
	 * @return String DD/MM/YYYY
	 */
	public static String getFechaDMY() {
		int month = calendar.get(Calendar.MONTH) + 1;
		String sMonth = month + "";
		String dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
			dia = "0" + dia;
		}
		if (month < 10)
			sMonth = "0" + month;

		return dia + "/" + sMonth + "/" + calendar.get(Calendar.YEAR);
	}

	/**
	 * Obtiene la fecha en formato DDMMYYYY con el signo de separacion que desee
	 * 
	 * @param signoSeparacion
	 *            String
	 * @return Stirng DDsignoSeparacionMMsignoSeparacionYYYY
	 */
	public static String getFechaDMY(String signoSeparacion) {
		int month = calendar.get(Calendar.MONTH) + 1;
		String sMonth = month + "";
		String dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
			dia = "0" + dia;
		}
		if (month < 10)
			sMonth = "0" + month;

		return dia + signoSeparacion + sMonth + signoSeparacion
				+ calendar.get(Calendar.YEAR);
	}

	/**
	 * Obtiene la fecha en formato MM/DD/YYYY;
	 * 
	 * @return String MM/DD/YYYY
	 */
	public static String getFechaMDY() {
		int month = calendar.get(Calendar.MONTH) + 1;
		String sMonth = month + "";
		String dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
			dia = "0" + dia;
		}
		if (month < 10)
			sMonth = "0" + month;

		return sMonth + "/" + dia + "/" + calendar.get(Calendar.YEAR);
	}

	/**
	 * Obtiene la fecha en formato MMDDYYYY con el signo de separacion que desee
	 * 
	 * @param signoSeparacion
	 *            String
	 * @return String MMsignoSeparacionDDsignoSeparacionYYYY
	 */
	public static String getFechaMDY(String signoSeparacion) {
		int month = calendar.get(Calendar.MONTH) + 1;
		String sMonth = month + "";
		String dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
			dia = "0" + dia;
		}
		if (month < 10)
			sMonth = "0" + month;

		return sMonth + signoSeparacion + dia + signoSeparacion
				+ calendar.get(Calendar.YEAR);
	}

	/**
	 * Obtiene la hora en formato 12 horas
	 * 
	 * @return String hh:mm:ss
	 */
	public static String getHora12() {
		calendar.clear();
		calendar = Calendar.getInstance();

		int hora = calendar.get(Calendar.HOUR);
		String sHora = hora + "";
		if (hora < 10)
			sHora = "0" + hora;

		int minutos = calendar.get(Calendar.MINUTE);
		String sMinutos = minutos + "";
		if (minutos < 10)
			sMinutos = "0" + minutos;

		int segundos = calendar.get(Calendar.SECOND);
		String sSegundos = segundos + "";
		if (segundos < 10)
			sSegundos = "0" + segundos;

		return sHora + ":" + sMinutos + ":" + sSegundos;
	}

	/**
	 * Obtiene la hora en formato 12 horas
	 * 
	 * @return object HoraObject
	 */
	public static HoraObject getHora12Object() {
		calendar.clear();
		calendar = Calendar.getInstance();

		int hora = calendar.get(Calendar.HOUR);

		int minutos = calendar.get(Calendar.MINUTE);

		int segundos = calendar.get(Calendar.SECOND);

		return new HoraObject(hora, minutos, segundos);
	}

	/**
	 * Obtiene la hora en formato de 24 horas
	 * 
	 * @return String hh:mm:ss
	 */
	public static String getHora24() {
		calendar.clear();
		calendar = Calendar.getInstance();

		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		String sHora = hora + "";
		if (hora < 10)
			sHora = "0" + hora;

		int minutos = calendar.get(Calendar.MINUTE);
		String sMinutos = minutos + "";
		if (minutos < 10)
			sMinutos = "0" + minutos;

		int segundos = calendar.get(Calendar.SECOND);
		String sSegundos = segundos + "";
		if (segundos < 10)
			sSegundos = "0" + segundos;

		return sHora + ":" + sMinutos + ":" + sSegundos;
	}

	/**
	 * Obtiene la hora en formato de 24 horas
	 * 
	 * @return Objeto HoraObject
	 */
	public static HoraObject getHora24Object() {
		calendar.clear();
		calendar = Calendar.getInstance();

		int hora = calendar.get(Calendar.HOUR_OF_DAY);

		int minutos = calendar.get(Calendar.MINUTE);

		int segundos = calendar.get(Calendar.SECOND);

		return new HoraObject(hora, minutos, segundos);
	}

	public static HoraObject getHora24ObjectFromString(String hora,
			String separador) {

		try {
			String[] split = hora.split(separador);

			return new HoraObject(Integer.parseInt(split[0]),
					Integer.parseInt(split[1]), Integer.parseInt(split[2]));
		} catch (Exception e) {
			return null;
		}

	}

}
