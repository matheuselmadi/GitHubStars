package com.example.githubstars.presentation.viewmodel.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubstars.data.model.Item
import com.example.githubstars.domain.usecase.GetResultUseCase
import retrofit2.HttpException
import java.io.IOException

class ItemPagingSource(val getResultUseCase: GetResultUseCase) : PagingSource<Int, Item>() {
    private val FIRST_PAGE_INDEX = 1
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val position = params.key ?: FIRST_PAGE_INDEX
        return try {
            val response = getResultUseCase.execute(
                language = "language:kotlin",
                sort = "stars",
                page = position
            )
            val item = response.data!!.items
            LoadResult.Page(
                data = item,
                prevKey = if (position == FIRST_PAGE_INDEX) null else position,
                nextKey = if (item.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}