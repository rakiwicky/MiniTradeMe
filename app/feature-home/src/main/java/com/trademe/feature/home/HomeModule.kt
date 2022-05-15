package com.trademe.feature.home

import android.content.Context
import android.content.res.Resources
import com.mytrademeapp.base.network.RestServiceBuilder
import com.trademe.feature.home.internal.repository.LatestListingsDao
import com.trademe.feature.home.internal.repository.LatestListingsRepository
import com.trademe.feature.home.internal.repository.LatestListingsRepositoryImpl
import com.trademe.feature.home.internal.ui.latestlisting.LatestListingsListMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    internal abstract fun bindRepository(impl: LatestListingsRepositoryImpl): LatestListingsRepository

    companion object {

        @Provides
        @Singleton
        internal fun provideLatestListingsDao(
            okHttpClient: OkHttpClient,
            restServiceBuilder: RestServiceBuilder,
            @Named("TradeMe_BaseURL") baseUrl: String
        ): LatestListingsDao {
            return restServiceBuilder.create(LatestListingsDao::class.java, baseUrl, okHttpClient)
        }

        @Provides
        @Singleton
        internal fun provideListMapper(): LatestListingsListMapper {
            return LatestListingsListMapper()
        }

        @Provides
        @Singleton
        fun provideResources(
            @ApplicationContext context: Context
        ): Resources {
            return context.resources
        }
    }
}