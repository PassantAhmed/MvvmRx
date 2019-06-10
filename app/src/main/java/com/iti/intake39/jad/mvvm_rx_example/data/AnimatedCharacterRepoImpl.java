package com.iti.intake39.jad.mvvm_rx_example.data;

import com.iti.intake39.jad.mvvm_rx_example.data.model.AnimatedCharacter;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.subjects.BehaviorSubject;

public class AnimatedCharacterRepoImpl implements AnimatedCharacterRepo {
    private static AnimatedCharacterRepoImpl animatedCharacterRepoInstance;
    private ArrayList<AnimatedCharacter> characters = new ArrayList<>();
    BehaviorSubject<List<AnimatedCharacter>> listObservable = BehaviorSubject.createDefault(characters);

    private AnimatedCharacterRepoImpl() {
        setCharacters();
    }

    private void setCharacters(){
        characters.add(
                new AnimatedCharacter("Mickey Mouse",
                        "https://upload.wikimedia.org/wikipedia/en/thumb/d/d4/Mickey_Mouse.png/220px-Mickey_Mouse.png")
        );

        characters.add(
                new AnimatedCharacter("Minnie Mouse",
                        "https://images.homedepot-static.com/productImages/d8a8d24a-7866-465c-829e-194c9ab87a24/svn/blue-roommates-wall-decals-rmk1509gm-64_1000.jpg")
        );

        characters.add(
                new AnimatedCharacter("Pooh Bear",
                        "https://o.aolcdn.com/images/dims3/GLOB/crop/467x307+84+62/resize/1028x675!/format/jpg/quality/85/http%3A%2F%2Fo.aolcdn.com%2Fhss%2Fstorage%2Fmidas%2Fff694e42b01b9dfc8b861968e83cc703%2F206571774%2FScreen%2BShot%2B2018-08-03%2Bat%2B3.59.39%2BPM.png")
        );

        characters.add(
                new AnimatedCharacter("Tweety",
                        "https://img2.freepng.es/20180404/uve/kisspng-tweety-drawing-looney-tunes-cartoon-images-5ac542d745d818.3517052315228771432861.jpg")
        );
    }

    public static AnimatedCharacterRepoImpl getInstance(){
        if(animatedCharacterRepoInstance==null){
            synchronized (AnimatedCharacterRepoImpl.class) {
                if(animatedCharacterRepoInstance==null) {
                    animatedCharacterRepoInstance = new AnimatedCharacterRepoImpl();
                }
            }
        }
        return animatedCharacterRepoInstance;
    }

    @Override
    public BehaviorSubject<List<AnimatedCharacter>> getCharacters(){
        return listObservable;
    }

    @Override
    public void addCharacter(AnimatedCharacter animatedCharacter){
        characters.add(animatedCharacter);
        listObservable.onNext(characters);
    }

}
