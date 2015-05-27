package com.centrikal.visitasmovil.utility;

import com.centrikal.visitasmovil.VisitasMovil;
import com.centrikal.visitasmovil.VisitasMovil.TrackerName;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.util.Log;

public class SendGAInfo {

	public static void SendGAScreenName(Activity activity, String name) {

		// Get tracker.
		Log.d("GOOGLE ANALYTICS", "GET GA TRACKER");
		Tracker t = ((VisitasMovil) activity.getApplication())
				.getTracker(TrackerName.APP_TRACKER);

		// Set screen name.
		// Where path is a String representing the screen name.
		Log.d("GOOGLE ANALYTICS", "SET GA NAME");
		t.setScreenName(name);

		// Send a screen view.
		Log.d("GOOGLE ANALYTICS", "SEND GA TRACKER");
		t.send(new HitBuilders.AppViewBuilder().build());

	}

	public static void sendGAEvent(Activity activity, String categoryId,
			String actionId, String labelId) {
		// Get tracker.
		Tracker t = ((VisitasMovil) activity.getApplication())
				.getTracker(TrackerName.APP_TRACKER);
		// Build and send an Event.
		t.send(new HitBuilders.EventBuilder().setCategory(categoryId)
				.setAction(actionId).setLabel(labelId).build());
	}
	
	public static void sendGAEvent(Context context, String categoryId,
			String actionId, String labelId) {
		// Get tracker.
		Tracker t = ((VisitasMovil) context.getApplicationContext())
				.getTracker(TrackerName.APP_TRACKER);
		// Build and send an Event.
		t.send(new HitBuilders.EventBuilder().setCategory(categoryId)
				.setAction(actionId).setLabel(labelId).build());
	}
	
	public static void sendGAEvent(Service service, String categoryId,
			String actionId, String labelId) {
		// Get tracker.
		Tracker t = ((VisitasMovil) service.getApplication())
				.getTracker(TrackerName.APP_TRACKER);
		// Build and send an Event.
		t.send(new HitBuilders.EventBuilder().setCategory(categoryId)
				.setAction(actionId).setLabel(labelId).build());
	}

}
