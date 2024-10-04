package me.newbly.camyomi

import kotlinx.coroutines.runBlocking
import me.newbly.camyomi.domain.usecase.AddBookmarkUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class AddBookmarkUseCaseTest : BaseTest() {
    private lateinit var addBookmarkUseCase: AddBookmarkUseCase

    @Before
    override fun setUp() {
        super.setUp()
        addBookmarkUseCase = AddBookmarkUseCase(mockAppRepository)
    }

    @Test
    fun `add bookmark`(): Unit = runBlocking {
        val id = 1

        `when`(mockAppRepository.addBookmark(id))
            .thenReturn(Result.success(true))

        addBookmarkUseCase(id)

        verify(mockAppRepository).addBookmark(id)
    }
}