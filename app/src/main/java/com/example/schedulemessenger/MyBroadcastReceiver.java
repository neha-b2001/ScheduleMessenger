package com.example.schedulemessenger;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Hello, from my Broadcast Receiver!", Toast.LENGTH_SHORT).show();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("1111111111", null, "Hello!",
                null, null);

        createNotificationChannel(context);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context,
                "notifyAboutSms")
                .setSmallIcon(R.drawable.ic_sms)
                .setContentTitle("Message sent!")
                .setContentText("Message has been sent to the intended recipient.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200, notificationBuilder.build());
    }

    private void createNotificationChannel(Context context) {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "SmsNotificationChannel";
            String description = "Notification Channel for SMS";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel smsNotificationChannel = new NotificationChannel(
                    "notifyAboutSms", name, importance);
            smsNotificationChannel.setDescription(description);

            NotificationManager smsNotificationManager = context.getSystemService(NotificationManager.class);
            smsNotificationManager.createNotificationChannel(smsNotificationChannel);

        }
    }
}