package zuniga.daniela.quizzapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG ="DesdeViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel (private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val bancopreguntas = listOf(
        Question(R.string.Question1,true),
        Question(R.string.Question2,true),
        Question(R.string.Question3,true),
        Question(R.string.Question4,false),
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val respuestaPreguntaActual: Boolean
        get() = bancopreguntas[currentIndex].answer

    val textoPreguntaActualResId: Int
        get() = bancopreguntas[currentIndex].textResId

    fun siguientePregunta() {
        currentIndex = (currentIndex + 1) % bancopreguntas.size
    }
    fun anteriorPregunta() {
        if (currentIndex == 0)
            currentIndex = bancopreguntas.size - 1
        else
            currentIndex = (currentIndex - 1) % bancopreguntas.size
    }

    fun moveToNext() {
        TODO("Not yet implemented")
    }
}