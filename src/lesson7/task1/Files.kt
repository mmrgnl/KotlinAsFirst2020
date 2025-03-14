@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson7.task1

<<<<<<< .merge_file_a22136
import lesson4.task1.pow
import org.junit.Test
import ru.spbstu.ktuples.Tuple
import ru.spbstu.wheels.NullableMonad.filter
import ru.spbstu.wheels.out
import java.io.BufferedWriter
import java.io.File
import java.lang.NullPointerException
import java.lang.StringBuilder
import java.util.*
import javax.management.RuntimeErrorException
import kotlin.RuntimeException
import kotlin.math.floor
import kotlin.math.log10
import kotlin.system.measureTimeMillis
=======
import lesson5.task1.canBuildFrom
import java.io.File
import kotlin.math.max
import kotlin.math.min
>>>>>>> .merge_file_a19768

// Урок 7: работа с файлами
// Урок интегральный, поэтому его задачи имеют сильно увеличенную стоимость
// Максимальное количество баллов = 55
// Рекомендуемое количество баллов = 20
// Вместе с предыдущими уроками (пять лучших, 3-7) = 55/103

/**
 * Пример
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Вывести его в выходной файл с именем outputName, выровняв по левому краю,
 * чтобы длина каждой строки не превосходила lineLength.
 * Слова в слишком длинных строках следует переносить на следующую строку.
 * Слишком короткие строки следует дополнять словами из следующей строки.
 * Пустые строки во входном файле обозначают конец абзаца,
 * их следует сохранить и в выходном файле
 */
fun alignFile(inputName: String, lineLength: Int, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    var currentLineLength = 0
    fun append(word: String) {
        if (currentLineLength > 0) {
            if (word.length + currentLineLength >= lineLength) {
                writer.newLine()
                currentLineLength = 0
            } else {
                writer.write(" ")
                currentLineLength++
            }
        }
        writer.write(word)
        currentLineLength += word.length
    }
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            writer.newLine()
            if (currentLineLength > 0) {
                writer.newLine()
                currentLineLength = 0
            }
            continue
        }
        for (word in line.split(Regex("\\s+"))) {
            append(word)
        }
    }
    writer.close()
}


/**
 * В файле с именем inputName задана таблица действительных чисел.
 * Столбцы таблицы разделены запятыми и пробелами.
 * Каждая строка содержит не более 26 значений. Пример:
 *
 * 1.5, 2.67, 3.0, 1.4
 * 5.2, 7.1, -4.8, 0.0
 * 1.4, 6.0, 2.5, -1.9  *
 * В строковом параметре range  задан диапазон из двух ячеек
 * этой таблицы, разделённых чёрточкой, например “A2-C4” или
 * “A31-B42”
 * Ячейки закодированы так: столбец задаётся заглавной буквой
 * латинского алфавита (первый столбец это буква А),
 * а строка - целым числом (первая строка это число 1).
 *
 * Необходимо посчитать среднее арифметическое значений во всех
 * ячейках заданного диапазона заданной таблицы. Диапазон задаёт
 * углы прямоугольника -- например “А2-С3” соответствует
 * ячейкам A2, A3, B2, B3, C2, C3
 *
 * “Удовлетворительно” -- все строки содержат одинаковое
 * количество чисел, заданный диапазон относится к одной строке,
 * первая ячейка в нём обязательно находится слева,
 * например, “B3-D3” (содержит B3, C3, D3)
 *
 * “Хорошо” -- диапазоны могут содержать ячейки из разных строк
 * с произвольным положением углов, например, “B1-A2”
 * соответствует ячейкам A1, A2, B1, B2
 *
 * “Отлично” -- строки могут содержать разное количество
 * чисел. Кроме того, диапазон может включать ячейки за пределами
 * входной таблицы, это не является ошибкой,
 * ячейки за пределами таблицы просто не учитываются.
 * Пример: диапазон “E1-B2” содержит B1, C1, D1, B2, C2, D2
 *
 * При нарушении форматов входных данных следует выбрасывать
 * исключение IllegalArgumentException. При невозможности
 * прочитать файл выбрасывать исключение IOException.
 *
 * Предложить самостоятельно имя функции. Кроме функции следует
 * написать тесты, подтверждающие её работоспособность.
 */

