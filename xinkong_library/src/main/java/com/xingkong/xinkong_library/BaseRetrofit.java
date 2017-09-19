package com.xingkong.xinkong_library;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.xingkong.xinkong_library.app.LogLevel;
import com.xingkong.xinkong_library.convert.CustomGsonConverterFactory;
import com.xingkong.xinkong_library.interceptor.BasicParamsInterceptor;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * BaseRetrofit
 */
public abstract class BaseRetrofit {

    protected Retrofit mRetrofit;
    private static final int DEFAULT_TIME = 10;    //默认超时时间
    private final long RETRY_TIMES = 0;   //重订阅次数

    public BaseRetrofit() {
        //创建okHttpClient
        if (null == mRetrofit) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(DEFAULT_TIME, TimeUnit.SECONDS);
            builder.connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS);

            //设置拦截器
            builder.addInterceptor(new BasicParamsInterceptor.Builder().addParamsMap(getCommonMap()).build());
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(LogLevel.getInstance().getLevel()));
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                           // .addHeader("Accept-Encoding", "gzip, deflate")
                            .addHeader("Connection", "keep-alive")
                            .addHeader("Accept", "*/*")
                            .addHeader("Cookie", "add cookies here")
                            .build();
                    return chain.proceed(request);
                }

            });
            OkHttpClient okHttpClient = builder.build();
            RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "userName=1321&pwd=3213");
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(HttpServletAddress.getInstance().getServletAddress())
                    .client(okHttpClient)
                    .addConverterFactory(CustomGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    //公共参数
    protected abstract Map<String, String> getCommonMap();

    protected <T> void toSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())    // 指定subscribe()发生在IO线程
                .observeOn(AndroidSchedulers.mainThread())  // 指定Subscriber的回调发生在io线程
                .timeout(DEFAULT_TIME, TimeUnit.SECONDS)    //重连间隔时间
                .retry(RETRY_TIMES)
//                .repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(@NonNull Observable<Object> objectObservable) throws Exception {
//                        return null;
//                    }
//                })
                .subscribe(observer);   //订阅
    }

    protected static <T> T getPresent(Class<T> cls) {
        T instance = null;
        try {
            instance = cls.newInstance();
            if (instance == null) {
                return null;
            }
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
           e.printStackTrace();
        }
        return null;
    }
}