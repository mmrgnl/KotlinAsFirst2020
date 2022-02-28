@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
<<<<<<< .merge_file_a19440
import java.lang.StringBuilder
import kotlin.math.*
=======
import lesson3.task1.hasDifferentDigits
import kotlin.math.sqrt
>>>>>>> .merge_file_a01308

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

fun main() {
    print(roman(16))
}

fun pow(n: Int, power: Int): Int = n.toDouble().pow(power).toInt()

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
fun abs(v: List<Double>): Double {
    var abs = 0.0
    for (i in v.indices)
        abs += v[i].pow(2)
    abs = sqrt(abs)

    return abs
}

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty())
        return 0.0

    var avg = 0.0
    for (i in list.indices)
        avg += list[i]
    avg /= list.size

    return avg
}

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var avg = 0.0
    for (i in list.indices)
        avg += list[i]
    avg /= list.size

    for (i in list.indices)
        list[i] -= avg

    return list
}

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int {
    var c = 0
<<<<<<< .merge_file_a19440
    for (i in a.indices)
        c += a[i] * b[i]
=======
    for (ch in a.indices) {
        c += a[ch] * b[ch]
    }
>>>>>>> .merge_file_a01308
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
<<<<<<< .merge_file_a19440
    for (i in p.indices)
        px += p[i] * pow(x, i)
=======
    var ch = 0
    var vx = 1
    while (ch <= p.size - 1) {
        px += p[ch] * vx
        vx *= x
        ch += 1
    }
>>>>>>> .merge_file_a01308
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
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    var sum = 0
    for (i in list.indices) {
        sum += list[i]
        list[i] = sum
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val sqrtn = ceil(sqrt(n.toDouble())).toInt() + 1
    val notAPrime = BooleanArray(sqrtn + 1) { false }
    val mulList = mutableListOf<Int>()

    var n1 = n
    for (i in 2..sqrtn) {
        if (notAPrime[i])
            continue

        while (n1 % i == 0) {
            mulList.add(i)
            n1 /= i
        }
        for (j in (i * 2)..sqrtn step i)
            notAPrime[j] = true
    }
    // Только один простой делитель может быть больше sqrt(n)
    if (n1 != 1)
        mulList.add(n1)

    return mulList
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String {
<<<<<<< .merge_file_a19440
    val sqrtn = ceil(sqrt(n.toDouble())).toInt() + 1
    val notAPrime = BooleanArray(sqrtn + 1) { false }
    val mulList = StringBuilder()

    var n1 = n
    for (i in 2..sqrtn) {
        if (notAPrime[i])
            continue

        while (n1 % i == 0) {
            mulList.append("*$i")
            n1 /= i
        }
        for (j in (i * 2)..sqrtn step i)
            notAPrime[j] = true
    }
    // Только один простой делитель может быть больше sqrt(n)
    if (n1 != 1)
        mulList.append("*$n1")

    mulList.deleteAt(0)
    return mulList.toString()
=======
    var a = n
    var b = 2
    val str = StringBuilder()
    while (a != 1) {
        while (a % b == 0) {
            str.append(b.toString())
            str.append("*")
            a /= b
        }
        b++
    }
    return str.toString().dropLast(1)
>>>>>>> .merge_file_a01308
}

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
operator fun Char.times(other: Int): String = this.toString().repeat(other)
operator fun Char.plus(other: Char): String = this.toString() + other.toString()

const val romanDigits = "IVXLCDM"

fun roman(n: Int): String {
    var n2 = n
    var romanStr = ""

    romanStr += 'M' * (n2 / 1000)
    n2 %= 1000

    var magnitude = max(0, log10(n2.toDouble()).toInt())
    do {
        val msd = n2 / pow(10, magnitude) // Most Significant Digit
        n2 %= pow(10, magnitude)

        romanStr += when (msd) {
            in 1..3 -> romanDigits[0 + magnitude * 2] * msd
            in 5..8 -> romanDigits[1 + magnitude * 2] + romanDigits[0 + magnitude * 2] * (msd - 5)
            4 -> romanDigits[0 + magnitude * 2] + romanDigits[1 + magnitude * 2]
            9 -> romanDigits[0 + magnitude * 2] + romanDigits[2 + magnitude * 2]
            else -> ""
        }
    } while (magnitude-- > 0)

    return romanStr
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
<<<<<<< .merge_file_a19440
val russianDigits = arrayOf(
    "",
    "один",
    "два",
    "три",
    "четыре",
    "пять",
    "шесть",
    "семь",
    "восемь",
    "девять"
)

fun russian(n: Int): String {
    if (n == 0)
        return "ноль"

    var numberStr = ""

    val digit = IntArray(6)
    for (i in 5 downTo 0) {
        digit[i] = (n / 10.0.pow(i)).toInt() % 10
    }

    // Тысячи
    if (n / 1000 > 0) {
        if (digit[3] in 1..2 && digit[4] != 1) {
            numberStr += russian(n / 1000 - digit[3])
            if (numberStr == "ноль") numberStr = ""

            if (digit[3] == 1) numberStr += " одна тысяча "
            else numberStr += " две тысячи "
        } else {
            numberStr += russian(n / 1000)
            if (numberStr == "ноль") numberStr = ""

            if (digit[4] == 1)
                numberStr += " тысяч "
            else if (digit[3] in 3..4)
                numberStr += " тысячи "
            else
                numberStr += " тысяч "
        }
    }

    // Сотни
    numberStr += when (digit[2]) {
        0 -> ""
        1 -> "сто "
        2 -> "двести "
        3 -> "триста "
        4 -> "четыреста "
        else -> russianDigits[digit[2]] + "сот "
    }

    // Десятки
    if (digit[1] == 1) {
        if (n % 100 == 10)
            return numberStr + "десять"
        if (n % 100 == 12)
            return numberStr + "двенадцать"
        if (n % 100 == 14)
            return numberStr + "четырнадцать"

        numberStr += russianDigits[digit[0]]
        if (numberStr.endsWith("ь"))
            numberStr = numberStr.dropLast(1)
        return numberStr + "надцать"

    }
    numberStr += when (digit[1]) {
        0 -> ""
        2 -> "двадцать "
        3 -> "тридцать "
        4 -> "сорок "
        9 -> "девяносто "
        else -> russianDigits[digit[1]] + "десят "
    }

    // Единицы
    if (digit[0] == 0)
        numberStr = numberStr.dropLast(1)
    else
        numberStr += russianDigits[digit[0]]

    numberStr = numberStr.trim()
    return numberStr
=======
fun russian(n: Int): String {
    val str = StringBuilder()
    var k = n
    val units = listOf(
        "один ",
        "два ",
        "три ",
        "четыре ",
        "пять ",
        "шесть ",
        "семь ",
        "восемь ",
        "девять "
    )
    val tenplus = listOf(
        "одиннадцать ",
        "двенадцать ",
        "тринадцать ",
        "четырнадцать ",
        "пятнадцать ",
        "шестнадцать ",
        "семнадцать ",
        "восемнадцать ",
        "девятнадцать "
    )
    val dozens = listOf(
        "десять ",
        "двадцать ",
        "тридцать ",
        "сорок ",
        "пятьдесят ",
        "шестьдесят ",
        "семьдесят ",
        "восемьдесят ",
        "девяносто "
    )
    val hundreds = listOf(
        "сто ",
        "двести ",
        "триста ",
        "четыреста ",
        "пятьсот ",
        "шестьсот ",
        "семьсот ",
        "восемьсот ",
        "девятьсот "
    )


    if (k / 100000 != 0) {
        str.append(hundreds[k / 100000 - 1] + "тысяч ")
        k %= 100000
    }
    if (k / 1000 in 11..19) {
        if (str.isNotEmpty()) str.delete(str.length - 7, str.length - 1)
        str.append(tenplus[k / 1000 % 10 - 1] + "тысяч ")
        k %= 1000
    } else {
        if (k / 10000 != 0) {
            if (str.isNotEmpty()) str.delete(str.length - 7, str.length - 1)
            str.append(dozens[(k / 10000 - 1)] + "тысяч ")
            k %= 10000
        }
        if (k / 1000 != 0) {
            if (str.isNotEmpty()) str.delete(str.length - 7, str.length - 1)
            if (k / 1000 == 1) str.append("одна тысяча ")
            if (k / 1000 == 2) str.append("две тысячи ")
            if (k / 1000 in 3..4) str.append(units[(k / 1000 - 1)] + "тысячи ")
            if (k / 1000 > 4) str.append(units[(k / 1000 - 1)] + "тысяч ")
            k %= 1000
        }
    }

    if (k / 100 != 0) {
        str.append(hundreds[(k / 100 - 1)])
        k %= 100
    }
    if (k in 10..19) {
        if (k == 10) str.append("десять ") else
            str.append(tenplus[(k - 11)])
    } else {
        if (k / 10 != 0) {
            str.append(dozens[(k / 10 - 1)])
            k %= 10
        }
        if (k != 0) {
            str.append(units[(k - 1)])
        }
    }

    return str.toString().dropLast(1)
>>>>>>> .merge_file_a01308
}