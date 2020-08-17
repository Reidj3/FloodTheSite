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

        Map<Integer, Sites> sites = new HashMap<Integer, Sites>() {{
            put(random.nextInt(10), new Sites("VK.COM!"));
            put(random.nextInt(10), new Sites("TWITTER.COM!"));
            put(random.nextInt(10), new Sites("MAIL.RU!"));
            put(random.nextInt(10), new Sites("PIKABU.RU!"));
            put(random.nextInt(10), new Sites("REDDIT.COM!"));
        }};

        try {
            while (score != 4) {
                logger.info("Сделайте ход:");
                moves = scanner.nextInt();
                attempt++;

                for (Integer keys : sites.keySet()) {
                    if (moves == keys || sites.isEmpty()) {
                        logger.info("Вы потопили " + sites.get(keys).getName());
                        score++;
                        sites.remove(keys);
                    }
                    if (sites.isEmpty())
                        logger.info("Игра окончена! \nВам потребовалось " + attempt + " хода(ов)");
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("Произошла ошибка! " + e + ". Перезапустите программу");
            main(args);
        }
    }
}
