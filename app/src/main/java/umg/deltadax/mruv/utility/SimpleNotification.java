package umg.deltadax.mruv.utility;

import java.util.Random;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class SimpleNotification {

	private final String TAG;

	private Context context;
	private NotificationCompat.Builder mBuilder;
	private NotificationManager mNotificationManager;
	private final int mId;

	/**
	 * Inicia lo necesario para mostrar una notificación simple
	 * @param context
	 */
	public SimpleNotification(Context context) {
		Random randomGenerator = new Random();

		TAG = getClass().toString();
		mId = randomGenerator.nextInt(100);

		this.context = context;
		mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
	}

	/**
	 * Crea una notificación, pero no la muestra. Debes llamar showNotification() 
	 * @param title titulo para la notificación
	 * @param message mensaje a mostrar en la notificación
	 * @param intent Intent de la activity a donde quieras que valla en caso es oprimida
	 * @param icon icono a mostrar en la notificación
	 */
	public void createNotification(String title, String message, int icon,
			Intent intent) {
		mBuilder = new NotificationCompat.Builder(context).setSmallIcon(icon)
				.setContentTitle(title).setContentText(message);

		if (intent != null) {
			// The stack builder object will contain an artificial back stack
			// for the
			// started Activity.
			// This ensures that navigating backward from the Activity leads out
			// of
			// your application to the Home screen.
			TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
			// Adds the Intent that starts the Activity to the top of the stack
			stackBuilder.addNextIntent(intent);

			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
					0, PendingIntent.FLAG_UPDATE_CURRENT);
			mBuilder.setContentIntent(resultPendingIntent);
			mBuilder.setAutoCancel(true);
		}
	}
	
	/**
	 * Crea una notificación, pero no la muestra. Debes llamar showNotification() 
	 * @param title titulo para la notificación
	 * @param message mensaje a mostrar en la notificación	 
	 * @param icon icono a mostrar en la notificación
	 */
	public void createNotification(String title, String message, int icon) {
		mBuilder = new NotificationCompat.Builder(context).setSmallIcon(icon)
				.setContentTitle(title).setContentText(message);		
	}

	/**
	 * Muestra la notificación
	 */
	public void showNotification() {
		if (mBuilder != null) {
			mNotificationManager.notify(mId, mBuilder.build());
		} else {

		}

	}

}
