package cn.liuyuwei1989.filetransfertool.front.controller;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@FXMLController
public class MainPageController {
    @FXML
    private ListView<Application> listView;

    @FXML
    private Button refreshUsersButton;

    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String applicationName;

    @FXML
    private void setupListView() {
        ObservableList<Application> list = FXCollections.observableArrayList();
        Applications applications = eurekaClient.getApplications(applicationName);
        List<Application> registeredApplications = applications.getRegisteredApplications();
        list.addAll(registeredApplications);
        listView.setItems(list);
    }

    @Autowired
    public void setEurekaClient(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }
}
