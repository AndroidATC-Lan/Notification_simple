package com.example.diego.notifications;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    NotificationManager nManager;
    int notificationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_notificatoion = (Button) findViewById(R.id.btn_notificacao);
        btn_notificatoion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        notification();
    }

    private void notification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_stat_name);
        mBuilder.setContentTitle(getResources().getString(R.string.ntf_titulo));
        mBuilder.setContentText(getResources().getString(R.string.ntf_texto) + ": " + notificationId);

        nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.notify(notificationId, mBuilder.build());
        notificationId += 1;
    }
}
