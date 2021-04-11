package by.sheremet.logic;

import java.util.List;

public class Salary {
    public double averageSalary(List<Integer> integers){
        int sumSalary=0;
        double average;
        for (Integer integer : integers) {
            sumSalary+=integer;
            System.out.println(sumSalary);
        }
        average=sumSalary/integers.size();
        return average;
    }
}
