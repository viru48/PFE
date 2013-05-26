
package com.tunav.tunavmedi.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.tunav.tunavmedi.abstraction.AuthenticationHandler;
import com.tunav.tunavmedi.demo.sqlite.helper.AuthenticationHelper;

public class AuthService extends IntentService {
    /**
     * Class used for the client Binder. Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class AuthBinder extends Binder {
        public AuthenticationHandler getHandler(Context context) {
            Log.v(TAG, "getHandler()");// FIXME use the service to authenticate
            return new AuthenticationHelper(context);
        }

        public AuthService getService() {
            // Return this instance of LocalService so clients can call public
            // methods
            return AuthService.this;
        }
    }

    private static final String TAG = "AuthenticationIntentService";
    public static final String ACTION_LOGIN = "com.tunav.tunavmedi.action.authentication.AUTHENTICATE";
    public static final String ACTION_LOGOUT = "com.tunav.tunavmedi.action.authentication.DEAUTHENTICATE";

    public static final String ACTION_CHECK = "com.tunav.tunavmedi.action.authentication.CHECK";
    public static final String EXTRA_USERNAME = "com.tunav.tunavmedi.action.authentication.USERNAME";
    public static final String EXTRA_PASSWORD = "com.tunav.tunavmedi.action.authentication.PASSWORD";
    public static final String EXTRA_USERID = "com.tunav.tunavmedi.action.authentication.USERID";

    public static final String EXTRA_CODE = "com.tunav.tunavmedi.action.authentication.CODE";

    // Binder given to clients
    private final IBinder mBinder = new AuthBinder();

    public AuthService() {
        super(TAG);
        Log.v(TAG, "AuthenticationIntentService()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // TODO
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}