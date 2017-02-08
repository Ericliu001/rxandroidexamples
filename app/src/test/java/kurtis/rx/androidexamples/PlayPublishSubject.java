package kurtis.rx.androidexamples;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by ericliu on 8/2/17.
 */

public class PlayPublishSubject {

    private PublishSubject<String> publishSubject = PublishSubject.create();


    private Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(final Throwable e) {

        }

        @Override
        public void onNext(final String s) {
            System.out.print(s);
        }
    };

    private Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(final Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello, world!");
//            subscriber.onCompleted();
        }
    });


    @Test
    public void testPublishSubject() throws Exception {
        publishSubject.subscribe(subscriber);

        publishSubject.onNext("Haha");
        publishSubject.onNext(", ");
        publishSubject.onNext("hello ");
        publishSubject.onNext("world! ");
    }


    @Test
    public void testSubjectAsSubscriberAndObservarableAtTheSameTime() throws Exception {
        publishSubject.subscribe(subscriber);
        myObservable.subscribe(publishSubject);
    }
}
