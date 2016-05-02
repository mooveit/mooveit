package com.ideyatech.moove.ble;

import android.content.Context;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class ParserHelper
{
    public static final int DEFAULT_ALARM_HOUR = 0;
    public static final int DEFAULT_ALARM_MINUTE = 0;
    public static final int DEFAULT_ALARM_REPEAT = 0;
    public static final int DEFAULT_DAY_TIME_BEGIN = 9;
    public static final int DEFAULT_DAY_TIME_END = 21;
    public static final int DEFAULT_GENDER = 1;
    public static final int DEFAULT_GOAL = 10000;
    public static final int DEFAULT_GOAL_BURN = 100;
    public static final double DEFAULT_GOAL_SLEEP = 8.0D;
    public static final int DEFAULT_GOAL_STEP = 2000;
    public static final double DEFAULT_HEIGHT = 175.0D;
    public static final double DEFAULT_STEP_DISTANCE = 78.75D;
    public static final double DEFAULT_WEIGHT = 70.0D;
    private static final int STEP_SLEEP_BOUNDARY = 65280;

    private static String byteToBinaryString(int paramInt)
    {
        String str = Integer.toBinaryString(paramInt);
        int i = 0;
        if (str != null)
        {
            i = str.length();
            if (i >= 8) {}
        }
        for (int j = 0;; j++)
        {
            if (j >= 8 - i) {
                return str;
            }
            str = "0" + str;
        }
    }

    public static byte getASCIIValue(int paramInt)
    {
        switch (paramInt)
        {
            default:
                return 48;
            case 1:
                return 49;
            case 2:
                return 50;
            case 3:
                return 51;
            case 4:
                return 52;
            case 5:
                return 53;
            case 6:
                return 54;
            case 7:
                return 55;
            case 8:
                return 56;
            case 9:
                return 57;
        }

    }

    /**
     *
     * @param paramContext
     * @return
     */
    public static byte[] getActivityCountValue(Context paramContext)
    {
        byte[] arrayOfByte = new byte[20];
        arrayOfByte[0] = 16;
        return arrayOfByte;
    }

    /**
     *
     * @param paramContext
     * @param paramInt1
     * @param paramInt2
     * @return
     */
    public static byte[] getActivityValue(Context paramContext, int paramInt1, int paramInt2)
    {
        byte[] arrayOfByte = new byte[20];
        arrayOfByte[0] = 19;
        arrayOfByte[1] = ((byte)paramInt1);
        arrayOfByte[2] = ((byte)paramInt2);
        return arrayOfByte;
    }

    /**
     *
     * @param paramContext
     * @param paramInt1
     * @param paramInt2
     * @param paramInt3
     * @return
     */
    public static byte[] getAlarmValue(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
        byte[] arrayOfByte = new byte[20];
        arrayOfByte[0] = 3;
        arrayOfByte[1] = ((byte)paramInt1);
        arrayOfByte[2] = ((byte)paramInt2);
        arrayOfByte[3] = ((byte)paramInt3);
        return arrayOfByte;
    }

    /**
     *
     * @param paramByte
     * @return
     */
    public static byte[] getBooleanArray(byte paramByte)
    {
        byte[] arrayOfByte = new byte[8];
        for (int i = 7;; i--)
        {
            if (i < 0) {
                return arrayOfByte;
            }
            arrayOfByte[i] = ((byte)(paramByte & 0x1));
            paramByte = (byte)(paramByte >> 1);
        }
    }

    /**
     *
     * @param paramByte
     * @return
     */
    public static int getByteValue(byte paramByte)
    {
        return paramByte & 0xFF;
    }

    /**
     *
     * @param paramContext
     * @return
     */
    public static byte[] getCallTerminationValue(Context paramContext)
    {
        byte[] arrayOfByte = new byte[20];
        arrayOfByte[0] = 32;
        arrayOfByte[1] = 1;
        return arrayOfByte;
    }

    /**
     *
     * @param paramContext
     * @param paramString
     * @return
     */
    public static byte[] getCallValue(Context paramContext, String paramString)
    {
        String str = phoneNumberFilter(paramString);
        System.out.println("number = " + str);
        if (str != null)
        {
            byte[] arrayOfByte = new byte[20];
            arrayOfByte[0] = 32;
            arrayOfByte[1] = 0;
            arrayOfByte[2] = ((byte)str.length());
            char[] arrayOfChar = str.toCharArray();
            for (int i = 0;; i++)
            {
                if (i >= arrayOfChar.length) {
                    return arrayOfByte;
                }
                arrayOfByte[(i + 3)] = getASCIIValue(Integer.parseInt(str.substring(i, i + 1)));
            }
        }
        return null;
    }

    /**
     *
     * @param paramContext
     * @param paramInt
     * @return
     */
    public static byte[] getCameraValue(Context paramContext, int paramInt)
    {
        byte[] arrayOfByte = new byte[20];
        arrayOfByte[0] = 80;
        arrayOfByte[1] = 1;
        if (paramInt == 0) {
            arrayOfByte[2] = 81;
        }
        while (paramInt != 1) {
            return arrayOfByte;
        }
        arrayOfByte[2] = 80;
        return arrayOfByte;
    }

    /**
     *
     * @param paramCalendar
     * @return
     */
    public static byte[] getDateTimeValue(Calendar paramCalendar)
    {
        byte[] arrayOfByte = new byte[20];
        int i = paramCalendar.get(Calendar.YEAR);
        int j = Calendar.YEAR + paramCalendar.get(Calendar.MONTH);
        int k = paramCalendar.get(Calendar.DAY_OF_MONTH);
        int m = paramCalendar.get(Calendar.HOUR_OF_DAY);
        int n = paramCalendar.get(Calendar.MINUTE);
        int i1 = paramCalendar.get(Calendar.SECOND);
        arrayOfByte[0] = 1;
        arrayOfByte[1] = ((byte)(i / 100));
        arrayOfByte[2] = ((byte)(i % 100));
        arrayOfByte[3] = ((byte)j);
        arrayOfByte[4] = ((byte)k);
        arrayOfByte[5] = ((byte)m);
        arrayOfByte[6] = ((byte)n);
        arrayOfByte[7] = ((byte)i1);
        return arrayOfByte;
    }

    /**
     *
     * @param paramContext
     * @param paramInt1
     * @param paramInt2
     * @return
     */
    public static byte[] getDayModeValue(Context paramContext, int paramInt1, int paramInt2)
    {
        byte[] arrayOfByte = new byte[20];
        arrayOfByte[0] = 2;
        arrayOfByte[1] = ((byte)paramInt1);
        arrayOfByte[2] = ((byte)paramInt2);
        return arrayOfByte;
    }

//    /**
//     *
//     * @param paramContext
//     * @param paramInt
//     * @return
//     */
//    public static byte[] getGoalValue(Context paramContext, int paramInt)
//    {
//        byte[] arrayOfByte = new byte[20];
//        String str1 = Integer.toBinaryString(paramInt);
//        int i = 0;
//        if (str1 != null)
//        {
//            i = str1.length();
//            if (i >= 16) {}
//        }
//        for (int j = 0;; j++)
//        {
//            if (j >= 16 - i)
//            {
//                String str2 = str1.substring(0, 8);
//                String str3 = str1.substring(8, 16);
//                arrayOfByte[0] = 11;
//                arrayOfByte[1] = 1;
//                arrayOfByte[2] = ((byte)Integer.parseInt(str2, 2));
//                arrayOfByte[3] = ((byte)Integer.parseInt(str3, 2));
//                return arrayOfByte;
//            }
//            str1 = "0" + str1;
//        }
//    }
//
//    /**
//     *
//     * @param paramContext
//     * @param paramInt
//     * @return
//     */
//    public static byte[] getLanguageValue(Context paramContext, int paramInt)
//    {
//        byte[] arrayOfByte = new byte[20];
//        arrayOfByte[0] = 10;
//        arrayOfByte[1] = 1;
//        arrayOfByte[2] = ((byte)paramInt);
//        return arrayOfByte;
//    }
//
//    /**
//     *
//     * @param paramContext
//     * @param paramInt
//     * @return
//     */
//    public static byte[] getLostModeValue(Context paramContext, int paramInt)
//    {
//        byte[] arrayOfByte = new byte[20];
//        arrayOfByte[0] = 67;
//        if (paramInt == 0) {
//            arrayOfByte[1] = 1;
//        }
//        while (paramInt != 1) {
//            return arrayOfByte;
//        }
//        arrayOfByte[1] = 0;
//        return arrayOfByte;
//    }
//
//    /**
//     *
//     * @param paramContext
//     * @param paramInt
//     * @return
//     */
//    public static byte[] getOutsitValue(Context paramContext, int paramInt)
//    {
//        byte[] arrayOfByte = new byte[20];
//        arrayOfByte[0] = 112;
//        arrayOfByte[1] = ((byte)(paramInt & 0xFF));
//        return arrayOfByte;
//    }
//
//    /**
//     *
//     * @param paramContext
//     * @param paramDouble1
//     * @param paramDouble2
//     * @param paramInt
//     * @return
//     */
//    public static byte[] getProfileValue(Context paramContext, double paramDouble1, double paramDouble2, int paramInt)
//    {
//        byte[] arrayOfByte = new byte[20];
//        arrayOfByte[0] = 12;
//        arrayOfByte[1] = ((byte)(int)paramDouble1);
//        arrayOfByte[2] = ((byte)(int)paramDouble2);
//        arrayOfByte[3] = ((byte)paramInt);
//        return arrayOfByte;
//    }
//
//    public static String getRepeatDateBinary(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
//    {
//        StringBuffer localStringBuffer = new StringBuffer();
//        localStringBuffer.append("0");
//        if (paramInt7 == 0)
//        {
//            localStringBuffer.append(1);
//            if (paramInt6 != 0) {
//                break label113;
//            }
//            localStringBuffer.append(1);
//            label41:
//            if (paramInt5 != 0) {
//                break label123;
//            }
//            localStringBuffer.append(1);
//            label53:
//            if (paramInt4 != 0) {
//                break label133;
//            }
//            localStringBuffer.append(1);
//            label64:
//            if (paramInt3 != 0) {
//                break label143;
//            }
//            localStringBuffer.append(1);
//            label75:
//            if (paramInt2 != 0) {
//                break label153;
//            }
//            localStringBuffer.append(1);
//            label86:
//            if (paramInt1 != 0) {
//                break label163;
//            }
//            localStringBuffer.append(1);
//        }
//        for (;;)
//        {
//            return localStringBuffer.toString();
//            localStringBuffer.append(0);
//            break;
//            label113:
//            localStringBuffer.append(0);
//            break label41;
//            label123:
//            localStringBuffer.append(0);
//            break label53;
//            label133:
//            localStringBuffer.append(0);
//            break label64;
//            label143:
//            localStringBuffer.append(0);
//            break label75;
//            label153:
//            localStringBuffer.append(0);
//            break label86;
//            label163:
//            localStringBuffer.append(0);
//        }
//    }
//    /**
//     *
//     * @param paramContext
//     * @return
//     */
//    public static byte[] getSensorType(Context paramContext)
//    {
//        byte[] arrayOfByte = new byte[20];
//        arrayOfByte[0] = 96;
//        return arrayOfByte;
//    }
//
//    /**
//     *
//     * @param paramContext
//     * @param paramByte
//     * @return
//     */
//    public static byte[] getSensorValue(Context paramContext, byte paramByte)
//    {
//        byte[] arrayOfByte = new byte[20];
//        arrayOfByte[0] = 97;
//        arrayOfByte[1] = paramByte;
//        return arrayOfByte;
//    }
//
//    /**
//     *
//     * @param paramContext
//     * @return
//     */
//    public static byte[] getZoonValue(Context paramContext)
//    {
//        byte[] arrayOfByte = new byte[20];
//        arrayOfByte[0] = 65;
//        arrayOfByte[1] = 0;
//        return arrayOfByte;
//    }

//    /**
//     *
//     * @param paramArrayOfByte
//     * @return
//     */
//    public static ArrayList<ActivityData> parseActivity(byte[] paramArrayOfByte)
//    {
//        ArrayList localArrayList = null;
//        int[] arrayOfInt = new int[20];
//        int i = 0;
//        int m = 0;
//        int n = 0;
//        int i1 = 0;
//        int i2 = 0;
//        int i3 = 0;
//
//        if (i >= 20){
//
//            int index1 = arrayOfInt[1];
//            localArrayList = null;
//            if (index1 != 255) {
//
//                int index2 = arrayOfInt[2];
//                localArrayList = null;
//
//                if (index2 != 255) {
//
//                    localArrayList = new ArrayList();
//                    m = 100 * arrayOfInt[1] + arrayOfInt[2];
//                    n = arrayOfInt[3];
//                    i1 = arrayOfInt[4];
//                    i2 = arrayOfInt[5];
//                    i3 = 0;
//                    if (i3 < 6) {
//                        break label123;
//                    }
//                }
//            }
//            return localArrayList;
//        }
//        else {
//            if (paramArrayOfByte[i] >= 0) {
//                arrayOfInt[i] = paramArrayOfByte[i];
//            }
//            for (;;)
//            {
//                i++;
//                break;
//                arrayOfInt[i] = (256 + paramArrayOfByte[i]);
//            }
//        }
//
//        int i4 = 6 + i3 * 2;
//        int i5 = 7 + i3 * 2;
//        int i6 = Integer.parseInt(byteToBinaryString(arrayOfInt[i4]) + byteToBinaryString(arrayOfInt[i5]), 2);
//        ActivityData localActivityData = new ActivityData();
//        localActivityData.setYear(m);
//        localActivityData.setMonth(n);
//        localActivityData.setDay(i1);
//        localActivityData.setHour(i2 + i3);
//        if (i6 < 65280)
//        {
//            localActivityData.setActivityValue(i6);
//            localActivityData.setActivityType("step");
//        }
//        for (;;)
//        {
//            localArrayList.add(localActivityData);
//            i3++;
//            break;
//            if (i6 > 65280)
//            {
//                localActivityData.setActivityValue(i6 - 65280);
//                localActivityData.setActivityType("sleep");
//            }
//        }
//    }

    /**
     *
     * @param paramArrayOfByte
     * @return
     */
    public static int parseActivityCount(byte[] paramArrayOfByte)
    {
        int[] arrayOfInt = new int[20];
        int i = 0;
        if (i >= 20) {
            return arrayOfInt[2];
        }
        if (paramArrayOfByte[i] >= 0) {
            arrayOfInt[i] = paramArrayOfByte[i];
        }
        for (;;)
        {
            i++;
            arrayOfInt[i] = (256 + paramArrayOfByte[i]);
            break;
        }
        return 0;
    }

//    /**
//     *
//     * @param paramArrayOfByte
//     * @return
//     */
//    public static String parseActivityDate(byte[] paramArrayOfByte)
//    {
//        System.out.println(Arrays.toString(paramArrayOfByte));
//        int[] arrayOfInt = new int[20];
//        int i = 0;
//        if (i >= 20)
//        {
//            int j = arrayOfInt[1];
//            String str = null;
//            if (j != 255)
//            {
//                int k = arrayOfInt[2];
//                str = null;
//                if (k != 255)
//                {
//                    int m = 100 * arrayOfInt[1] + arrayOfInt[2];
//                    int n = arrayOfInt[3];
//                    int i1 = arrayOfInt[4];
//                    int i2 = arrayOfInt[5];
//                    str = m + "-" + Config.df_1.format(n) + "-" + Config.df_1.format(i1) + " " + i2;
//                }
//            }
//            return str;
//        }
//        if (paramArrayOfByte[i] >= 0) {
//            arrayOfInt[i] = paramArrayOfByte[i];
//        }
//        for (;;)
//        {
//            i++;
//            break;
//            arrayOfInt[i] = (256 + paramArrayOfByte[i]);
//        }
//    }
//
//    /**
//     *
//     * @param paramArrayOfByte
//     * @return
//     */
//    public static int parseActivitySn(byte[] paramArrayOfByte)
//    {
//        int[] arrayOfInt = new int[20];
//        int i = 0;
//        if (i >= 20)
//        {
//            int j = arrayOfInt[1];
//            int k = 100 * arrayOfInt[3] + arrayOfInt[4];
//            int m = arrayOfInt[5];
//            int n = arrayOfInt[6];
//            System.out.println("sn:" + j + "\n" + "date:" + k + "-" + m + "-" + n);
//            return j;
//        }
//        if (paramArrayOfByte[i] >= 0) {
//            arrayOfInt[i] = paramArrayOfByte[i];
//        }
//        for (;;)
//        {
//            i++;
//            break;
//            arrayOfInt[i] = (256 + paramArrayOfByte[i]);
//        }
//    }

    /**
     *
     * @param paramArrayOfByte
     * @return
     */
    public static String parseZoon(byte[] paramArrayOfByte)
    {
        int[] arrayOfInt = new int[20];
        int i = 0;
        StringBuffer localStringBuffer = null;
        if (i >= 20) {
            localStringBuffer = new StringBuffer();
        }
        for (int j = 2;; j++)
        {
            if (j >= 6)
            {
                localStringBuffer.toString().toUpperCase(Locale.ENGLISH);
                if (paramArrayOfByte[i] >= 0) {
                    arrayOfInt[i] = paramArrayOfByte[i];
                }
                for (;;)
                {
                    i++;

                    arrayOfInt[i] = (256 + paramArrayOfByte[i]);
                    break;
                }
            }
            String str = Integer.toHexString(arrayOfInt[j]);
            if (str.length() == 1) {
                str = "0" + str;
            }
            localStringBuffer.append(str);
        }
    }

    /**
     *
     * @param paramString
     * @return
     */
    public static String phoneNumberFilter(String paramString)
    {
        if ((paramString != null) && (!paramString.equals("")))
        {
            StringBuffer localStringBuffer = new StringBuffer();
            char[] arrayOfChar = paramString.toCharArray();
            int i = arrayOfChar.length;
            for (int j = 0;; j++)
            {
                if (j >= i)
                {
                    if (!localStringBuffer.substring(0, 2).equalsIgnoreCase("86")) {
                        break;
                    }
                    return localStringBuffer.toString().substring(2);
                }
                char c = arrayOfChar[j];
                if (Character.isDigit(c)) {
                    localStringBuffer.append(c);
                }
            }
            return localStringBuffer.toString();
        }
        return null;
    }
}
