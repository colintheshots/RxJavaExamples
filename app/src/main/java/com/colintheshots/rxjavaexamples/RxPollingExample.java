package com.colintheshots.rxjavaexamples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Rx scheduler polling example.
 *
 * 1. Make the worker and observable end after n number of iterations.
 * 2. Complete if the seconds are equal to :00.
 */
public class RxPollingExample {

    private static final int INITIAL_DELAY = 1000;
    private static final int POLLING_INTERVAL = 1000;
    private static final String DATE_FORMAT = "h:mm:ss a";

    public static void main(String[] args) {
        Observable.create((Subscriber<? super Calendar> subscriber) -> Schedulers.immediate().createWorker()
                .schedulePeriodically(() ->
                        subscriber.onNext(Calendar.getInstance(Locale.US)), INITIAL_DELAY, POLLING_INTERVAL, TimeUnit.MILLISECONDS))
            .take(10)
            .observeOn(Schedulers.io())
            .subscribe(calendar -> {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
                String time = simpleDateFormat.format(calendar.getTime());
                System.out.println(time);
            }, Throwable::printStackTrace);

    }
}
