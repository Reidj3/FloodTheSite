package ru.reidj.floodthesite.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private Label label;

    @FXML
    private URL location;

    @FXML
    private TextField input;

    @FXML
    private Button button;

    private int attempt = 0;
    private Random random = new Random();
    Map<Integer, String> sites = new HashMap<Integer, String>() {{
        put(random.nextInt(10), "VK.COM!");
        put(random.nextInt(10), "TWITTER.COM!");
        put(random.nextInt(10), "MAIL.RU!");
        put(random.nextInt(10), "PIKABU.RU!");
        put(random.nextInt(10), "REDDIT.COM!");
    }};
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void initialize() {
        try {
            button.setOnAction(event -> {
                attempt++;
                for (Integer keys : sites.keySet()) {
                    if (input.getText().contains(keys.toString())) {
                        label.setText("Вы потопили " + sites.get(keys));
                        sites.remove(keys);
                    }
                }
                if (sites.isEmpty()) {
                    label.setText("Игра окончена! \nВам потребовалось " + attempt + " хода(ов");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
