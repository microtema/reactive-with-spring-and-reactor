package de.microtema.reactivespringreactor.observer;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

import java.util.ArrayList;
import java.util.List;

public class ObservableList<T> {

    private final List<T> list;
    private final BehaviorSubject<List<T>> behaviorSubject;

    public ObservableList() {
        this.list = new ArrayList<>();
        this.behaviorSubject = BehaviorSubject.create();
    }

    public Observable<List<T>> getObservable() {
        return behaviorSubject;
    }

    public void add(T element) {
        list.add(element);
        behaviorSubject.onNext(list);
    }
}
