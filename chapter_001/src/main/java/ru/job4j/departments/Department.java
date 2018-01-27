package ru.job4j.departments;


import java.util.*;

/**
 * Department class
 *
 * @author AKats
 */
public class Department implements Comparable<Department> {
    private List<String> departments;

    public List<String> getDepartments() {
        return departments;
    }

    public Department(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;
        return (this.getDepartments().containsAll(that.getDepartments()) && that.getDepartments().containsAll(this.getDepartments()));
    }

    @Override
    public int hashCode() {

        return Objects.hash(departments);
    }

    @Override
    public String toString() {
        String result = "";
        for (String dep : this.departments
                ) {
            result += dep + "\\";
        }
        return result.substring(0, result.length() - 1);
    }

    @Override
    public int compareTo(Department o) {
        Iterator diter1 = this.getDepartments().listIterator();
        Iterator diter2 = o.getDepartments().listIterator();
        while (diter1.hasNext() && diter2.hasNext()) {
            String d1 = (String) diter1.next();
            String d2 = (String) diter2.next();
            int compare = d1.compareTo(d2);
            if (compare != 0) {
                return compare;
            }
        }
        return this.getDepartments().size() - o.getDepartments().size();
    }


}
