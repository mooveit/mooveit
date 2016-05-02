package com.ideyatech.moove.ble;


import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.ideyatech.moove.ble.Config;
import com.ideyatech.moove.ble.ParserHelper;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class BandBLEService extends Service {

    public static final String ACTION_DATA_AVAILABLE = "com.ideyatech.smart.bracelet.ACTION_DATA_AVAILABLE";
    public static final String ACTION_DEVICE_FOUND = "com.ideyatech.smart.bracelet.ACTION_DEVICE_FOUND";
    public static final String ACTION_GATT_CONNECTED = "com.ideyatech.smart.bracelet.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_CONNECTED_FAIL = "com.ideyatech.smart.bracelet.ACTION_GATT_CONNECTED_FAIL";
    public static final String ACTION_GATT_DISCONNECTED = "com.ideyatech.smart.bracelet.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_RECEIVE_ACTIVITY = "ACTION_GATT_RECEIVE_ACTIVITY";
    public static final String ACTION_GATT_RECEIVE_ACTIVITY_COUNT = "ACTION_GATT_RECEIVE_ACTIVITY_COUNT";
    public static final String ACTION_GATT_RECEIVE_BEACON_ZOON = "ACTION_GATT_RECEIVE_BEACON_ZOON";
    public static final String ACTION_GATT_RECEIVE_PRESS_KEY = "ACTION_GATT_RECEIVE_PRESS_KEY";
    public static final String ACTION_GATT_RECEIVE_SCREEN = "ACTION_GATT_RECEIVE_SCREEN";
    public static final String ACTION_GATT_SERVICES_DISCOVERED = "com.ideyatech.smart.bracelet.ACTION_GATT_SERVICES_DISCOVERED";
    public static final String ACTION_READ_REMOVE_RSSI = "com.ideyatech.smart.bracelet.READ_REMOVE_RSSI";
    public static final String ACTION_RECEIVE_DATA = "com.ideyatech.smart.bracelet.ACTION_RECEIVE_DATA";
    public static final String ACTION_WRITE_DATE_TIME_SUCCESS = "ACTION_WRITE_DATE_TIME_SUCCESS";
    public static final String ACTION_WRITE_DESCRIPTOR = "com.ideyatech.smart.bracelet.WRITE_DESCRIPTOR";
    public static final String KEY_RECEIVE_DATA = "com.ideyatech.smart.bracelet.le.UPADTEDATA";
    public static final String KEY_RSSI_VALUE = "KEY_RSSI_VALUE";
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    private String TAG = "EnergiBLEService";
    private final IBinder mBinder = new LocalBinder();
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothManager mBluetoothManager;
    private int mConnectionState = 0;

    /**
     *
     */
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        public void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic) {
            byte[] arrayOfByte = paramAnonymousBluetoothGattCharacteristic.getValue();
            int i = ParserHelper.getByteValue(arrayOfByte[0]);
            if (i == 144) {
                Log.i(BandBLEService.this.TAG, "*****骞挎挱 activity count");
                int k = ParserHelper.parseActivityCount(arrayOfByte);
                Bundle localBundle4 = new Bundle();
                localBundle4.putInt("KEY_COUNT", k);
                BandBLEService.this.broadcastUpdate("ACTION_GATT_RECEIVE_ACTIVITY_COUNT", "KEY_COUNT", localBundle4);
                //*********************************************************************************************************
                return;
            }
            do {
                if (i == 147) {
                    Log.i(BandBLEService.this.TAG, "*****骞挎挱 activity");
                    new ArrayList();
                    //ArrayList localArrayList = ParserHelper.parseActivity(arrayOfByte);
                    Bundle localBundle3 = new Bundle();
                    //localBundle3.putParcelableArrayList("KEY_ACTIVITY_DATA", localArrayList);
                    BandBLEService.this.broadcastUpdate("ACTION_GATT_RECEIVE_ACTIVITY", "KEY_ACTIVITY_DATA", localBundle3);
                    return;
                }
                if (i == 209) {
                    Log.i(BandBLEService.this.TAG, "*****骞挎挱 press key");
                    int j = ParserHelper.getByteValue(arrayOfByte[2]);
                    Bundle localBundle2 = new Bundle();
                    localBundle2.putInt("KEY_PRESS_KEY", j);
                    BandBLEService.this.broadcastUpdate("ACTION_GATT_RECEIVE_PRESS_KEY", "KEY_PRESS_KEY", localBundle2);
                    return;
                }
            } while (i != 193);
            Log.i(BandBLEService.this.TAG, "*****骞挎挱 beacon zoon");
            String str = ParserHelper.parseZoon(arrayOfByte);
            Bundle localBundle1 = new Bundle();
            localBundle1.putString("KEY_BEACON_ZOON", str);
            BandBLEService.this.broadcastUpdate("ACTION_GATT_RECEIVE_BEACON_ZOON", "KEY_BEACON_ZOON", localBundle1);
        }

