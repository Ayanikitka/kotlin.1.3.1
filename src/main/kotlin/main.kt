fun main() {
    val seconds = 40000
    println(agoToText(seconds))
}

fun agoToText(seconds: Int): String {
    return when {
        seconds <= 60 -> "был(а) только что"
        seconds >= 61 && seconds <= 60 * 60 -> toMinutesText(seconds)
        seconds > 60 * 60 && seconds < 24 * 60 * 60 -> toHoursText(seconds)
        seconds >= 24 * 60 * 60  -> toDayText(seconds)
        else -> error("Некореектное значение!")
    }
}

fun toMinutesText(seconds: Int): String {
    val minutes = seconds / 60
    return if (minutes in 10..20) "был(а) в сети $minutes минут назад"
    else when {
        minutes % 10 == 1 -> "был(а) в сети $minutes минуту назад"
        minutes % 10 in 2..4 -> "был(а) в сети $minutes минуты назад"
        else -> "был(а) в сети $minutes минут назад"
    }
}

fun toHoursText(seconds: Int): String {
    val hours = seconds / (60 * 60)
    return if (hours in 10..20) "был(а) в сети $hours часов назад"
    else when {
        hours % 10 == 1 -> "был(а) в сети $hours час назад"
        hours % 10 in 2..4 -> "был(а) в сети $hours часа назад"
        else -> "был(а) в сети $hours часов назад"
    }
}

fun toDayText(seconds: Int): String {
    val days = seconds / (60 * 60 * 24)
    return when (days) {
        1 -> "был(а) сегодня"
        2 -> "был(а) вчера"
        else -> "был(а) давно"
    }
}