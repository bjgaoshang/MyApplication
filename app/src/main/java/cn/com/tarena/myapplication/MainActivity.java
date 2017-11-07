package cn.com.tarena.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delete = (Button) findViewById(R.id.deleteId);
    }
    public void onClick(View view) {
        //getAbsolutePath 返回的是一个字符串，这个字符串就是当前File对象的绝对路径名的字符串形式
        String path =
                Environment.getExternalStorageDirectory()//获得外部存储媒体目录
                        .getAbsolutePath() + File.separator + "com.automator.task.test"
                        +File.separator+"log";
        //File.separator 为'\'


        File file = new File(path);
        //file.listFiles 返回某个目录下所有文件和目录的绝对路径，返回的是File数组
        File[] files = file.listFiles();// 读取

        getFileName(files,view);
    }


    private static void getFileName(File[] files, View view) {
        // 先判断目录是否为空，否则会报空指针
        if (files != null) {
            //循环赋值
            for (File file : files) {
                //判断该路径指示的是否是文件
                if (file.isDirectory()) {
                    //file.getName 获取文件的名字
                    //file.getPath 获取路径
                    Log.i("zeng", "若是文件目录。继续读1" + file.getName().toString()
                            + file.getPath().toString());

                    getFileName(file.listFiles(), view);
                    Log.i("zeng", "若是文件目录。继续读2" + file.getName().toString()
                            + file.getPath().toString());
                } else {
                    String fileName = file.getName();
                    //此方法作用是该文件是否已".txt"点缀结尾
                    if (fileName.endsWith(".txt")) {

                        try {
                            HashMap<String, Object> map = new HashMap<String, Object>();
                            String s = fileName.substring(0,
                                    fileName.lastIndexOf(".")).toString();

                            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd-HH-mm");
                            String dateString = format.format(new Date(System.currentTimeMillis()));
                            Date date2 = format.parse(dateString);

                            String ph = Environment.getExternalStorageDirectory()
                                    .getAbsolutePath() +  File.separator + "com.automator.task.test"
                                    +File.separator+"log" + "/" + s.trim() + ".txt";
                            File fe = new File(ph);
                            Log.i("test", ph);


                            Date date1 = format.parse(s.trim());
                            if (DelFile.getBetweenDay(date1, date2) > 7) {
                                fe.delete();
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