//        /**
//         *
//         * @param paramAnonymousBluetoothGatt
//         * @param paramAnonymousBluetoothGattCharacteristic
//         * @param paramAnonymousInt
//         */
//        public void onCharacteristicRead(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt) {
//        }
//
//
//        public void onCharacteristicWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic, int paramAnonymousInt) {
//            Log.i(BandBLEService.this.TAG, "onCharacteristicWrite");
//            int i;
//            if (paramAnonymousInt == 0) {
//                System.out.println("GATT_SUCCESS");
//                i = ParserHelper.getByteValue(paramAnonymousBluetoothGattCharacteristic.getValue()[0]);
//                if (i != 1) {
//                    break label60;
//                }
//                BandBLEService.this.broadcastUpdate("ACTION_WRITE_DATE_TIME_SUCCESS");
//                System.out.println("ACTION_WRITE_DATE_TIME_SUCCESS");
//                label60:
//            }
//
//            do {
//                return;
//                if (i == 2) {
//                    Log.i(BandBLEService.this.TAG, "write day mode success");
//                    return;
//                }
//                if (i == 3) {
//                    Log.i(BandBLEService.this.TAG, "write alarm success");
//                    return;
//                }
//                if (i == 10) {
//                    Log.i(BandBLEService.this.TAG, "write language success");
//                    return;
//                }
//                if (i == 11) {
//                    Log.i(BandBLEService.this.TAG, "write target success");
//                    return;
//                }
//                if (i == 13) {
//                    Log.i(BandBLEService.this.TAG, "write hour success");
//                    return;
//                }
//                if (i == 12) {
//                    Log.i(BandBLEService.this.TAG, "write body success");
//                    return;
//                }
//                if (i == 19) {
//                    Log.i(BandBLEService.this.TAG, "write activity success");
//                    return;
//                }
//                if (i == 16) {
//                    Log.i(BandBLEService.this.TAG, "write activity_count success");
//                    return;
//                }
//                if (i == 96) {
//                    Log.i(BandBLEService.this.TAG, "write sensor success");
//                    return;
//                }
//            } while (i != 97);
//            Log.i(BandBLEService.this.TAG, "write sensor_value success");
//        }

        /**
         *
         * @param paramAnonymousBluetoothGatt
         * @param paramAnonymousInt1
         * @param paramAnonymousInt2
         */
        public void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2) {
            if (paramAnonymousInt2 == 2) {
                if (paramAnonymousInt1 == 0) {
                    Log.i(BandBLEService.this.TAG, "Connected to GATT server.");
                    BandBLEService.this.mConnectionState = 2;
                    BandBLEService.this.broadcastUpdate("com.gzgamut.max.bluetooth.le.ACTION_GATT_CONNECTED");
                    Log.i(BandBLEService.this.TAG, "Attempting to start service discovery:" + BandBLEService.this.mBluetoothGatt.discoverServices());
                }
                return;
            }
            while (paramAnonymousInt2 != 0) {
                BandBLEService.this.mConnectionState = 0;
                BandBLEService.this.disconnect();
                BandBLEService.this.broadcastUpdate("com.ideyatech.smart.bracelet.ACTION_GATT_CONNECTED_FAIL");
                return;
            }
            Log.i(BandBLEService.this.TAG, "Disconnected from GATT server.");
            BandBLEService.this.mConnectionState = 0;
            BandBLEService.this.broadcastUpdate("com.gzgamut.max.bluetooth.le.ACTION_GATT_DISCONNECTED");
            BandBLEService.this.close();
        }

        /**
         *
         * @param paramAnonymousBluetoothGatt
         * @param paramAnonymousBluetoothGattDescriptor
         * @param paramAnonymousInt
         */
        public void onDescriptorWrite(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattDescriptor paramAnonymousBluetoothGattDescriptor, int paramAnonymousInt) {
            if (paramAnonymousInt == 0) {
                BandBLEService.this.broadcastUpdate("com.ideyatech.smart.bracelet.WRITE_DESCRIPTOR");
            }
        }

        /**
         *
         * @param paramAnonymousBluetoothGatt
         * @param paramAnonymousInt1
         * @param paramAnonymousInt2
         */
        public void onReadRemoteRssi(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2) {
            Log.i(BandBLEService.this.TAG, "rssi value: " + paramAnonymousInt1);
            BandBLEService.this.broadcastRSSI(paramAnonymousInt1);
        }

        /**
         *
         * @param paramAnonymousBluetoothGatt
         * @param paramAnonymousInt
         */
        public void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt) {
            Log.i(BandBLEService.this.TAG, "onServicesDiscovered received: " + paramAnonymousInt);
            if (paramAnonymousInt == 0) {
                BandBLEService.this.broadcastUpdate("com.ideyatech.smart.bracelet.ACTION_GATT_SERVICES_DISCOVERED");
                return;
            }
            Log.w(BandBLEService.this.TAG, "onServicesDiscovered received: " + paramAnonymousInt);
        }
    };
