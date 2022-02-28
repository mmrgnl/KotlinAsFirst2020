@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
<<<<<<< .merge_file_a14668
fun isNumberHappy(number: Int): Boolean {
    return (number / 1000 + number / 100 % 10) == (number / 10 % 10 + number % 10)
}
=======
fun isNumberHappy(number: Int): Boolean = number / 1000 + number % 1000 / 100 == number % 100 / 10 + number % 10
>>>>>>> .merge_file_a21576

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if (x1 == x2 || y1 == y2)
        return true

    if ((x1 - y1) == (x2 - y2))
        return true
    if (((8 - x1) - y1) == ((8 - x2) - y2))
        return true

    return false
}


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
<<<<<<< .merge_file_a14668
    if (month == 2) {
        if (year % 400 == 0)
            return 29
        else if (year % 4 == 0 && year % 100 != 0)
            return 29
        else
            return 28
    }
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        else -> 0
    }
=======
    if (month !in 1..12 || year < 0) return -1
    if (month == 2) {
        return if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29
        else 28
    }
    if (month == 4 || month == 6 || month == 9 || month == 11) return 30
    return 31
>>>>>>> .merge_file_a21576
}

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    val distToCenter = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

    return distToCenter + r1 <= r2
}

/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
<<<<<<< .merge_file_a14668
    if ((a <= r && b <= s) || (b <= r && a <= s))
        return true
    if ((a <= r && c <= s) || (c <= r && a <= s))
        return true
    if ((b <= r && c <= s) || (c <= r && b <= s))
        return true
    return false
}
=======
    var min1 = a
    var min2 = b
    if (a <= b && a <= c) {
        min1 = a
        min2 = if (b < c) b else c
    }
    if (b <= a && b <= c) {
        min1 = b
        min2 = if (a < c) a else c
    }
    if (c <= b && c <= a) {
        min1 = c
        min2 = if (b < a) b else a
    }
    return (s in min1..r && min2 <= r) || (r in min1..s && min2 <= s)

}

>>>>>>> .merge_file_a21576
