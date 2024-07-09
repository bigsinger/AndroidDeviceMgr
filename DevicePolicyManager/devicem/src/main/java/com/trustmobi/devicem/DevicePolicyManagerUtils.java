package com.trustmobi.devicem;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;

public class DevicePolicyManagerUtils {
    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mDeviceAdminReceiver;

    public DevicePolicyManagerUtils(Context context) {
        mDevicePolicyManager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        mDeviceAdminReceiver = new ComponentName(context, DeviceAdminReceiver.class);
    }

    // 禁止App启动
    public void disableApp(String packageName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDevicePolicyManager.setApplicationHidden(mDeviceAdminReceiver, packageName, true);
        }
    }

    // 允许App运行
    public void enableApp(String packageName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mDevicePolicyManager.setApplicationHidden(mDeviceAdminReceiver, packageName, false);
        }
    }
}
