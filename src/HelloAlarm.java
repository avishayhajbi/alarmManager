package com.plugin.am;
//notification
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.os.PowerManager;

//import com.avishayhajbi.finance.R;

//caoander
import java.lang.System;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
//json parse
import org.json.JSONObject;



public class HelloAlarm extends CordovaPlugin{

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if(action.equals("am")){
          final String message = args.getString(0); 
          	cordova.getActivity().runOnUiThread(new Runnable() { //cordova.getThreadPool().execute(new Runnable() {
	        	public void run() {
                   
		            android.widget.Toast toast = android.widget.Toast.makeText(webView.getContext(),"alarm manager" , 0);
		           	toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 20);
		           	toast.setDuration(android.widget.Toast.LENGTH_LONG);
					toast.show();
					
		       		callbackContext.success("java returning value");
	            }
            });
            return true;
        }
        
      	callbackContext.error("unknown");
      	return false;
    }
    
   /* public void activateNotification(int id,String title,String message){
     
        System.out.println("creating notification");
		//Context context = webView.getContext();
        Context context = super.cordova.getActivity().getApplicationContext();
        // Get taskId & message
        if (id < 0) id *=-1;
        int taskId = id;
        String notificationText = message;

        Intent intent = new Intent(context,HelloAlarm.class);
        intent.setAction(""+taskId);
        intent.putExtra("taskId", id);
        intent.putExtra("notificationText", message );
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, taskId, intent,  0);
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification(android.R.drawable.ic_menu_info_details, notificationText ,System.currentTimeMillis());
        notification.setLatestEventInfo( context,title, notificationText, pendingIntent);
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notificationManager.notify(taskId, notification); // to execute
    }*/
 
}
