package net.synapticweb.callrecorder.recorder;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import net.synapticweb.callrecorder.CallRecorderApplication;
import net.synapticweb.callrecorder.R;
import net.synapticweb.callrecorder.contactslist.ContactsListActivityMain;


public class ControlRecordingReceiver extends BroadcastReceiver {
    private static final String TAG = "CallRecorder";
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(intent.getAction().equals(RecorderBox.ACTION_START_RECORDING)) {
            String callIdentifier =  intent.getExtras().getString(RecorderService.CALL_IDENTIFIER);
            String phoneNumber = intent.getExtras().getString(RecorderService.PHONE_NUMBER);
            if(nm != null)
                nm.notify(RecorderService.NOTIFICATION_ID, RecorderService.buildNotification(RecorderService.RECORD_AUTOMMATICALLY, callIdentifier));
            RecorderBox.doRecording(CallRecorderApplication.getInstance(), phoneNumber);
        }
    }
}
