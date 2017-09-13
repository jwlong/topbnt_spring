package tasktest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by longjinwen on 2017/3/22.
 */
public class MainTest {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 18:00:00");
        Calendar c = Calendar.getInstance();
        c.get(Calendar.YEAR);
        c.get(Calendar.MONTH);
        c.get(Calendar.DAY_OF_MONTH);
        String res = sdf1.format(c.getTime());
        System.out.println(res);
       // timer.schedule(new PrintTask(),1000,2000);
        System.out.println(sdf.parse(res));
        Date time = sdf.parse(sdf1.format(c.getTime()));
        timer.schedule(new PrintTask(),time);
    }
}
