package com.scalioassignment.app.di.modules
import android.app.Application
import com.scalioassignment.app.data.remote.GithubApiService
import com.scalioassignment.app.data.repository.GithubRepository
import com.scalioassignment.app.data.repository.GithubRepositoryImp
import com.scalioassignment.app.utils.StringUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * The Dagger Module for providing repository instances.
 * @author Wajahat Karim
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideStringUtils(app: Application): StringUtils {
        return StringUtils(app)
    }

    @Singleton
    @Provides
    fun provideImagineRepository(stringUtils: StringUtils, apiService: GithubApiService): GithubRepository {
        return GithubRepositoryImp(stringUtils, apiService)
    }
}