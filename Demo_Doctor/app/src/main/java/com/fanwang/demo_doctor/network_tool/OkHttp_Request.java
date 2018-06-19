package com.fanwang.demo_doctor.network_tool;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by edison on 2018/6/19.
 */

public class OkHttp_Request {
    private OkHttpClient okHttpClient;

    public OkHttp_Request() {
        okHttpClient=new OkHttpClient();
    }

    public Observable<String> login(final String url){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Request request = new Request.Builder().url(url).build();
                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            subscriber.onError(e);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (response.isSuccessful()){
                                subscriber.onNext(response.body().string());
                            }
                            subscriber.onCompleted();       //访问结束
                        }
                    });

                }
            }
        });
    }
}
