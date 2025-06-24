package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public  class GeneratorData {

    static Faker datas = new Faker();

    public static String firstName = datas.name().firstName();
    public static String dates = new SimpleDateFormat("dd/MM/yyyy")
            .format(datas.date().future(2, TimeUnit.DAYS));
    public static String datesPast = new SimpleDateFormat("dd/MM/yyyy")
            .format(datas.date().past(2, TimeUnit.DAYS));
}