fun myFun(inputName: String, range: String): Double {


    try {


        //  if (!range.matches(Regex("""[A-Z]\d-[A-Z]\d"""))) {
        //    return -1.toDouble()
        //}
        val counts = arrayOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z"
        )

        var l1: Int
        var l2: Int

        var s1: Int
        var s2: Int



        s2 = max(counts.indexOf(range[0].toString()), counts.indexOf(range[3].toString()))
        s1 = min(counts.indexOf(range[0].toString()), counts.indexOf(range[3].toString()))
        l2 = max(range[1].digitToInt(), range[4].digitToInt())
        l1 = min(range[1].digitToInt(), range[4].digitToInt())

        println(l1)
        println(l2)

        println(s1)
        println(s2)

        var l = 1
        var c = 0
        var sum = 0.0
        var size = 0
        for (line in File(inputName).readLines()) {

            //  println(line)
            c = 0
            if (l in l1..l2) {

                for (count in line.split(", ")) {
                    //  println(count)

                    if (c in s1..s2) {

                        println(count)
                        sum += count.toDouble()
                        size += 1
                    }
                    //    println(count)
                    c += 1
                }
            }

            l += 1
        }
        return sum / size.toDouble()

    } catch (e: IllegalArgumentException) {
        null
    }
    return 0.0

}


/**
 * Простая (8 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Некоторые его строки помечены на удаление первым символом _ (подчёркивание).
 * Перенести в выходной файл с именем outputName все строки входного файла, убрав при этом помеченные на удаление.
 * Все остальные строки должны быть перенесены без изменений, включая пустые строки.
 * Подчёркивание в середине и/или в конце строк значения не имеет.
 */
