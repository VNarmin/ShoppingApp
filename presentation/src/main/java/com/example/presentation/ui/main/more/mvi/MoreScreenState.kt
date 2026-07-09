package com.example.presentation.ui.main.more.mvi

import androidx.compose.runtime.Immutable
import com.example.domain.model.Category
import com.example.presentation.ui.main.more.widget.CategoryState
import com.example.presentation.ui.main.more.widget.MoreBodyState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
internal data class MoreScreenState(
    val username: String = "",
    val categories: ImmutableList<Category> = persistentListOf(),
    val loading: Boolean = false,
    val errorMessage: String? = null
) {
    fun formMoreBodyState(): MoreBodyState = MoreBodyState(
        username = username,
        categoryStates = formCategoryStates()
    )

    private fun formCategoryStates(): ImmutableList<CategoryState> =
        categories.map { category ->
            CategoryState(
                categoryID = category.categoryID,
                categoryDisplayName = category.displayName,
                categoryItemCount = category.itemCount
            )
        }.toImmutableList()

    companion object {
        val INITIAL = MoreScreenState()
    }
}