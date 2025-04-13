package xlab.java.fundamentals.configuration;

import org.learning.logging.log4j2.LogUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

/**
 * @author CodeKing
 */
public class ConfigurationApp {
  public static void main(String[] args) throws IOException {
    LogUtils.info("Hello Java Configuration!");

    loadConfig();
  }

  private static void loadConfig() throws IOException {
    final File configFile = new File(ClassLoader.getSystemResource("config.properties").getFile());

    final Properties properties = new Properties();
    try (final InputStream inputStream =
           Files.newInputStream(configFile.toPath())) {

      properties.load(inputStream);
    }

    for (String key : properties.stringPropertyNames()) {
      LogUtils.info("{}:{}", key, properties.getProperty(key));
    }
  }
}
