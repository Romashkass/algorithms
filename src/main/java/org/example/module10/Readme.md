10_1 leetcode 199

10_2 leetcode 617

10_3 leetcode 700

10_4 leetcode 124

10_5 leetcode 112

test
1. c
2. b
3. d
4. c
5. b

questions
1. Дерево, где у каждого элемента не более 2 потомков 
и для каждого элемента все потомки в левом поддереве меньше, а в правом поддереве больше или равны этому элементу
2. + Выбираем корень дерева текущим элементом
   + Сравниваем значение для вставки с текущим элементом
   + Если значение меньше, то текущим элементом делаем левого соседа. Если больше или равно, то текущим элементом делаем правого соседа
   + Повторять пункты 2-3 до тех пор пока текущий элемент не будет отсутствовать. На это место и вставляем.
3. + Выбираем корень дерева текущим элементом
   + Сравниваем искомое значение с текущим элементом
   + Если значение равно, то нашли
   + Если значение меньше, то текущим элементом делаем левого соседа. Если больше, то текущим элементом делаем правого соседа
   + Повторять пункты 2-3 до нахождения или до обхода всех элементов.
4. + Найти удаляемый элемент.
   + Если у элемента нету потомков, просто удаляем его.
   + Если у элемента 1 потомок, то заменяем этот эемент на его потомка
   + Если у элемента 2 потомка, то выбираем наименьший элемент из правого поддерева и ставим его на место удаляемого элемента
5. Для каждого элемента все потомки в левом поддереве меньше, а в правом поддереве больше или равны этому элементу
