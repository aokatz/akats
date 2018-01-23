package ru.job4j.departments;

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
     * where K - is department, SK - is service unit, SSK - division.
     * It is allowed not to pass codes for the upper-level subdivision
     * for example {K2\\SK1\\SSK32} instead of {K2, K2\\SK1, K2\\SK1\\SSK32}
     * in thad case absent codes will be constructed anyway.
     *
     * @param departments - String array of departments codes
     */
    public SortDepartments(String[] departments) {
        Set<Department> result = new TreeSet<>();
        Pattern departmentPattern = Pattern.compile("^(K\\d+)(?:\\\\)?(SK\\d+)?(?:\\\\)?(SSK\\d+)?$");
        for (String department : departments
                ) {
            Matcher departmentMatcher = departmentPattern.matcher(department);
            if (departmentMatcher.matches()) {
                String departmentName = departmentMatcher.group(1);
                String serviceName = (departmentMatcher.group(2) == null) ? "" : departmentMatcher.group(2);
                String divisionName = (departmentMatcher.group(3) == null) ? "" : departmentMatcher.group(3);
                result.add(new Department(departmentName, serviceName, divisionName));
                result.add(new Department(departmentName, serviceName));
                result.add(new Department(departmentName));
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
                if (o2.getDepartmentName().equals(o1.getDepartmentName())) {
                    if (o2.getServiceName().equals(o1.getServiceName())) {
                        return (o2.getDivisionName().length() == 0) ? 1 : o2.getDivisionName().compareTo(o1.getDivisionName());
                    } else {
                        return (o2.getServiceName().length() == 0) ? 1 : o2.getServiceName().compareTo(o1.getServiceName());
                    }
                }
                return o2.getDepartmentName().compareTo(o1.getDepartmentName());
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
