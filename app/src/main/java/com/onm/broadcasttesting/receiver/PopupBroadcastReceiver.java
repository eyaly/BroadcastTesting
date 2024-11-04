package com.onm.broadcasttesting.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
public class PopupBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "PopupBroadcastReceiver";
    private static final String BROADCAST_ACTION = "android.intent.action.POPUP";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive function");
        if (BROADCAST_ACTION.equals(intent.getAction())) {
            String message = intent.getStringExtra("data");
            if (message != null && !message.isEmpty()) {
                showPopup(context, message);
            } else {
                Log.e(TAG, "No message received in data");
            }
        }
    }

    private void showPopup(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        Log.i(TAG, "Popup displayed with message: " + message);
    }
}
