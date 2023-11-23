package com.inandout.real_rider.util;

import android.app.Activity;

public interface PermissionCallback {
    public void onPermissionGranted(Activity activity, String permission, int number);
}