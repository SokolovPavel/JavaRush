package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals(Object o) {
        //Рефлексивность: Объект должен равняться себе самому.
        if (this == o) return true;
        //Переданный объект должен являтся объектом класса Solution
        if (o == null || getClass() != o.getClass()) return false;

        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;

        //Симметричность: если a.equals(b) возвращает true, то b.equals(a) должен тоже вернуть true.
        //Транзитивность: если a.equals(b) возвращает true и b.equals тоже возвращает true, то c.equals тоже должен возвращать true.
        //Согласованность: повторный вызов метода equals() должен возвращать одно и тоже значение до тех пор, пока какое-либо значение свойств объекта не будет изменено.
        //Сравнение null: объект должны быть проверен на null. Если объект равен null, то метод должен вернуть false
        return (first != null ? first.equals(solution.first) : solution.first == null) && (last != null ? last.equals(solution.last) : solution.last == null);

        //if(o == null)return false;
        //if(this == o)return true;
        //if(!(o instanceof Solution))return false;
        //Solution n = (Solution)o;
        //return (n.last == null ? last == null : last.equals(n.last))&&(n.first == null ? first == null : first.equals(n.first));
    }

    public int hashCode() {
        int firstHashcode = first == null ? 0 : first.hashCode();
        int lastHashcode = last == null ? 0 : last.hashCode();
        return 31 * firstHashcode + lastHashcode;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", " "));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
