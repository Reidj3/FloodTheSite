package ru.reidj.floodthesite.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.reidj.floodthesite.Main;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Controller {
    @FXML
    private TextField textField;

    @FXML
    private Label label;

    @FXML
    private Button button;

    private int attempt = 0;
    private Main main = new Main();
    private Random random = new Random();
    private ConcurrentHashMap<Integer, String> sites = new ConcurrentHashMap<Integer, String>() {{
        put(random.nextInt(12), "VK.COM!");
        put(random.nextInt(13), "TWITTER.COM!");
        put(random.nextInt(11), "MAIL.RU!");
        put(random.nextInt(8), "PIKABU.RU!");
        put(random.nextInt(9), "REDDIT.COM!");
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
                    if (textField.getText().contains(keys.toString())) {
                        label.setText("Вы потопили " + sites.get(keys));
                        System.out.println("" + sites.get(keys));
                        sites.remove(keys);
                    }
                }
                if (sites.isEmpty()) {
                    label.setText("Игра окончена! \nВам потребовалось " + attempt + " ходов");
                    button.setText("Сыграть снова");
                    button.setOnAction(restart -> {
                        try {
                            main.start(stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
