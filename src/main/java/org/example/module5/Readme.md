зачем писать псевдокод, когда можно написать код?

test

questions
1. Поиск i-того наибольшего(наименьшего) элемента в неотсортированном массиве
2. Для поиска i-того наибольшего(наименьшего) элемента в неотсортированном массиве
   + Выбирается опорый элемент случайным образом
   + Массив разделяется на 2 части, больше и меньше опорного
   + Если опорный оказался на i-той позиции, то это результат
   + Если оказался на позиции j>i, то рекурсивный вызов на левую часть массива с тем же i
   + Если оказался на позиции j<i, то рекурсивный вызов на правую часть массива с newI = i - j
3. В выборе опорного элемента, в RSelect опорный выбирается случайным образом, 
в DSelect опорный выбирается как медиана медиан массивов по 5 элементов
4. + Выбирается опорый элемент
      + Исходный массив делится на массивы по 5 элементов
      + В каждом из этих массивов ищется медианный элемент
      + Потом рекурсивным вызовом среди этих n/5 элементов ищется медианный, который станет опорным
    + Массив разделяется на 2 части, больше и меньше опорного
    + Если опорный оказался на i-той позиции, то это результат
    + Если оказался на позиции j>i, то рекурсивный вызов на левую часть массива с тем же i
    + Если оказался на позиции j<i, то рекурсивный вызов на правую часть массива с newI = i - j
5. + RSelect:
     + Когда выделение дополнительной памяти является проблемой, 
     а время выполнения не особо важно( в худшем случае O(n^2)) 
   + DSelect:
     + Когда выделение дополнительной памяти не проблема
6. i-я порядковая статистика — i-e наименьшее значение в массиве. (q2, q4)
7. + RSelect:
     + В среднем O(n)
     + Худший случай O(n^2)
   + DSelect:
     + O(n), но с большой константой
8. Если выбрать плохой элемент в RSelect, то время реботы будет O(n^2), а не O(n)
9. Исходный массив делится на части, после чего происходит рекурсивный вызов на одну из частей, 
в зависимости от позиции опорного элемента, до тех пор пока не будет найдено решение исходной задачи
10. (q2, q4)
11. + RSelect:
      + Выполняется на месте, не требует доп памяти
      + Есть худший случай в котором время выполнения O(n^2)
    + DSelect:
      + Время выполнения всегда O(n), но с большой константой
      + Требует доп память
12. Время выполнения не зависит от рандома
13. Поскольку поиск медианы происходит для количества, не зависящего от общего числа элементов, 
то это можно считать за константное время выполнения
14. (q8)