package com.exchange.account.di

import android.accounts.AccountManager
import android.content.Context
import com.exchange.account.UserAccount
import com.exchange.account.internal.UserAccountImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object AccountModule {

    @Provides
    @Singleton
    internal fun accountManager(
        @ApplicationContext context: Context
    ): AccountManager {
        return AccountManager.get(context)
    }

    @Provides
    @Singleton
    internal fun providesUserAccount(
        accountManager: AccountManager
    ): UserAccount {
        return UserAccountImpl(accountManager)
    }

}
