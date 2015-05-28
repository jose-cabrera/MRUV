package umg.deltadax.mruv.utility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ShowToast {

	static Toast tNonInstant;
	private static Activity ctx;
	
	public static void setContext(Activity context){
		ctx = context;
	}

	/**
	 * Shows a Toast for short time
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void instantMessage(final String message, final Context ctx) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
		msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
	}
	
	/**
	 * Shows a Toast for short time
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void instantMessageBootom(final String message, final Context ctx) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
		msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
	}
	
	/**
	 * Shows a Toast for short time
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void instantMessage(final String message) {
//		LayoutInflater inflater = ctx.getLayoutInflater();
//		View layout = inflater.inflate(R.layout.toast, (ViewGroup) ctx.findViewById(R.id.root));
//
//		TextView text = (TextView) layout.findViewById(R.id.tv_toast);
//		text.setText(message);
		
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
		msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
//		msg.setView(layout);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
	}

	/**
	 * Shows a Toast for long time
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void longInstantMessage(final String message,
			final Context ctx) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
		msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
	}
	
	/**
	 * Shows a Toast for long time
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void longInstantMessage(final String message) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
		msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
	}

	/**
	 * Shows a Toast for long time * 2
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void veryLongInstantMessage(final String message,
			final Context ctx) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_LONG * 2);
		msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
		
	}
	
	/**
	 * Shows a Toast for long time * 2
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void veryLongInstantMessage(final String message) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_LONG * 2);
		msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
		
	}

	/**
	 * Shows a Toast for long time * 2 on the Bottom of the Screen
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void veryLongInstantMessageBottom(final String message,
			final Context ctx) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_LONG * 2);
		msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
	
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
		
	}
	
	/**
	 * Shows a Toast for long time * 2 on the Bottom of the Screen
	 * 
	 * @param message
	 *            , String, The message that will be display
	 * @param ctx
	 *            , Context, the context (Activity) where it is going to be show
	 */
	public static void veryLongInstantMessageBottom(final String message) {
		Toast msg = Toast.makeText(ctx, message, Toast.LENGTH_LONG * 2);
		msg.setGravity(Gravity.BOTTOM, msg.getXOffset() / 2,
				msg.getYOffset() / 2);
		
		if(!((Activity) ctx).isFinishing())
		{
			msg.show();
		}
		
	}

	@SuppressLint("ShowToast")
	public static void Message(final String message, final Context ctx) {
		tNonInstant = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
		tNonInstant.setGravity(Gravity.CENTER, tNonInstant.getXOffset() / 2,
				tNonInstant.getYOffset() / 2);
	}
	
	@SuppressLint("ShowToast")
	public static void Message(final String message) {
		tNonInstant = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
		tNonInstant.setGravity(Gravity.CENTER, tNonInstant.getXOffset() / 2,
				tNonInstant.getYOffset() / 2);
	}

	public static void ShowNonInstanMessage() {
		
		if(!((Activity) ctx).isFinishing())
		{
			tNonInstant.show();
		}
		
	}
}
