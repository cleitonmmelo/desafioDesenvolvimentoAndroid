package cleiton.example.com.brazukas;

import android.app.Application;

import java.util.Properties;


public class BrazukasApp extends Application{

    private static BrazukasApp instance;
    private static Properties props;
    public static BrazukasApp getInstance() { return instance; }



    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
