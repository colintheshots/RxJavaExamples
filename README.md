RxJavaExamples
==============

Several simple examples demonstrating how to use RxJava along with a few exercises to try as seen in the comments. All code here are simple Java examples wrapped up so you can try them in Android Studio's console.

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
