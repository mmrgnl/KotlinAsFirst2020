@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1

<<<<<<< .merge_file_a21880
import lesson2.task2.daysInMonth
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.NumberFormatException
import java.util.Stack
=======
import java.io.File

>>>>>>> .merge_file_a16728

// Урок 6: разбор строк, исключения
// Максимальное количество баллов = 13
// Рекомендуемое количество баллов = 11
// Вместе с предыдущими уроками (пять лучших, 2-6) = 40/54

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */

/**
 * В файле с именем inputName заданы ежедневные сведения о
 * количестве выпавших осадков (в мм) в различные месяцы года,
 * всего не более чем 31 значение в каждой строке и
 * не более 12 строк во всём файле, например:
 *
 * Март 0 1 0 3 41 2 0 0 13 16 20 8 0 4 8 1 0 0 0 7 12 0 4 9
 * Апрель 0 0 0 17 0 0 11 48 42 0 0 1 7 15 18 0 0 0 0 0 8 2 17 0
 * Май 10 15 48 21 0 0 17 22 30 0 0 13 0 0 2 5 7 0 0 0 1 10 3
 *
 * Каждая строка начинается с названия месяца, за которым
 * следует последовательность целых чисел - уровень осадков в мм
 * в различные дни этого месяца, начиная с 1-го. Порядок месяцев
 * в файле должен соответствовать реальному (следующий месяц всегда
 * ниже предыдущего).
 *
 * В строковом параметре days задан интервал дат
 * либо в формате “Апрель 9..15”  (дни в одном месяце),
 * либо в формате “Март 22..Май 8” (дни в разных месяцах).
 *
 * Необходимо рассчитать максимальный уровень осадков за один день
 * в заданном интервале дат. Например, для “Апрель 9..15” это 42,
 * для “Март 22..Май 8” это 48. Отсутствующие дни игнорировать.
 *
 * “Удовлетворительно” -- используется только первый формат для
 * параметра days - все дни в одном месяце
 *
 * “Хорошо” -- может использоваться как первый, так и второй
 * формат для параметра days, то есть, интервал может содержать
 * дни в разных месяцах
 *
 * “Отлично” -- результат функции должен содержать не только
 * максимальный уровень осадков, но и список дней,
 * в которых он был достигнут
 * (42, 9 апреля или 48, 8 апреля, 3 мая для примеров выше)
 *
 * При нарушении форматов входных данных следует выбрасывать
 * исключение IllegalArgumentException. При невозможности
 * прочитать файл выбрасывать исключение IOException.
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */

fun myFun2(inputName: String, days: String): Any {

    val count = days.split(" ")
    if (count.size < 3) {

        val month1 = count[0]
        val day = count[1].split("..")
        val d1 = day[0].toInt()
        val d2 = day[1].toInt()

        println(d1)
        println(d2)

        var max = 0
        var i = 0
        for (line in File(inputName).readLines()) {
            i = 0
            var m = line.split(" ")
            //  println(m[0])
            if (m[0] == month1) {

                for (count in line.split(" ")) {

                    if (i in d1..d2) {
                        println(count)

                        if (count.toInt() > max) max = count.toInt()
                    }
                    i += 1
                }
            }

        }



        return max
    } else {
        val month1 = count[0]
        //Март 22..Май 8
        val day = count[1].split("..")
        val d1 = day[0].toInt()
        val month2 = day[1]
        val d2 = count[2].toInt()
        println(month1)
        println(month2)
        println(d1)
        println(d2)

        var max = 0
        var i = 0
        var s = false
        for (line in File(inputName).readLines()) {
            i = 0
            var m = line.split(" ")
            //  println(m[0])


            if (m[0] == month1) s = true
            if (m[0] == month2) {

                for (count in line.split(" ")) {

                    if (i in 1..d2) {
                        //    println(count)

                        if (count.toInt() > max) max = count.toInt()
                    }
                    i += 1
                }
                return max
            }


            if (s) {

                for (count in line.split(" ")) {

                    if (m[0] == month1 && i >= d1 || m[0] != month1 && i >= 1) {
                        //    println(count)

                        if (count.toInt() > max) max = count.toInt()
                    }
                    i += 1
                }
            }

        }


    }

    return 0

}

