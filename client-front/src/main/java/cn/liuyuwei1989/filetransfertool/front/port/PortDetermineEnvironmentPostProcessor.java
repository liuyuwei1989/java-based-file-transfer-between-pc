package cn.liuyuwei1989.filetransfertool.front.port;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

public class PortDetermineEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        //MapPropertySource
        Properties properties = new Properties();
        properties.put("server.port", ServerPortUtils.getAvailablePort());
        PropertiesPropertySource source = new PropertiesPropertySource("randomPortProperties", properties);
        environment.getPropertySources().addLast(source);
    }
}
