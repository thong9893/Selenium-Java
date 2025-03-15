package support;

import java.io.File;

public class GlobalConstance {
    public static final String SITE_URL = "https://opensource-demo.orangehrmlive.com/";
    public static final String ADMIN_USERNAME = "Admin";
    public static final String ADMIN_PASSWORD = "admin123";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public  static final String SEPARATOR = File.separator;
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR +"uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR +"downloadFiles" + SEPARATOR;
    public static final long LONG_TIMEOUT = 20;
    public static String OS_NAME = System.getProperty("os.name");
}
