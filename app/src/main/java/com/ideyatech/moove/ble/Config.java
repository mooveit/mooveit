package com.ideyatech.moove.ble;

import android.annotation.SuppressLint;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Config
{
  public static final int ALARM_OFF = 1;
  public static final int ALARM_ON = 0;
  public static final String[] ARRAY_LANGUAGE = { "绠?浣撲腑鏂?", "English", "绻侀珨涓枃", "Francais", "Italiano", "褉褍褋褋泻懈泄", "Espa帽ol", "Portugu锚s" };
  public static String DEVICE_NAME;
  public static final String KEY_ACTIVITY_DATA = "KEY_ACTIVITY_DATA";
  public static final String KEY_BEACON_ZOON = "KEY_BEACON_ZOON";
  public static final String KEY_COUNT = "KEY_COUNT";
  public static final String KEY_PRESS_KEY = "KEY_PRESS_KEY";
  public static final String KEY_SET_SCREEN = "KEY_SET_SCREEN";
  public static final int REQUEST_ENABLE_BLUETOOTH = 11;
  public static final String TYPE_ACTIVITY_SLEEP = "sleep";
  public static final String TYPE_ACTIVITY_STEP = "step";
  public static final int TYPE_CALORIES = 1;
  public static final int TYPE_CAMERA_END = 1;
  public static final int TYPE_CAMERA_START = 0;
  public static final int TYPE_DATA_CLEAR = 1;
  public static final int TYPE_DATA_COMMUNICATE = 0;
  public static final int TYPE_GENDER_FEMALE = 0;
  public static final int TYPE_GENDER_MALE = 1;
  public static final int TYPE_KEY_LEFT = 2;
  public static final int TYPE_KEY_MIDDLE = 1;
  public static final int TYPE_KEY_RIGHT = 4;
  public static final byte TYPE_LANGUAGE_CHINESE_SIMPLIFIED = 16;
  public static final byte TYPE_LANGUAGE_CHINESE_TRADITIONAL = 17;
  public static final byte TYPE_LANGUAGE_ENGLISH = 1;
  public static final byte TYPE_LANGUAGE_FRENCH = 3;
  public static final byte TYPE_LANGUAGE_ITALIAN = 5;
  public static final byte TYPE_LANGUAGE_PORTUGUESE = 7;
  public static final byte TYPE_LANGUAGE_RUSSIAN = 33;
  public static final byte TYPE_LANGUAGE_SPANISH = 2;
  public static final int TYPE_LOST_MODE_END = 1;
  public static final int TYPE_LOST_MODE_START = 0;
  public static final int TYPE_REMINDER_TIME_BEGIN = 1;
  public static final int TYPE_REMINDER_TIME_END = 2;
  public static final int TYPE_SLEEP = 3;
  public static final int TYPE_STEP = 2;
  public static final UUID UUID_CHARACTERISTIC_NOTI;
  public static final UUID UUID_CHARACTERISTIC_WRITE_AND_READ;
  public static final UUID UUID_DESCRIPTOR_CONFIGURATION;
  public static final UUID UUID_SERVICE;
  public static final DecimalFormat df_1 = new DecimalFormat("00");
  public static final DecimalFormat df_1_1 = new DecimalFormat("0");
  public static final DecimalFormat df_2 = new DecimalFormat("0.0");
  public static final DecimalFormat df_3 = new DecimalFormat("0.00");
  public static final int receive_key_left = 2;
  public static final int receive_key_middle = 1;
  public static final int receive_key_right = 4;
  public static final int receive_success = 0;
  public static final int receive_wrong = 1;
  @SuppressLint({"SimpleDateFormat"})
  public static final SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  @SuppressLint({"SimpleDateFormat"})
  public static final SimpleDateFormat sdf_2 = new SimpleDateFormat("yyyy-MM-dd");
  @SuppressLint({"SimpleDateFormat"})
  public static final SimpleDateFormat sdf_3 = new SimpleDateFormat("yyyy-MM-dd HH");
  public static final int title_ctrl_gsensor = 83;
  public static final int title_ctrl_key = 81;
  public static final int title_ctrl_screen = 80;
  public static final int title_delete_activity = 20;
  public static final int title_get_activity = 19;
  public static final int title_get_activity_count = 16;
  public static final int title_get_mac = 8;
  public static final int title_get_sensor = 96;
  public static final int title_get_sensor_value = 97;
  public static final int title_get_zoon = 65;
  public static final int title_receive_activity = 147;
  public static final int title_receive_activity_count = 144;
  public static final int title_receive_alarm = 131;
  public static final int title_receive_date_time = 129;
  public static final int title_receive_day_mode = 130;
  public static final int title_receive_goal = 139;
  public static final int title_receive_language = 138;
  public static final int title_receive_press_key = 209;
  public static final int title_receive_profile = 140;
  public static final int title_receive_set_screen = 208;
  public static final int title_receive_zoon = 193;
  public static final int title_set_alarm = 3;
  public static final int title_set_beacon_startstop = 67;
  public static final int title_set_body = 12;
  public static final int title_set_callin = 32;
  public static final int title_set_date_time = 1;
  public static final int title_set_day_mode = 2;
  public static final int title_set_hour = 13;
  public static final int title_set_language = 10;
  public static final int title_set_message = 33;
  public static final int title_set_target = 11;
  
  static
  {
    DEVICE_NAME = "Wristband";
    UUID_SERVICE = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
    UUID_CHARACTERISTIC_NOTI = UUID.fromString("0000fff2-0000-1000-8000-00805f9b34fb");
    UUID_CHARACTERISTIC_WRITE_AND_READ = UUID.fromString("0000fff1-0000-1000-8000-00805f9b34fb");
    UUID_DESCRIPTOR_CONFIGURATION = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
  }
}
