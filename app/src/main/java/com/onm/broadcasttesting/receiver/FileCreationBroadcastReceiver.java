package com.onm.broadcasttesting.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class FileCreationBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "FileCreationReceiver";
    private static final String BROADCAST_ACTION = "android.intent.action.CREATE_FILE";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive function");
        if (BROADCAST_ACTION.equals(intent.getAction())) {
            String filePath = intent.getStringExtra("data");
            if (filePath != null && !filePath.isEmpty()) {
                createFile(context, filePath);
            } else {
                Log.e(TAG, "No file path provided in data");
            }
        }
    }

    private void createFile(Context context, String path) {
        Toast.makeText(context, "Start", Toast.LENGTH_LONG).show();
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                Log.i(TAG, "File created successfully at " + path);
                Toast.makeText(context, "Done", Toast.LENGTH_LONG).show(); // Show "Done" message on success
            } else {
                Log.i(TAG, "File already exists at " + path);
                Toast.makeText(context, "File already exists", Toast.LENGTH_LONG).show(); // Show "Done" message on success
            }
        } catch (IOException e) {
            Log.e(TAG, "Failed to create file", e);
            Toast.makeText(context, "Failed to create file", Toast.LENGTH_LONG).show(); // Show error message if failed
        }
    }
}
