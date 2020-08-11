package ru.reidj.floodthesite;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Sites {
    VKCOM("VK.COM!", new ArrayList<>(Arrays.asList(
            (int) (Math.random() * 10),
            (int) (Math.random() * 5),
            (int) (Math.random() * 7)
    ))),
    MAILRU("MAIL.RU!", new ArrayList<>(Arrays.asList(
            (int) (Math.random() * 8),
            (int) (Math.random() * 11),
            (int) (Math.random() * 9)
    ))),
    TWITTER("TWITTER.COM!", new ArrayList<>(Arrays.asList(
            (int) (Math.random() * 13),
            (int) (Math.random() * 12),
            (int) (Math.random() * 10)
    )))
    ;

    private String name;
    private ArrayList<Integer> numList;
}
