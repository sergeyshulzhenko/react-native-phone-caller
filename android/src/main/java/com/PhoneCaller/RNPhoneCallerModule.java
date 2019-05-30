package com.PhoneCaller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNPhoneCallerModule extends ReactContextBaseJavaModule {
    public RNPhoneCallerModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNPhoneCaller";
    }

    @ReactMethod
    public void call(String phoneNumber, Promise promise) {
        if (TextUtils.isEmpty(phoneNumber)) {
            promise.reject(new JSApplicationIllegalArgumentException("Invalid phone number: " + phoneNumber));
            return;
        }

        try {
            Activity currentActivity = getCurrentActivity();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            if (currentActivity != null) {
             currentActivity.startActivity(intent);
            } else {
             getReactApplicationContext().startActivity(intent);
            }

            promise.resolve("Success");
        } catch (Exception e) {
            promise.reject(new JSApplicationIllegalArgumentException(
                "Couldn't make a phone call to '" + phoneNumber + "': " + e.getMessage()));
            }
    }
}
