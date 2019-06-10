package com.iti.intake39.jad.mvvm_rx_example.data.domain;

import com.iti.intake39.jad.mvvm_rx_example.data.AnimatedCharacterRepo;
import com.iti.intake39.jad.mvvm_rx_example.data.AnimatedCharacterRepoImpl;
import com.iti.intake39.jad.mvvm_rx_example.data.model.AnimatedCharacter;

import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class SelectAllCharactersUseCase {

    private AnimatedCharacterRepo animatedCharacterRepo;

    public SelectAllCharactersUseCase(){
     animatedCharacterRepo = AnimatedCharacterRepoImpl.getInstance();
    }

    public BehaviorSubject<List<AnimatedCharacter>> getAllAnimatedCharacters(){
        return animatedCharacterRepo.getCharacters();
    }
}