//    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
//        public void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte) {
//            Bundle localBundle = new Bundle();
//            localBundle.putParcelable("android.bluetooth.device.extra.DEVICE", paramAnonymousBluetoothDevice);
//            localBundle.putInt("android.bluetooth.device.extra.RSSI", paramAnonymousInt);
//            Intent localIntent = new Intent();
//            localIntent.setAction("com.gzgamut.max.bluetooth.le.ACTION_DEVICE_FOUND");
//            localIntent.putExtras(localBundle);
//            BandBLEService.this.sendBroadcast(localIntent);
//        }
//    };

    /**
     *
     * @param paramInt
     */
    private void broadcastRSSI(int paramInt) {
        Intent localIntent = new Intent("com.ideyatech.smart.bracelet.READ_REMOVE_RSSI");
        localIntent.putExtra("KEY_RSSI_VALUE", paramInt);
        sendBroadcast(localIntent);
    }

    /**
     *
     * @param paramString
     */
    private void broadcastUpdate(String paramString) {
        sendBroadcast(new Intent(paramString));
    }

    /**
     *
     * @param paramString1
     * @param paramString2
     * @param paramBundle
     */
    private void broadcastUpdate(String paramString1, String paramString2, Bundle paramBundle) {
        Intent localIntent = new Intent(paramString1);
        localIntent.putExtras(paramBundle);
        sendBroadcast(localIntent);
    }

    /**
     *
     * @param paramBluetoothGattService
     * @param paramUUID
     * @return
     */
    private BluetoothGattCharacteristic getBluetoothGattCharacteristic(BluetoothGattService paramBluetoothGattService, UUID paramUUID) {
        if (paramBluetoothGattService != null) {
            BluetoothGattCharacteristic localBluetoothGattCharacteristic = paramBluetoothGattService.getCharacteristic(paramUUID);
            if (localBluetoothGattCharacteristic != null) {
                return localBluetoothGattCharacteristic;
            }
            Log.i(this.TAG, "getBluetoothGattCharacteristic, bluetoothGattServer get characteristic uuid:" + paramUUID + " is null");
        }
        for (;;){
            //***************************************************************************************************************
            Log.i(this.TAG, "mBluetoothGattServer is null");
            return null;
        }
    }

    /**
     *
     * @param paramBluetoothGatt
     * @param paramUUID
     * @return
     */
    private BluetoothGattService getBluetoothGattService(BluetoothGatt paramBluetoothGatt, UUID paramUUID) {
        if (paramBluetoothGatt != null) {
            BluetoothGattService localBluetoothGattService = paramBluetoothGatt.getService(paramUUID);
            if (localBluetoothGattService != null) {
                return localBluetoothGattService;
            }
            Log.i(this.TAG, "getBluetoothGattService, bluetoothgatt get service uuid:" + paramUUID + " is null");
        }
        for (; ; ) {
            //*************************************************************************************************************
            Log.i(this.TAG, "mBluetoothGatt is null");
            return null;
        }
    }

    /**
     *
     */
    public void close() {
        if (this.mBluetoothGatt == null) {
            return;
        }
        this.mBluetoothGatt.close();
        this.mBluetoothGatt = null;
    }

    /**
     *
     * @param paramString
     * @param paramBoolean
     * @return
     */
    public boolean connect(String paramString, boolean paramBoolean) {
        if ((this.mBluetoothAdapter == null) || (paramString == null)) {
            Log.w(this.TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        BluetoothDevice localBluetoothDevice = this.mBluetoothAdapter.getRemoteDevice(paramString);
        if (localBluetoothDevice == null) {
            Log.w(this.TAG, "Device not found.  Unable to connect.");
            return false;
        }
        this.mBluetoothGatt = localBluetoothDevice.connectGatt(this, false, this.mGattCallback);
        Log.d(this.TAG, "Trying to create a new connection.");
        this.mBluetoothDeviceAddress = paramString;
        this.mConnectionState = 1;
        return true;
    }

    /**
     *
     */
    public void disconnect() {
        if ((this.mBluetoothAdapter == null) || (this.mBluetoothGatt == null)) {
            Log.w(this.TAG, "BluetoothAdapter not initialized");
            return;
        }
        this.mBluetoothGatt.disconnect();
    }

//    public int getConnectionState() {
//        return this.mConnectionState;
//    }
//
//    public String getDeviceAddress() {
//        return this.mBluetoothDeviceAddress;
//    }
//
//    public boolean getRssiVal() {
//        if (this.mBluetoothGatt == null) {
//            return false;
//        }
//        return this.mBluetoothGatt.readRemoteRssi();
//    }

//    public List<BluetoothGattService> getSupportedGattServices() {
//        if (this.mBluetoothGatt == null) {
//            return null;
//        }
//        return this.mBluetoothGatt.getServices();
//    }
//
//    public void get_activity_by_count(Context paramContext, int paramInt1, int paramInt2) {
//        byte[] arrayOfByte = ParserHelper.getActivityValue(paramContext, paramInt1, paramInt2);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void get_activity_count(Context paramContext) {
//        byte[] arrayOfByte = ParserHelper.getActivityCountValue(paramContext);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void get_beacon_zoon(Context paramContext) {
//        byte[] arrayOfByte = ParserHelper.getZoonValue(paramContext);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }

    /**
     *
     * @return
     */
    public boolean initialize() {
        if (this.mBluetoothManager == null) {
            this.mBluetoothManager = ((BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE));
            if (this.mBluetoothManager == null) {
                Log.e(this.TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }
        this.mBluetoothAdapter = this.mBluetoothManager.getAdapter();
        if (this.mBluetoothAdapter == null) {
            Log.e(this.TAG, "Unable to obtain a BluetoothAdapter.");
            return false;
        }
        return true;
    }

    /**
     *
     * @param paramIntent
     * @return
     */
    public IBinder onBind(Intent paramIntent) {
        return this.mBinder;
    }

    /**
     *
     */
    public void onCreate() {
        initialize();
    }

    /**
     *
     * @param paramIntent
     * @return
     */
    public boolean onUnbind(Intent paramIntent) {
        close();
        return super.onUnbind(paramIntent);
    }

//    public void readCharacteristic(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic) {
//        if ((this.mBluetoothAdapter == null) || (paramBluetoothGatt == null)) {
//            Log.w(this.TAG, "BluetoothAdapter not initialized");
//            return;
//        }
//        paramBluetoothGatt.readCharacteristic(paramBluetoothGattCharacteristic);
//    }
//    public void scan(boolean paramBoolean) {
//        if (this.mBluetoothAdapter != null) {
//            if (paramBoolean) {
//                this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
//                return;
//            }
//            this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
//            return;
//        }
//        Log.i(this.TAG, "bluetoothadapter is null");
//    }

//    public void setCharacteristicNotification(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean) {
//        if ((this.mBluetoothAdapter == null) || (this.mBluetoothGatt == null)) {
//            Log.w(this.TAG, "BluetoothAdapter not initialized");
//            return;
//        }
//        this.mBluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
//    }

//    public void setCharacteristicNotify(UUID paramUUID1, UUID paramUUID2) {
//        BluetoothGattCharacteristic localBluetoothGattCharacteristic = getBluetoothGattCharacteristic(getBluetoothGattService(this.mBluetoothGatt, paramUUID1), paramUUID2);
//        if ((this.mBluetoothGatt != null) && (localBluetoothGattCharacteristic != null)) {
//            this.mBluetoothGatt.setCharacteristicNotification(localBluetoothGattCharacteristic, true);
//        }
//        do {
//
//            if (this.mBluetoothGatt == null) {
//                Log.i(this.TAG, "mBluetoothGatt is null");
//                return;
//            }
//        } while (localBluetoothGattCharacteristic != null);
//        Log.i(this.TAG, "mBluetoothGattCharacteristic is null");
//    }
//
//    public void setCharactoristicNotifyAndWriteDescriptor(BluetoothGatt paramBluetoothGatt, UUID paramUUID1, UUID paramUUID2, UUID paramUUID3) {
//        BluetoothGattCharacteristic localBluetoothGattCharacteristic = getBluetoothGattCharacteristic(getBluetoothGattService(paramBluetoothGatt, paramUUID1), paramUUID2);
//        if ((paramBluetoothGatt != null) && (localBluetoothGattCharacteristic != null)) {
//            paramBluetoothGatt.setCharacteristicNotification(localBluetoothGattCharacteristic, true);
//            BluetoothGattDescriptor localBluetoothGattDescriptor = localBluetoothGattCharacteristic.getDescriptor(paramUUID3);
//            if (localBluetoothGattDescriptor != null) {
//                localBluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
//                paramBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor);
//            }
//            //*************************************************************************************************************
//            return;
//        }
//        do {
//
//            if (paramBluetoothGatt == null) {
//                Log.i(this.TAG, "mBluetoothGatt is null");
//                return;
//            }
//        } while (localBluetoothGattCharacteristic != null);
//        Log.i(this.TAG, "mBluetoothGattCharacteristic is null");
//    }
//
//    public void set_alarm(Context paramContext, int paramInt1, int paramInt2, int paramInt3) {
//        byte[] arrayOfByte = ParserHelper.getAlarmValue(paramContext, paramInt1, paramInt2, paramInt3);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void set_date_time(Context paramContext, Calendar paramCalendar) {
//        byte[] arrayOfByte = ParserHelper.getDateTimeValue(paramCalendar);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void set_day_mode(Context paramContext, int paramInt1, int paramInt2) {
//        byte[] arrayOfByte = ParserHelper.getDayModeValue(paramContext, paramInt1, paramInt2);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void set_language(Context paramContext, int paramInt) {
//        byte[] arrayOfByte = ParserHelper.getLanguageValue(paramContext, paramInt);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void set_lost_mode(Context paramContext, int paramInt) {
//        byte[] arrayOfByte = ParserHelper.getLostModeValue(paramContext, paramInt);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void set_notify_true() {
//        setCharactoristicNotifyAndWriteDescriptor(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_NOTI, Config.UUID_DESCRIPTOR_CONFIGURATION);
//    }
//
//    public void set_outsit(Context paramContext, int paramInt) {
//        byte[] arrayOfByte = ParserHelper.getOutsitValue(paramContext, paramInt);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void set_profile(Context paramContext, double paramDouble1, double paramDouble2, int paramInt) {
//        byte[] arrayOfByte = ParserHelper.getProfileValue(paramContext, paramDouble1, paramDouble2, paramInt);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void set_target(Context paramContext, int paramInt) {
//        byte[] arrayOfByte = ParserHelper.getGoalValue(paramContext, paramInt);
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic) {
//        if ((this.mBluetoothAdapter == null) || (this.mBluetoothGatt == null)) {
//            Log.w(this.TAG, "BluetoothAdapter not initialized");
//            return;
//        }
//        this.mBluetoothGatt.writeCharacteristic(paramBluetoothGattCharacteristic);
//    }

    /**
     *
     * @param paramBluetoothGatt
     * @param paramUUID1
     * @param paramUUID2
     * @param paramArrayOfByte
     */
    public void writeCharacteristic(BluetoothGatt paramBluetoothGatt, UUID paramUUID1, UUID paramUUID2, byte[] paramArrayOfByte) {
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = getBluetoothGattCharacteristic(getBluetoothGattService(paramBluetoothGatt, paramUUID1), paramUUID2);
        if ((paramBluetoothGatt != null) && (localBluetoothGattCharacteristic != null)) {
            localBluetoothGattCharacteristic.setValue(paramArrayOfByte);
            localBluetoothGattCharacteristic.setWriteType(1);
            paramBluetoothGatt.writeCharacteristic(localBluetoothGattCharacteristic);
            //**************************************************************************************************************
            return;
        }
        do {

            if (paramBluetoothGatt == null) {
                Log.i(this.TAG, "mBluetoothGatt is null");
                return;
            }
        } while (localBluetoothGattCharacteristic != null);
        Log.i(this.TAG, "mBluetoothGattCharacteristic is null");
    }

//    public void writeDescriptor(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor) {
//        if ((this.mBluetoothAdapter == null) || (paramBluetoothGatt == null)) {
//            Log.w(this.TAG, "BluetoothAdapter not initialized");
//            return;
//        }
//        paramBluetoothGatt.writeDescriptor(paramBluetoothGattDescriptor);
//    }
//
//    public void write_call_reminder(Context paramContext, String paramString) {
//        byte[] arrayOfByte = ParserHelper.getCallValue(paramContext, paramString);
//        if (arrayOfByte != null) {
//            writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//        }
//    }
//
//    public void write_call_termination(Context paramContext) {
//        byte[] arrayOfByte = ParserHelper.getCallTerminationValue(paramContext);
//        if (arrayOfByte != null) {
//            writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//        }
//    }
//
//    public void write_camera(Context paramContext, int paramInt) {
//        byte[] arrayOfByte = ParserHelper.getCameraValue(paramContext, paramInt);
//        System.out.println(Arrays.toString(arrayOfByte));
//        writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//    }
//
//    public void write_sms_reminder(Context paramContext, String paramString) {
//        byte[] arrayOfByte = ParserHelper.getSMSValue(paramContext, paramString);
//        if (arrayOfByte != null) {
//            writeCharacteristic(this.mBluetoothGatt, Config.UUID_SERVICE, Config.UUID_CHARACTERISTIC_WRITE_AND_READ, arrayOfByte);
//        }
//    }

    public class LocalBinder
            extends Binder {
        public LocalBinder() {
        }

        public BandBLEService getService() {
            return BandBLEService.this;
        }
    }
}