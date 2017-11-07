package cn.com.tarena.myapplication;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;


public class DelFile {
//    static ArrayList<Object> name =new ArrayList<Object>();

            public static int getBetweenDay(Date date1, Date date2) {
                Calendar d1 = new GregorianCalendar();
                d1.setTime(date1);
                Calendar d2 = new GregorianCalendar();
                d2.setTime(date2);
                int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
                System.out.println("days=" + days);
                int y2 = d2.get(Calendar.YEAR);
                if (d1.get(Calendar.YEAR) != y2) {
                do {
                    days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                    d1.add(Calendar.YEAR, 1);
                } while (d1.get(Calendar.YEAR) != y2);
            }
         return days;
    }
}