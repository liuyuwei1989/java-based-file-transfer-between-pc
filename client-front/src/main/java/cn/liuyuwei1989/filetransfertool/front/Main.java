package cn.liuyuwei1989.filetransfertool.front;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import cn.liuyuwei1989.filetransfertool.front.view.MainPageView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class Main extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) throws InterruptedException {
        launch(Main.class, MainPageView.class, args);
    }
}