fun deleteMarked(inputName: String, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    for (line in File(inputName).readLines()) {
        if (!line.startsWith("_")) {
            writer.write(line)
            writer.newLine()
        }
    }
    writer.close()
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * На вход подаётся список строк substrings.
 * Вернуть ассоциативный массив с числом вхождений каждой из строк в текст.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 */
fun countSubstrings(inputName: String, substrings: List<String>): Map<String, Int> {
    val map = mutableMapOf<String, Int>()
    val text = File(inputName).readText()
    for (substring in substrings) {
        var count = 0
        for (i in text.indices) {
            if (text.length > i + substring.length - 1 &&
                text.substring(i, i + substring.length).lowercase() == substring.lowercase()
            ) count++
        }
        map[substring] = count
    }
    return map
}


/**
 * Средняя (12 баллов)
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    val writer = File(outputName).bufferedWriter()

    val replaces = mapOf(
        'Ы' to 'И', 'ы' to 'и',
        'Я' to 'А', 'я' to 'а',
        'Ю' to 'У', 'ю' to 'у',
    )
    val text = StringBuilder(File(inputName).readText())
    for (i in Regex("(?<=[ЖЧШЩжчшщ])[ЫЯЮыяю]").findAll(text).iterator()) {
        text[i.range.first] = replaces[text[i.range.first]]!!
    }
    writer.write(text.toString())
    writer.close()
}

/**
 * Средняя (15 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
    val writer = File(outputName).bufferedWriter()

    val lines = File(inputName).readLines().map { it.trim() }.toList()
    if (lines.isEmpty()) {
        writer.close()
        return
    }

    val maxLen = lines.maxOf { it.length }

    for (line in lines) {
        writer.write(" ".repeat((maxLen - line.length) / 2) + line + "\n")
    }
    writer.close()
}

/**
 * Сложная (20 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по левому и правому краю относительно
 * самой длинной строки.
 * Выравнивание производить, вставляя дополнительные пробелы между словами: равномерно по всей строке
 *
 * Слова внутри строки отделяются друг от друга одним или более пробелом.
 *
 * Следующие правила должны быть выполнены:
 * 1) Каждая строка входного и выходного файла не должна начинаться или заканчиваться пробелом.
 * 2) Пустые строки или строки из пробелов трансформируются в пустые строки без пробелов.
 * 3) Строки из одного слова выводятся без пробелов.
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых).
 *
 * Равномерность определяется следующими формальными правилами:
 * 5) Число пробелов между каждыми двумя парами соседних слов не должно отличаться более, чем на 1.
 * 6) Число пробелов между более левой парой соседних слов должно быть больше или равно числу пробелов
 *    между более правой парой соседних слов.
 *
 * Следует учесть, что входной файл может содержать последовательности из нескольких пробелов  между слвоами. Такие
 * последовательности следует учитывать при выравнивании и при необходимости избавляться от лишних пробелов.
 * Из этого следуют следующие правила:
 * 7) В самой длинной строке каждая пара соседних слов должна быть отделена В ТОЧНОСТИ одним пробелом
 * 8) Если входной файл удовлетворяет требованиям 1-7, то он должен быть в точности идентичен выходному файлу
 */
fun alignFileByWidth(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * Вернуть ассоциативный массив, содержащий 20 наиболее часто встречающихся слов с их количеством.
 * Если в тексте менее 20 различных слов, вернуть все слова.
 * Вернуть ассоциативный массив с числом слов больше 20, если 20-е, 21-е, ..., последнее слова
 * имеют одинаковое количество вхождений (см. также тест файла input/onegin.txt).
 *
 * Словом считается непрерывная последовательность из букв (кириллических,
 * либо латинских, без знаков препинания и цифр).
 * Цифры, пробелы, знаки препинания считаются разделителями слов:
 * Привет, привет42, привет!!! -привет?!
 * ^ В этой строчке слово привет встречается 4 раза.
 *
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 * Ключи в ассоциативном массиве должны быть в нижнем регистре.
 *
 */
fun top20Words(inputName: String): Map<String, Int> = TODO()

/**
 * Средняя (14 баллов)
 *
 * Реализовать транслитерацию текста из входного файла в выходной файл посредством динамически задаваемых правил.

 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * В ассоциативном массиве dictionary содержится словарь, в котором некоторым символам
 * ставится в соответствие строчка из символов, например
 * mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!")
 *
 * Необходимо вывести в итоговый файл с именем outputName
 * содержимое текста с заменой всех символов из словаря на соответствующие им строки.
 *
 * При этом регистр символов в словаре должен игнорироваться,
 * но при выводе символ в верхнем регистре отображается в строку, начинающуюся с символа в верхнем регистре.
 *
 * Пример.
 * Входной текст: Здравствуй, мир!
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Пример 2.
 *
 * Входной текст: Здравствуй, мир!
 * Словарь: mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!")
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun transliterate(inputName: String, dictionary: Map<Char, String>, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Во входном файле с именем inputName имеется словарь с одним словом в каждой строчке.
 * Выбрать из данного словаря наиболее длинное слово,
 * в котором все буквы разные, например: Неряшливость, Четырёхдюймовка.
 * Вывести его в выходной файл с именем outputName.
 * Если во входном файле имеется несколько слов с одинаковой длиной, в которых все буквы разные,
 * в выходной файл следует вывести их все через запятую.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 * Пример входного файла:
 * Карминовый
 * Боязливый
 * Некрасивый
 * Остроумный
 * БелогЛазый
 * ФиолетОвый

 * Соответствующий выходной файл:
 * Карминовый, Некрасивый
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun chooseLongestChaoticWord(inputName: String, outputName: String) {

    var max = 0
    val writer = File(outputName).bufferedWriter()
    val words = mutableListOf<String>()
    for (line in File(inputName).readLines()) {
        if (line.lowercase().toList().toSet().size == line.length) {
            if (line.length == max) words.add(line)
            else if (line.length > max) {
                words.clear()
                max = line.length
                words.add(line)
            }
        }
    }
    writer.write(words.joinToString())
    writer.close()
}


/**
 * Сложная (22 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе элементы текстовой разметки следующих типов:
 * - *текст в курсивном начертании* -- курсив
 * - **текст в полужирном начертании** -- полужирный
 * - ~~зачёркнутый текст~~ -- зачёркивание
 *
 * Следует вывести в выходной файл этот же текст в формате HTML:
 * - <i>текст в курсивном начертании</i>
 * - <b>текст в полужирном начертании</b>
 * - <s>зачёркнутый текст</s>
 *
 * Кроме того, все абзацы исходного текста, отделённые друг от друга пустыми строками, следует обернуть в теги <p>...</p>,
 * а весь текст целиком в теги <html><body>...</body></html>.
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 * Отдельно следует заметить, что открывающая последовательность из трёх звёздочек (***) должна трактоваться как "<b><i>"
 * и никак иначе.
 *
 * При решении этой и двух следующих задач полезно прочитать статью Википедии "Стек".
 *
 * Пример входного файла:
Lorem ipsum *dolor sit amet*, consectetur **adipiscing** elit.
Vestibulum lobortis, ~~Est vehicula rutrum *suscipit*~~, ipsum ~~lib~~ero *placerat **tortor***,

Suspendisse ~~et elit in enim tempus iaculis~~.
 *
 * Соответствующий выходной файл:
<html>
<body>
<p>
Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
</p>
<p>
Suspendisse <s>et elit in enim tempus iaculis</s>.
</p>
</body>
</html>
 *
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
enum class TagType { NONE, I, B, S }
data class Tag(val pos: Int, val type: TagType)

val htmlTagOpen = mapOf(
    TagType.NONE to "",
    TagType.I to "<i>",
    TagType.B to "<b>",
    TagType.S to "<s>",
)
val htmlTagClose = mapOf(
    TagType.NONE to "",
    TagType.I to "</i>",
    TagType.B to "</b>",
    TagType.S to "</s>",
)

fun insertTag(tags: Stack<Tag>, text: StringBuilder, tag: Tag) {
    if (tags.empty() || tags.peek().type != tag.type) {
        tags.push(Tag(tag.pos, tag.type))
        text.insert(tag.pos, htmlTagOpen[tag.type])
    } else {
        tags.pop()
        text.insert(tag.pos, htmlTagClose[tag.type])
    }
}

fun markdownToHtmlSimple(inputName: String, outputName: String) {
    val text = StringBuilder(File(inputName).readText())
    val writer = File(outputName).bufferedWriter()

    val tags = Stack<Tag>()

    for (tab in Regex("(?<!\\\\)\\\\t").findAll(text))
        text.replace(tab.range.first, tab.range.last + 1, "\t")
    for (newLine in Regex("(?<!\\\\)\\\\n").findAll(text))
        text.replace(newLine.range.first, newLine.range.last + 1, "\n")

    for (rawTag in Regex("(\\*{1,2})|(~~)").findAll(text)) {
        val value = rawTag.value
        text.delete(rawTag.range.first, rawTag.range.last + 1)
        when (value) {
            "**" -> insertTag(tags, text, Tag(rawTag.range.first, TagType.B))
            "*" -> insertTag(tags, text, Tag(rawTag.range.first, TagType.I))
            "~~" -> insertTag(tags, text, Tag(rawTag.range.first, TagType.S))
        }
    }

    writer.write("<html>\n")
    writer.write("<body>\n")
    writer.write("<p>\n")

    var firstLine = true
    val lines = text.lines()
    for (line in 0 until (lines.size - 1)) {
        if (lines[line].trim() == "") {
            if (lines[line + 1] != "" && !firstLine)
                writer.write("</p>\n<p>\n")
        } else {
            writer.write(lines[line] + "\n")
            firstLine = false
        }
    }
    if (lines.last() != "")
        writer.write(lines.last() + "\n")

    writer.write("</p>\n")
    writer.write("</body>\n")
    writer.write("</html>\n")

    writer.close()
}

/**
 * Сложная (23 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе набор вложенных друг в друга списков.
 * Списки бывают двух типов: нумерованные и ненумерованные.
 *
 * Каждый элемент ненумерованного списка начинается с новой строки и символа '*', каждый элемент нумерованного списка --
 * с новой строки, числа и точки. Каждый элемент вложенного списка начинается с отступа из пробелов, на 4 пробела большего,
 * чем список-родитель. Максимально глубина вложенности списков может достигать 6. "Верхние" списки файла начинаются
 * прямо с начала строки.
 *
 * Следует вывести этот же текст в выходной файл в формате HTML:
 * Нумерованный список:
 * <ol>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ol>
 *
 * Ненумерованный список:
 * <ul>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ul>
 *
 * Кроме того, весь текст целиком следует обернуть в теги <html><body><p>...</p></body></html>
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 *
 * Пример входного файла:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
 * Утка по-пекински
 * Утка
 * Соус
 * Салат Оливье
1. Мясо
 * Или колбаса
2. Майонез
3. Картофель
4. Что-то там ещё
 * Помидоры
 * Фрукты
1. Бананы
23. Яблоки
1. Красные
2. Зелёные
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 *
 *
 * Соответствующий выходной файл:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
<html>
<body>
<p>
<ul>
<li>
Утка по-пекински
<ul>
<li>Утка</li>
<li>Соус</li>
</ul>
</li>
<li>
Салат Оливье
<ol>
<li>Мясо
<ul>
<li>Или колбаса</li>
</ul>
</li>
<li>Майонез</li>
<li>Картофель</li>
<li>Что-то там ещё</li>
</ol>
</li>
<li>Помидоры</li>
<li>Фрукты
<ol>
<li>Бананы</li>
<li>Яблоки
<ol>
<li>Красные</li>
<li>Зелёные</li>
</ol>
</li>
</ol>
</li>
</ul>
</p>
</body>
</html>
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
enum class ListType { NONE, ORDERED, UNORDERED }

fun getListType(line: String): ListType {
    if (Regex("^\\s*\\d+\\.\\s").containsMatchIn(line)) return ListType.ORDERED
    else if (Regex("^\\s*\\*\\s").containsMatchIn(line)) return ListType.UNORDERED
    else return ListType.NONE
}

fun closeList(writer: BufferedWriter, listStack: Stack<ListType>) {
    writer.write(
        if (listStack.pop() == ListType.ORDERED) "</ol>" else "</ul>"
    )
    if (!listStack.empty())
        writer.write("</li>")
    writer.newLine()
}

fun openList(writer: BufferedWriter, listStack: Stack<ListType>, listType: ListType) {
    listStack.push(listType)
    writer.write(
        if (listType == ListType.ORDERED) "<ol>" else "<ul>"
    )
    writer.newLine()
}

fun markdownToHtmlLists(inputName: String, outputName: String) {
    val lines = File(inputName).readLines()
    val writer = File(outputName).bufferedWriter()
    val listStack = Stack<ListType>()

    writer.write("<html>\n")
    writer.write("<body>\n")
    writer.write("<p>\n")

    for (line in lines) {
        if (line == "") {
            if (!listStack.empty())
                writer.write("</li>")
            while (!listStack.empty())
                closeList(writer, listStack)
            writer.newLine()
            continue
        }

        val listType = getListType(line)
        if (listType != ListType.NONE) {
            val spaceCount = line.takeWhile { it == ' ' }.length

            // Manage lists
            if (spaceCount > (listStack.size - 1) * 4) {
                openList(writer, listStack, listType)
            } else {
                writer.write("</li>\n")

                if (spaceCount < (listStack.size - 1) * 4) {
                    while (spaceCount < (listStack.size - 1) * 4)
                        closeList(writer, listStack)
                } else if (listType != listStack.peek()) {
                    closeList(writer, listStack)
                    openList(writer, listStack, listType)
                }
            }
            // Manage lists

            // Add element
            val trimmedLine = line.substring(
                Regex("^\\s*((\\d+\\.)|(\\*))\\s").find(line)!!.range.last() + 1,
                line.length
            )
            writer.write("<li>$trimmedLine\n")
        } else {
            writer.write(line)
            writer.newLine()
        }
    }
    if (!listStack.empty())
        writer.write("</li>\n")
    while (!listStack.empty())
        closeList(writer, listStack)

    writer.write("</p>\n")
    writer.write("</body>\n")
    writer.write("</html>\n")

    writer.close()
}

/**
 * Очень сложная (30 баллов)
 *
 * Реализовать преобразования из двух предыдущих задач одновременно над одним и тем же файлом.
 * Следует помнить, что:
 * - Списки, отделённые друг от друга пустой строкой, являются разными и должны оказаться в разных параграфах выходного файла.
 *
 */
fun markdownToHtml(inputName: String, outputName: String) {
    markdownToHtmlLists(inputName, "temp1.txt")

    // Clear up <html><body><p> tags
    val writer = File("temp2.txt").bufferedWriter()
    for (line in File("temp1.txt").readLines()) {
        when (line) {
            // NOP
            "<html>" -> {}
            "<body>" -> {}
            "<p>" -> {}
            "</html>" -> {}
            "</body>" -> {}
            "</p>" -> {}

            else -> writer.write(line + "\n")
        }
    }
    writer.close()

    markdownToHtmlSimple("temp2.txt", outputName)

    File("temp1.txt").delete()
    File("temp2.txt").delete()
}

/**
 * Средняя (12 баллов)
 *
 * Вывести в выходной файл процесс умножения столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 111):
19935
 *    111
--------
19935
+ 19935
+19935
--------
2212785
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 * Нули в множителе обрабатывать так же, как и остальные цифры:
235
 *  10
-----
0
+235
-----
2350
 *
 */
fun printMultiplicationProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


/**
 * Сложная (25 баллов)
 *
 * Вывести в выходной файл процесс деления столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 22):
19935 | 22
-198     906
----
13
-0
--
135
-132
----
3

 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 *
 */

fun printDivisionProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


