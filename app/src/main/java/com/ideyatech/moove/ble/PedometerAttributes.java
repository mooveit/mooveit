/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ideyatech.moove.ble;

import android.os.ParcelUuid;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class includes a small subset of standard GATT attributes for demonstration purposes.
 */
public class PedometerAttributes {

    /* Bracelet Services  */
    /* UUID = UNIVERSAL UNIQUE ID */
    private static final String SERVICE01 = "00001800-0000-1000-8000-00805f9b34fb";
    private static final String SERVICE02 = "00001801-0000-1000-8000-00805f9b34fb";
    private static final String SERVICE03 = "0000ffe0-0000-1000-8000-00805f9b34fb";
    private static final String SERVICE04 = "0000fff0-0000-1000-8000-00805f9b34fb";

    public static final ParcelUuid PARCEL_UUID01 = ParcelUuid.fromString("00001800-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid PARCEL_UUID02 = ParcelUuid.fromString("00001801-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid PARCEL_UUID03 = ParcelUuid.fromString("0000ffe0-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid PARCEL_UUID04 = ParcelUuid.fromString("0000fff0-0000-1000-8000-00805f9b34fb");

    private static HashMap<String, String> attributes = new HashMap();
    public static String HEART_RATE_MEASUREMENT = "0000fff0-0000-1000-8000-00805f9b34fb";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";


    static {
        // Bracelet Services.
        attributes.put(SERVICE01, "Service 1");
        attributes.put(SERVICE02, "Service 2");
        attributes.put(SERVICE03, "Service 3");
        attributes.put(SERVICE04, "Service 4");
        // Bracelet Characteristics.
//        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
//        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
    }

    /**
     *
     * @param uuid
     * @param defaultName
     * @return
     */
    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}
