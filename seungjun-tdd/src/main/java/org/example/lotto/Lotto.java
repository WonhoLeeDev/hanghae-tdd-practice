package org.example.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create() {
        List<Number> lottos = new ArrayList<>();
        for (int i = 1; i < 46; i += 1) {
            lottos.add(new Number(i));
        }

        Collections.shuffle(lottos, new Random());
        lottos = lottos.subList(0, 6);
        return new Lotto(lottos);
    }

    public int size() {
        return numbers.size();
    }

    public List<Number> getLottoNumbers() {
        return new ArrayList<>(numbers);
    }
}
