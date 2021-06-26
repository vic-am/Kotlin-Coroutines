package com.example.kotlincoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000) //sleep para simular uma chamada de API
            callback.invoke(
                listOf(
                    Filme(1, "Título 1"),
                    Filme(2, "Título 2"),
                    Filme(3, "Título 3"),
                    Filme(4, "Título 4"),
                    Filme(5, "Título 5")

                )
            )
        }).start()
    }

    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1, "Título 1"),
                Filme(2, "Título 2"),
                Filme(3, "Título 3"),
                Filme(4, "Título 4"),
                Filme(5, "Título 5")

            )
        }
    }
}