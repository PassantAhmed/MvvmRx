package com.iti.intake39.jad.mvvm_rx_example.screens.additemscreen;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.iti.intake39.jad.mvvm_rx_example.data.domain.AddAnimatedCharacterUseCase;
import com.iti.intake39.jad.mvvm_rx_example.data.model.AnimatedCharacter;

import io.reactivex.subjects.BehaviorSubject;


public class ListItemViewModel extends ViewModel {

    private AddAnimatedCharacterUseCase newCharacter;
    private BehaviorSubject<Boolean> isCharactersUpdated = BehaviorSubject.createDefault(false);

    public ListItemViewModel(){
        newCharacter = new AddAnimatedCharacterUseCase();
    }
    public void addNewCharacter(String characterName, String characterImg){
        isCharactersUpdated.onNext(true);
        addCharacter(characterName, characterImg);
    }

    private void addCharacter(final String characterName, final String characterImg){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                isCharactersUpdated.onNext(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    newCharacter.addAnimatedCharacter(new AnimatedCharacter(characterName,characterImg));
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public BehaviorSubject<Boolean> getIsPlacesUpdating(){
        return isCharactersUpdated;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
