package domain.use_cases

import org.koin.core.component.KoinComponent

class RandomBackgroundColorUseCase: KoinComponent {
    operator fun invoke(): String {
        val colors = Colors.values()
        val uniqueColor = colors.random()
        return uniqueColor.code
    }
}

internal enum class Colors(val code: String) {
    PURPLE("#beaded"),
    GREEN("#c0ffee"),
    LIGHT_PURPLE("#decade"),
    LIGHT_RED("#dec0de")
}