/**
 * В файле с именем inputName заданы описания квартир,
 * предлагающихся для продажи, в следующем формате:
 *
 * Пионерская 9-17: комната 18, комната 14, кухня 7, коридор 4
 * Школьная 12-14: комната 19, кухня 8, коридор 3
 * Садовая 19-1-55: комната 12, комната 19, кухня 9, коридор 5
 * Железнодорожная 3-6: комната 21, кухня 6, коридор 4
 *
 * Строчка начинается с адреса квартиры, после двоеточия
 * перечисляются помещения квартиры через запятую, с указанием
 * их площади.
 *
 * Параметр query содержит запрос, начинающийся с названия
 * помещения, за которым следует его минимальная площадь,
 * например, “кухня 8”. Через точку с запятой могут следовать
 * другие ограничения, например “кухня 8; коридор 4”
 * Функция должна найти все квартиры в списке,
 * удовлетворяющие запросу (площадь кухни больше или равна 8,
 * площадь коридора больше или равна 4)
 *
 * “Удовлетворительно” -- в запросе может присутствовать только
 * одно помещение, например, “кухня 8”
 *
 * “Хорошо” -- в запросе может присутствовать несколько помещений,
 * например, “кухня 8; комната 15”
 *
 * “Отлично” -- в запросе может присутствовать два и более
 * однотипных помещения, например, “комната 19; комната 12” --
 * двухкомнатная квартира,
 * одна комната не менее 19, другая не менее 12
 *
 * При нарушении форматов входных данных следует выбрасывать
 * исключение IllegalArgumentException, при невозможности
 * прочитать файл выбрасывать исключение IOException.
 *
 * Предложить имя и тип результата функции. Кроме функции
 * следует написать тесты, подтверждающие её работоспособность.
 */
fun foo(inputName: String, query: String): Any {
    try {
        val part = query.split(" ")

        if (part.size < 3) {

            val n = part[1].toInt()
            val p = part[0]
            var c: String
            var t = false
            for (line in File(inputName).readLines()) {
                for (count in line.split(" ")) {
                    if (t) {
                        if (count.toString().dropLast(1).toInt() >= n) {
                            val res = line.split(": ")
                            return res[0]
                        } else t = false
                    }
                    if (count == p) t = true
                }
            }
        } else {

            val prt = query.split("; ")
            val counts = mutableMapOf<String, Int>()


            for (i in prt) {
                val c = i.split(" ")
                counts.put(c[0], c[1].toInt())
            }

            var t = false
            var s = " "
            for (line in File(inputName).readLines()) {


                for (count in line.split(" ")) {
                    if (t) {
                        if (count.toString().dropLast(1).toInt() >= counts[s]!!) {
                            val res = line.split(": ")
                            return res[0]
                        } else t = false
                    }
                    if (counts.containsKey(count)) {
                        t = true
                        s = count
                    }


                }
            }

        }

        return 0
    } catch (e: NumberFormatException) {
        null
    }
    return 0
}


fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main() {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */
<<<<<<< .merge_file_a21880
val months: Map<String, Int> = mapOf(
    "января" to 1,
    "февраля" to 2,
    "марта" to 3,
    "апреля" to 4,
    "мая" to 5,
    "июня" to 6,
    "июля" to 7,
    "августа" to 8,
    "сентября" to 9,
    "октября" to 10,
    "ноября" to 11,
    "декабря" to 12
)

fun dateStrToDigit(str: String): String {
    if (str.contains("-"))
        return ""
    val dateStr = str.split(" ")
    if (dateStr.size != 3)
        return ""

    val dateInt = try {
        intArrayOf(
            dateStr[0].toInt(),
            months.getOrDefault(dateStr[1], -1),
            dateStr[2].toInt()
        )
    } catch (e: NumberFormatException) {
        return ""
    }
    if (dateInt[1] == -1)
        return ""
    if (dateInt[0] > daysInMonth(dateInt[1], dateInt[2]))
        return ""

    return String.format("%02d.%02d.%d", dateInt[0], dateInt[1], dateInt[2])
=======
fun dateStrToDigit(str: String): String {
    val parts = str.split(" ")
    val month = mapOf(
        "января" to ("01" to 31),
        "февраля" to ("02" to 28),
        "марта" to ("03" to 31),
        "апреля" to ("04" to 30),
        "мая" to ("05" to 31),
        "июня" to ("06" to 30),
        "июля" to ("07" to 31),
        "августа" to ("08" to 31),
        "сентября" to ("09" to 30),
        "октября" to ("10" to 31),
        "ноября" to ("11" to 30),
        "декабря" to ("12" to 31),
    )
    return try {
        if (month[parts[1]] == null) return ""
        val leap: Boolean = (parts[1] == "февраля" && parts[2].toInt() % 400 == 0) //обработка високосного года
                || (parts[1] == "февраля" && parts[2].toInt() % 4 == 0 && parts[2].toInt() % 100 != 0)
        if ((parts[1] != "февраля" && parts[0].toInt() in 1..month[parts[1]]?.second!!)
            || (parts[1] == "февраля" && parts[0].toInt() in 1..28 && !leap)
            || (parts[1] == "февраля" && parts[0].toInt() in 1..29 && leap)
        )
            return String.format(
                "%02d.%02d.%01d",
                parts[0].toInt(),
                month[parts[1]]?.first?.toInt(),
                parts[2].toInt()
            )
        else ""
    } catch (e: IndexOutOfBoundsException) {
        ""
    }
>>>>>>> .merge_file_a16728
}

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String {
    if (digital.contains("-"))
        return ""

    val dateInt = try {
        mutableListOf<Int>().apply {
            digital.split(".").forEach { this.add(it.toInt()) }
        }
    } catch (e: NumberFormatException) {
        return ""
    }
    if (dateInt.size != 3)
        return ""
    if (dateInt[0] > daysInMonth(dateInt[1], dateInt[2]) || dateInt[0] < 0)
        return ""

    return String.format(
        "%d %s %d", dateInt[0],
        months.filterValues { it == dateInt[1] }.keys.first(), dateInt[2]
    )
}

/**
 * Средняя (4 балла)
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String {
    if (Regex("\\+\\D").containsMatchIn(phone))
        return ""

    val phoneFlatten = phone.replace("[- ]".toRegex(), "")
    val phoneRegex = Regex("(\\+\\d+)?(?!\\(\\))(\\(\\d+\\))?\\d+")

    if (phoneRegex.matches(phoneFlatten))
        return phoneFlatten.replace("[)(]".toRegex(), "")
    return ""
}

/**
 * Средняя (5 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
<<<<<<< .merge_file_a21880
    if (Regex("[^\\d\\s%-]").containsMatchIn(jumps) ||
        Regex("-\\d+").containsMatchIn(jumps)
    ) return -1


    return try {
        jumps.split(" ").maxOf {
            if (it == "%" || it == "-") -1 else it.toInt()
        }
    } catch (e: NumberFormatException) {
        -1
    }
=======
    if (!jumps.matches(Regex("""((\s)?\d+|(\s)?[%-]\s[%-]\s\d+|(\s)?[%-]\s\d+)+"""))) {
        return -1
    }
    val parts = jumps.split(" ")
    var max = -1
    for (part in parts) {
        if (part != "%" && part != "-") {
            if (part.toInt() > max) max = part.toInt()
        }
    }
    return max
>>>>>>> .merge_file_a16728
}

/**
 * Сложная (6 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
<<<<<<< .merge_file_a21880
    if (!Regex("(\\d+(( [+-] )|\$))+").matches(expression))
        throw IllegalArgumentException()

    return Regex("[+-]?\\d+")
        .findAll(
            expression.replace(" ", "")
        ).sumOf { it.value.toInt() }
}
=======
    var res = 0
    val parts = expression.split(" ")
    var sign = 1
    if (!"$expression + ".matches(Regex("""(\d+ [+-] )+"""))) {
        throw IllegalArgumentException(expression)
    }
    for (part in parts) {
        if (part == "+") sign = 1
        if (part == "-") sign = -1
        if (part != "+" && part != "-") {
            res += part.toInt() * sign
        }
    }
    return res
}

>>>>>>> .merge_file_a16728

/**
 * Сложная (6 баллов)
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
<<<<<<< .merge_file_a21880
fun firstDuplicateIndex(str: String): Int = Regex(
    "(\\S+)\\s\\1",
    RegexOption.IGNORE_CASE
).find(str)?.range?.first ?: -1
=======
fun firstDuplicateIndex(str: String): Int {
    val parts = str.split(" ")
    var k = 0
    if (parts.size == 1) return -1
    for (part in parts.indices) {
        if (part + 1 >= parts.size) return -1
        if (parts[part].equals(parts[part + 1], ignoreCase = true)) {
            return k
        }
        k += parts[part].length + 1
    }
    return -1
}

>>>>>>> .merge_file_a16728

/**
 * Сложная (6 баллов)
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше нуля либо равны нулю.
 */
fun mostExpensive(description: String): String {
    if (!Regex("( ?[^\\s;]+ \\d+(\\.\\d+)?(;|\$))+").matches(description))
        return ""

    return Regex("[^\\s;]+ \\d+(\\.\\d+)?")
        .findAll(description)
        .map { it.value }.toList()
        .associate {
            it.split(" ")
                .let { p -> Pair(p[0], p[1]) }
        }
        .maxByOrNull { it.value.toDouble() }?.key ?: ""
}

/**
 * Сложная (6 баллов)
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
val romanValues = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

fun fromRoman(roman: String): Int {
    var result = 0

    var i = 0
    while (i < roman.length) {
        val leftVal = romanValues.getOrDefault(roman[i], -1)

        if (i < (roman.length - 1)) {
            val rightVal = romanValues.getOrDefault(roman[i + 1], -1)
            if (leftVal == -1 || rightVal == -1)
                return -1

            if (leftVal < rightVal) {
                // Результатом вычитания пары цифр может быть только 4, 9, 40, 90 и т.д
                // Следовательно, соотношение значений в паре может быть только 1/5 и 1/10
                val ratio = leftVal.toDouble() / rightVal.toDouble()
                if (ratio != 0.2 && ratio != 0.1)
                    return -1
                result += rightVal - leftVal
                i++
            } else result += leftVal
        } else result += leftVal
        i++
    }
    return if (result == 0) -1 else result
}

/**
 * Очень сложная (7 баллов)
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    if (Regex("[^><+\\-\\[\\] ]").containsMatchIn(commands))
        throw IllegalArgumentException()

    var bracketCounter = 0
    for (c in commands) {
        if (c == '[')
            bracketCounter++
        if (c == ']' && --bracketCounter < 0)
            throw IllegalArgumentException()
    }
    if (bracketCounter > 0)
        throw  IllegalArgumentException()


    val mem = MutableList(cells) { 0 }
    var iP = 0
    var mP = cells / 2
    var total = 0
    val bracketsPos = Stack<Int>()

    fun skip() {
        bracketCounter = 1
        while (true) {
            iP++
            if (commands[iP] == '[')
                bracketCounter++
            else if (commands[iP] == ']')
                if (--bracketCounter == 0)
                    return
        }
    }

    while (iP < commands.length && total < limit) {
        when (commands[iP]) {
            '+' -> mem[mP]++
            '-' -> mem[mP]--
            '>' -> mP++
            '<' -> mP--
            '[' -> if (mem[mP] == 0) skip()
            else bracketsPos.push(iP)
            ']' -> if (mem[mP] != 0) iP = bracketsPos.peek()
            else bracketsPos.pop()
        }
        if (mP < 0 || mP >= cells)
            throw IllegalStateException()
        iP++; total++
    }
    return mem
}
