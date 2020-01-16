package holapepino.extentreport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    public String getReportConfigPath() throws IOException {
        Properties properties = new Properties();
        String propFileName = "holapepino/config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if(inputStream != null){
            properties.load(inputStream);
        }else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath != null){
            return reportConfigPath;
        }else throw new RuntimeException("Report Config Path not specified in the config.properties");
    }
}
