package com.colintheshots.rxjavaexamples;

import java.math.BigInteger;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by colin.lee on 10/12/14.
 */
public class RxBigIntegerFibonacci {

    /**
     * This Java main method calls our Fibonacci function and subscribes to the cold Observable, making it hot.
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Use this online documentation:
         *  https://github.com/ReactiveX/RxJava/wiki/Filtering-Observables
         *
         * Try the following Rx tricks:
         *
         *  1. takeLast() the last 2 results.
         *  2. elementAt() to obtain value #567.
         *  3. take() the first 10 results.
         *  4. Do #3 and also filter() only values divisible by two.
         *
         *      Keep in mind that order of operations matters!
         *      Use bigInteger.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO) to test for even values.
         *
         * Use this online documentation:
         *  https://github.com/ReactiveX/RxJava/wiki/Transforming-Observables
         *
         *  5. Use map() to convert from BigInteger values to Long values and take only the first 50 results.
         */
        rxFibN(100).subscribe(System.out::println);
    }

    private static Observable<BigInteger> rxFibN(final int n) {
        return Observable.create((Subscriber<? super BigInteger> subscriber) -> {
            try {
                BigInteger[] n1 = {BigInteger.ZERO, BigInteger.ONE};
                for (int i = 1; i < n; i++) {
                    n1 = new BigInteger[]{n1[1], n1[1].add(n1[0])};
                    subscriber.onNext(n1[1]);
                }
                subscriber.onCompleted();
            } catch (Exception e) {
                subscriber.onError(e); // this happens by default
            }
        });
    }
}
