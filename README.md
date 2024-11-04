# Testing Broadcast on Android devices 

## Sending broadcast with a message to the BroadcastTesting App
### Using ADB Command
```shell
adb -s R5CT50EF2QN shell am broadcast -a android.intent.action.POPUP -n com.onm.broadcasttesting/.receiver.PopupBroadcastReceiver --es data "Bamba"
```
### Using Appium Command
```shell
        HashMap<String, Object> broadcastArgs = new HashMap<>();
        broadcastArgs.put("action", "android.intent.action.POPUP"); // Intent action
        broadcastArgs.put("package", "com.onm.broadcasttesting");   // Package name
        broadcastArgs.put("component", "com.onm.broadcasttesting/.receiver.PopupBroadcastReceiver"); // Full component name

// Define extras as an array of arrays in the required format
        ArrayList<Object> extras = new ArrayList<>();
        extras.add(Arrays.asList("s", "data", "Bamba")); // 's' for String type, key is 'data', and the value

        broadcastArgs.put("extras", extras);   // Add extras array to broadcastArgs

// Execute the broadcast
        driver.executeScript("mobile: broadcast", broadcastArgs);
```

## Sending broadcast with a message to the BroadcastTesting App to create a new file
### Using ADB Command
```shell
adb -s R5CT50EF2QN shell am broadcast -a android.intent.action.CREATE_FILE -n com.onm.broadcasttesting/.receiver.FileCreationBroadcastReceiver --es data "/storage/emulated/0/Download/myFile.txt"
```
### Using Appium Command 
```shell
        HashMap<String, Object> broadcastArgs = new HashMap<>();
        broadcastArgs.put("action", "android.intent.action.CREATE_FILE");  // Action to match the new receiver
        broadcastArgs.put("package", "com.onm.broadcasttesting");          // Package name
        broadcastArgs.put("component", "com.onm.broadcasttesting/.receiver.FileCreationBroadcastReceiver"); // Full component name

// Define extras with the file path in the required format
        ArrayList<Object> extras = new ArrayList<>();
        extras.add(Arrays.asList("s", "data", "/storage/emulated/0/Download/myFile2.txt")); // 's' for String type, key is 'data', value is the file path

        broadcastArgs.put("extras", extras);   // Add extras array to broadcastArgs

// Execute the broadcast
        driver.executeScript("mobile: broadcast", broadcastArgs);
```

### Start local Appium server with enable Appium shell - 
```shell
appium --allow-insecure chromedriver_autodownload --allow-insecure=adb_shell
```
