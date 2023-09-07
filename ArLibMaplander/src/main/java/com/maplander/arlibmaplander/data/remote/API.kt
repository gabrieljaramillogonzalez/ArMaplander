package com.maplander.arlibmaplander.data.remote

import com.maplander.arlibmaplander.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class API {
    companion object{

        private val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_GMLS)
            .addConverterFactory(GsonConverterFactory.create())

        private var retrofit = builder.build()

        private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        private val httpClient = OkHttpClient.Builder()

        fun <S> createService(serviceClass: Class<S>?): S {
            if (!httpClient.interceptors().contains(logging)) {
                httpClient.connectTimeout(90, TimeUnit.SECONDS)
                httpClient.readTimeout(90, TimeUnit.SECONDS)
                httpClient.writeTimeout(90, TimeUnit.SECONDS)
                httpClient.addInterceptor(logging)
                httpClient.addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header("User-Agent", "GlobalMls Android")
                        .method(original.method(), original.body())
                        .build()
                    chain.proceed(request)
                }
                //            httpClient.addInterceptor(new NetworkConnectionInterceptor(context));
                httpClient.addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header("User-Agent", "GlobalMls Android")
                        .method(original.method(), original.body())
                        .build()
                    chain.proceed(request)
                }
                builder.client(httpClient.build())
                retrofit = builder.build()
            }
            return retrofit.create(serviceClass)
        }

    }
}