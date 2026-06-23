package com.example.domain.base

import kotlinx.coroutines.flow.Flow

abstract class BaseObserveUseCase<P, R> {
    abstract fun execute(params: P): Flow<R>
}