package com.example.valorent.DI

import com.example.valorent.DataLayer.AgentApi.ValorentApi
import com.example.valorent.Repository.ValorentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ValorentModule {

    @Provides
    @Singleton
    fun provideValorentApi(): ValorentApi {
        return Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/")
            .build()
            .create(ValorentApi::class.java)
    }
    @Provides
    @Singleton
    fun provideValorentRepository(api : ValorentApi): ValorentRepository {
        return ValorentRepository(api)
    }

}