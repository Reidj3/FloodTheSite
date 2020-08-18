package ru.reidj.floodthesite;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int score = 0;
        int attempt = 0;
        int moves;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Logger logger = LoggerFactory.getLogger(Main.class);

        Map<Integer, String> sites = new HashMap<Integer, String>() {{
            put(random.nextInt(10), "VK.COM!");
            put(random.nextInt(10), "TWITTER.COM!");
            put(random.nextInt(10), "MAIL.RU!");
            put(random.nextInt(10), "PIKABU.RU!");
            put(random.nextInt(10), "REDDIT.COM!");
        }};

        try {
            while (score != 4) {
                logger.info("Сделайте ход:");
                moves = scanner.nextInt();
                attempt++;

                for (Integer keys : sites.keySet()) {
                    if (moves == keys) {
                        logger.info("Вы потопили " + sites.get(keys));
                        score++;
                        sites.remove(keys);
                    }
                    if (sites.isEmpty())
                        logger.info("Игра окончена! \nВам потребовалось " + attempt + " хода(ов)");
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("Произошла ошибка! " + e + ". Перезапуск программы");
            main(args);
        }
    }
}
