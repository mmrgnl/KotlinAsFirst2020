@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var c = 0
    for (ch in a.indices) {
        c += a[ch] * b[ch]
    }
    return c
}

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    var px = 0
    var ch = 0
    var vx = 1
    while (ch <= p.size - 1) {
        px += p[ch] * vx
        vx *= x
        ch += 1
    }
    return px
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val res = mutableListOf<Int>()
    if (n < base) {
        res.add(n)
        return res
    }
    var c = n
    while (c != 0) {
        res.add(c % base)
        c /= base
    }
    res.reverse()
    return res
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var str = ""
    var k = n
    if (k / 100000 != 0) {
        if (k / 100000 == 9) str += "девятьсот тысяч "
        if (k / 100000 == 8) str += "восемьсот тысяч "
        if (k / 100000 == 7) str += "семьсот тысяч "
        if (k / 100000 == 6) str += "шестьсот тысяч "
        if (k / 100000 == 5) str += "пятьсот тысяч "
        if (k / 100000 == 4) str += "четыреста тысяч "
        if (k / 100000 == 3) str += "триста тысяч "
        if (k / 100000 == 2) str += "двести тысяч "
        if (k / 100000 == 1) str += "сто тысяч "
        k %= 100000
    }
    if (k / 1000 in 11..19) {
        str = str.dropLast(6)
        if (k / 1000 == 19) str += "девятнадцать тысяч "
        if (k / 1000 == 18) str += "восемнадцать тысяч "
        if (k / 1000 == 17) str += "семнадцать тысяч "
        if (k / 1000 == 16) str += "шестнадцать тысяч "
        if (k / 1000 == 15) str += "пятнадцать тысяч "
        if (k / 1000 == 14) str += "четырнадцать тысяч "
        if (k / 1000 == 13) str += "тринадцать тысяч "
        if (k / 1000 == 12) str += "двенадцать тысяч "
        if (k / 1000 == 11) str += "одиннадцать тысяч "
        k %= 1000
    } else {
        if (k / 10000 != 0) {
            str = str.dropLast(6)
            if (k / 10000 == 9) str += "девяносто тысяч "
            if (k / 10000 == 8) str += "восемьдесят тысяч "
            if (k / 10000 == 7) str += "семьдесят тысяч "
            if (k / 10000 == 6) str += "шестьдесят тысяч "
            if (k / 10000 == 5) str += "пятьдесят тысяч "
            if (k / 10000 == 4) str += "сорок тысяч "
            if (k / 10000 == 3) str += "тридцать тысяч "
            if (k / 10000 == 2) str += "двадцать тысяч "
            if (k / 10000 == 1) str += "десять тысяч "
            k %= 10000
        }
        if (k / 1000 != 0) {
            str = str.dropLast(6)
            if (k / 1000 == 9) str += "девять тысяч "
            if (k / 1000 == 8) str += "восемь тысяч "
            if (k / 1000 == 7) str += "семь тысяч "
            if (k / 1000 == 6) str += "шесть тысяч "
            if (k / 1000 == 5) str += "пять тысяч "
            if (k / 1000 == 4) str += "четыре тысячи "
            if (k / 1000 == 3) str += "три тысячи "
            if (k / 1000 == 2) str += "две тысячи "
            if (k / 1000 == 1) str += "одна тысяча "
            k %= 1000
        }
    }
    if (k / 100 != 0) {
        if (k / 100 == 9) str += "девятьсот "
        if (k / 100 == 8) str += "восемьсот "
        if (k / 100 == 7) str += "семьсот "
        if (k / 100 == 6) str += "шестьсот "
        if (k / 100 == 5) str += "пятьсот "
        if (k / 100 == 4) str += "четыреста "
        if (k / 100 == 3) str += "триста "
        if (k / 100 == 2) str += "двести "
        if (k / 100 == 1) str += "сто "
        k %= 100
    }
    if (k in 11..19) {
        if (k == 19) str += "девятнадцать "
        if (k == 18) str += "восемнадцать "
        if (k == 17) str += "семнадцать "
        if (k == 16) str += "шестнадцать "
        if (k == 15) str += "пятнадцать "
        if (k == 14) str += "четырнадцать "
        if (k == 13) str += "тринадцать "
        if (k == 12) str += "двенадцать "
        if (k == 11) str += "одиннадцать "
    } else {
        if (k / 10 != 0) {
            if (k / 10 == 9) str += "девяносто "
            if (k / 10 == 8) str += "восемьдесят "
            if (k / 10 == 7) str += "семьдесят "
            if (k / 10 == 6) str += "шестьдесят "
            if (k / 10 == 5) str += "пятьдесят "
            if (k / 10 == 4) str += "сорок "
            if (k / 10 == 3) str += "тридцать "
            if (k / 10 == 2) str += "двадцать "
            if (k / 10 == 1) str += "десять "
            k %= 10
        }
        if (k != 0) {
            if (k == 9) str += "девять "
            if (k == 8) str += "восемь "
            if (k == 7) str += "семь "
            if (k == 6) str += "шесть "
            if (k == 5) str += "пять "
            if (k == 4) str += "четыре "
            if (k == 3) str += "три "
            if (k == 2) str += "два "
            if (k == 1) str += "один "
        }
    }
    return str.dropLast(1)
}