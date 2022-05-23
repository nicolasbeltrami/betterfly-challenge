package com.nicobeltrami.rickandmortybettefly.di

import com.nicobeltrami.rickandmortybettefly.data.remote.ApiService
import com.nicobeltrami.rickandmortybettefly.data.remote.RemoteDataSource
import com.nicobeltrami.rickandmortybettefly.data.repository.CharacterRepositoryImpl
import com.nicobeltrami.rickandmortybettefly.domain.repository.CharacterRepository
import com.nicobeltrami.rickandmortybettefly.domain.usecase.FetchCharactersUseCase
import com.nicobeltrami.rickandmortybettefly.domain.usecase.GetCharacterByIdUseCase
import com.nicobeltrami.rickandmortybettefly.presentation.model.CharacterMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(datasource: RemoteDataSource): CharacterRepository {
        return CharacterRepositoryImpl(
            datasource
        )
    }

    @Provides
    @Singleton
    fun provideRemoteDatasource(service: ApiService): RemoteDataSource {
        return RemoteDataSource(service)
    }

    @Provides
    @Singleton
    fun provideFetchCharactersUseCase(repository: CharacterRepository): FetchCharactersUseCase {
        return FetchCharactersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCharacterByIdUseCase(repository: CharacterRepository): GetCharacterByIdUseCase {
        return GetCharacterByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCharacterMapper(): CharacterMapper {
        return CharacterMapper
    }
}
