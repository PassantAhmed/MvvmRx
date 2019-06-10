package com.iti.intake39.jad.mvvm_rx_example.screens.listscreen;

import android.arch.lifecycle.ViewModel;
import com.iti.intake39.jad.mvvm_rx_example.data.domain.SelectAllCharactersUseCase;
import com.iti.intake39.jad.mvvm_rx_example.data.model.AnimatedCharacter;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;


public class ListViewModel extends ViewModel {
    private BehaviorSubject<List<AnimatedCharacter>> characters;
    private SelectAllCharactersUseCase allCharacters;

    public ListViewModel(){
            allCharacters = new SelectAllCharactersUseCase();
            characters = allCharacters.getAllAnimatedCharacters();

    }

    public BehaviorSubject<List<AnimatedCharacter>> getCharacters(){
        return characters;
    }

}
