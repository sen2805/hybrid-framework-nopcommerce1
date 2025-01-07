package commons;

import java.io.File;

public class GlobalConstants {
    //System Info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");

    //App info User
    public static final String  DEV_USER_URL ="http://localhost/";
    public static final String  STAGING_USER_URL ="";
    public static final String  LIVE_USER_URL ="";

    // App info Admin
    public static final String DEV_ADMIN_URL="http://localhost/login?ReturnUrl=%2Fadmin";
    public static final String STAGING_ADMIN_URL="";
    public static final String LIVE_ADMIN_URL="";

    public static final String ADMIN_USERNAME ="phamsen2805@gmail.com";
    public static final String ADMIN_PASSWORD ="123456";

    //Wait infor
    public static final long SHORT_TIMEOUT =10;
    public static final long LONG_TIMEOUT =20;

    //Download Upload File
    public static final  String UPLOAD_PATH = PROJECT_PATH +  SEPARATOR + "uploadFiles" +  SEPARATOR ;
    public static final  String DOWNLOAD_PATH = PROJECT_PATH +  SEPARATOR + "downloadFiles" +  SEPARATOR ;
  // public static final String SEPARATOR = File.separator;


    //Retry Case Failed
    public static final int RETRY_NUMBER =3;

    //Browser Logs/Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" +  SEPARATOR ;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH +  SEPARATOR + "browserExtensions" +  SEPARATOR;


    //HTML Report Folder
    public static  final  String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" +  SEPARATOR;
    public static final  String EXTENT_PATH = PROJECT_PATH + SEPARATOR +  "htmlExtent" +  SEPARATOR;
    public static final  String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" +  SEPARATOR;


    //Data Test/Environment
    public static final  String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" +  SEPARATOR;
    public static final String  ENVIRONMENT_CONFIG_PATH = PROJECT_PATH +  SEPARATOR + "environmentConfig" +  SEPARATOR;

}
