/**
 * BaseActivity 2017-07-02
 * Copyright(c)2017 huangxunlei Co.Ltd. All right reserved
 */
package com.xingkong.xinkongtools.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.xingkong.xinkong_library.callback.BaseImpl;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * class description here
 *
 * @author huangxunlei
 * @version 1.0.0
 * @since 2017-07-02 22:38
 */
public abstract class BaseActivity<PRESENTER extends BasePresenter> extends FragmentActivity implements BaseImpl {
    private CompositeDisposable mCompositeDisposable;
    protected PRESENTER mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        setContentView(layoutRes());
        initView();
    }

    protected abstract int layoutRes();

    protected PRESENTER createPresenter() {
        return null;
    }

    protected abstract void initView();

    @Override
    public boolean addDisposable(Disposable disposable) {
        if (null != mCompositeDisposable) {
            mCompositeDisposable.add(disposable);
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mCompositeDisposable) {
            mCompositeDisposable.clear();
        }
        if (null != mPresenter) {
            mPresenter.detachView();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
