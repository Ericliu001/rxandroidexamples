package kurtis.rx.androidexamples;

import junit.framework.Assert;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by ericliu on 8/2/17.
 */
public class SubscriberObserverBasics {

    private Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(final Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello, world!");
            subscriber.onCompleted();
        }
    });


    Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(final Throwable e) {

        }

        @Override
        public void onNext(final String s) {
            System.out.println(s);
        }
    };


    @Test
    public void testSubscribe() throws Exception {
        myObservable.map(new Func1<String, String>() {
            @Override
            public String call(final String s) {
                return s + " - my signature";
            }
        }).subscribe(mySubscriber);
        Assert.assertTrue(true);
    }
}