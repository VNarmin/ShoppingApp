package com.example.presentation.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

/**
 * for passing the state down the tree
 * returning a new reader
 * NOT triggering recomposition in the caller
 */
@Composable
fun <T, R> (() -> T).focusOn(selector: T.() -> R): () -> R {
    val parentProvider = this
    val derivedSlice = remember(parentProvider) {
        derivedStateOf { selector(parentProvider()) }
    }
    return { derivedSlice.value }
}

/**
 * for reading the state in the current Composable
 * returns the raw value
 * triggering recomposition ONLY if the selected value changes
 */
@Composable
fun <T, R> (() -> T).read(selector: T.() -> R): R {
    val parentProvider = this
    val derivedSlice = remember(parentProvider) {
        derivedStateOf { selector(parentProvider()) }
    }
    return derivedSlice.value
}