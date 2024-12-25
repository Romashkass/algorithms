8_1 https://education.yandex.ru/handbook/algorithms/article/zadacha-poiska-kratchajshego-puti-v-grafe

8_2 https://education.yandex.ru/handbook/algorithms/article/zadacha-poiska-kratchajshego-puti-v-grafe

8_3 которая?

8_4 leetcode 743

8_5 leetcode 1334

test
1. b
2. c
3. b
4. a
5. c

questions
1. Алгоритм для поиска кратчайшего пути во взвешенном графе. O((V^2) + E), где V - кол-во вершин, E - кол-во ребер
2. + Происвоение всем вершинам графа максимальной дальности(в идеале +INF), стартовой вершине присвоение 0
   + Все вершины не посещены
   + Выбирается вершина из не посещенных, с наименьшей дальностью. 
   + Для нее просматриваются соседние не посещенные вершины и для всех вычисляется 
   новая дальность = дальность текущей вершины + вес ребра до соседа
   + если новая дальность < старой дальности соседа, дальность соседа обновляется
   + повторить с п3 до тех пор пока все вершины не посещены или дальность текущей вершины != +INF
3. Не может быть использован если присутствуют отрицательные веса ребер
4. O((V^2) + E), если использовать для хранения непосещенных элементов очередь с приоритетом, 
в которой удаление происходит за O(log n), то O(nlogn + m)
5. Некорректно
6. ?
7. A*, учитывает направление движения; Беллмана-Форда - отрицательные веса разрешены, 