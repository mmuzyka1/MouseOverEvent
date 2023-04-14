package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ConfigRetriever {

    private static Configuration configuration;

    public static Configuration getConfig() {
        if (configuration == null) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            try {
                File file = new File(Objects.requireNonNull(classLoader.getResource("configuration.yml")).getFile());
                ObjectMapper om = new ObjectMapper(new YAMLFactory());
                configuration = om.readValue(file, Configuration.class);
                return configuration;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configuration;
    }
}
