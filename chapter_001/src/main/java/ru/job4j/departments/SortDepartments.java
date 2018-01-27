package ru.job4j.departments;

import java.lang.annotation.Documented;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to sort Departments array
 *
 * @author AKats
 */
public class SortDepartments {

    Set<Department> departments;

    /**
     * Constructing new TreeSet of Department objects based on String array.
     * Each element of array is nested code in this form K1\\SK2\\SSK3 (numbers could be different)
     * It is allowed not to pass codes for the upper-level subdivision
     * for example {K2\\SK1\\SSK32} instead of {K2, K2\\SK1, K2\\SK1\\SSK32}
     * in thad case absent codes will be constructed anyway.
     *
     * @param departments - String array of departments codes
     */
    public SortDepartments(String[] departments) {
        Set<Department> result = new TreeSet<>();
        for (String department : departments
                ) {
            List<String> depnames = new ArrayList<>(Arrays.asList(department.split("\\\\")));
            result.add(new Department(new LinkedList<>(depnames)));
            int size = depnames.size();
            for (int i = 0; i < size - 1; i++) {
                depnames.remove(size - i - 1);
                result.add(new Department(new LinkedList<>(depnames)));
            }
        }

        this.departments = result;
    }


    /**
     * Get sorted array of department codes
     *
     * @return - sorted array of department codes
     */
    public String[] getSortedDepartments() {
        String[] res = new String[this.departments.size()];
        Department[] departmentsArray = this.departments.toArray(new Department[0]);
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(departmentsArray[i]);
        }
        return res;
    }
    /**
     * Get sorted array of department codes in descending
     *
     * @return - sorted array of department codes in descending
     */
    public String[] getReverseSortedDepartments() {
        List<Department> resList = new ArrayList<>(this.departments);
        resList.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                Iterator diter1 = o2.getDepartments().listIterator();
                Iterator diter2 = o1.getDepartments().listIterator();
                while (diter1.hasNext() && diter2.hasNext()) {
                    String d1 = (String) diter1.next();
                    String d2 = (String) diter2.next();
                    int compare = d1.compareTo(d2);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return o1.getDepartments().size() - o2.getDepartments().size();
            }
        });
        String[] res = new String[this.departments.size()];
        Department[] departmentsArray = resList.toArray(new Department[0]);
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(departmentsArray[i]);
        }
        return res;
    }
}
