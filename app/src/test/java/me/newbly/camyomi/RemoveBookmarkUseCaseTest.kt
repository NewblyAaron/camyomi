package me.newbly.camyomi

import kotlinx.coroutines.runBlocking
import me.newbly.camyomi.domain.usecase.RemoveBookmarkUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class RemoveBookmarkUseCaseTest : BaseTest() {
    private lateinit var removeBookmarkUseCase: RemoveBookmarkUseCase

    @Before
    override fun setUp() {
        super.setUp()
        removeBookmarkUseCase = RemoveBookmarkUseCase(mockAppRepository)
    }

    @Test
    fun `remove bookmark`(): Unit = runBlocking {
        val id = 1

        `when`(mockAppRepository.removeBookmark(id))
            .thenReturn(Result.success(true))

        removeBookmarkUseCase(id)

        verify(mockAppRepository).removeBookmark(id)
    }
}