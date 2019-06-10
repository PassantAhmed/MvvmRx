package com.iti.intake39.jad.mvvm_rx_example.data;


import com.iti.intake39.jad.mvvm_rx_example.data.model.AnimatedCharacter;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public interface AnimatedCharacterRepo {
    BehaviorSubject<List<AnimatedCharacter>> getCharacters();
    void addCharacter(AnimatedCharacter animatedCharacter);
}
