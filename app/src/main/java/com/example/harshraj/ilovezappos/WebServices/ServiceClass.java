package com.example.harshraj.ilovezappos.WebServices;

import com.example.harshraj.ilovezappos.Constants.HTTPConstants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshraj on 08-02-2017.
 */
public class ServiceClass {
    static WebServices webServices;

    //Making the connection with REST api
    public static WebServices serviceConnection(){
        if(webServices == null){

            //synchronized tasks
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            }).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(HTTPConstants.baseURL)
                    .client(okHttpClient)
                    .build();
            webServices = retrofit.create(WebServices.class);
        }
        return webServices;
    }
}
