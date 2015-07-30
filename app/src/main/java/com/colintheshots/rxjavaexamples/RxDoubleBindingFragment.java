package com.colintheshots.rxjavaexamples;

import com.google.common.base.Strings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import rx.Subscription;
import rx.subjects.PublishSubject;

/**
 * 1. Use Observable.zip() to make the result not update until both values have changed.
 *
 * 2. Try the same thing using Observable.combineLatest().
 *
 * 3. Subscribe to the result and separately emit that value added to a third EditView's data.
 */


public class RxDoubleBindingFragment
        extends Fragment {

    @Bind(R.id.double_binding_num1) EditText _number1;
    @Bind(R.id.double_binding_num2) EditText _number2;
    @Bind(R.id.double_binding_result) TextView _result;

    Subscription _subscription;
    PublishSubject<Float> _resultEmitterSubject;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_double_binding_textview, container, false);
        ButterKnife.bind(this, layout);

        _resultEmitterSubject = PublishSubject.create();
        _subscription = _resultEmitterSubject.asObservable().subscribe(aFloat -> _result.setText(String.valueOf(aFloat)));

        onNumberChanged();
        _number2.requestFocus();

        return layout;
    }

    @OnTextChanged({ R.id.double_binding_num1, R.id.double_binding_num2 })
    public void onNumberChanged() {
        float num1 = 0;
        float num2 = 0;

        if (!Strings.isNullOrEmpty(_number1.getText().toString())) {
            num1 = Float.parseFloat(_number1.getText().toString());
        }

        if (!Strings.isNullOrEmpty(_number2.getText().toString())) {
            num2 = Float.parseFloat(_number2.getText().toString());
        }

        _resultEmitterSubject.onNext(num1 + num2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (_subscription != null) {
            _subscription.unsubscribe();
        }
    }
}