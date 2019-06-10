package com.iti.intake39.jad.mvvm_rx_example.data.domain;

import com.iti.intake39.jad.mvvm_rx_example.data.AnimatedCharacterRepo;
import com.iti.intake39.jad.mvvm_rx_example.data.AnimatedCharacterRepoImpl;
import com.iti.intake39.jad.mvvm_rx_example.data.model.AnimatedCharacter;

public class AddAnimatedCharacterUseCase {
    private AnimatedCharacterRepo animatedCharacterRepo;

    public AddAnimatedCharacterUseCase(){
        animatedCharacterRepo = AnimatedCharacterRepoImpl.getInstance();
    }

    public void addAnimatedCharacter(AnimatedCharacter character){
        animatedCharacterRepo.addCharacter(character);
    }
}
