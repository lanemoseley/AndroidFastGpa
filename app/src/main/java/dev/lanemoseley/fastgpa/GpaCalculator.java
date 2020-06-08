package dev.lanemoseley.fastgpa;
import java.util.HashMap;
import java.util.Vector;

///
/// Author: Lane Moseley
/// Description: This file contains the GPA calculator class.
/// This class does the work of calculating the user's GPA.
///

public class GpaCalculator {
    private final HashMap<String, Double> GRADE_MAP = new HashMap<String, Double>() {{
            put("-", -1.0);
            put("A", 4.0);
            put("A-", 3.7);
            put("B+", 3.3);
            put("B", 3.0);
            put("B-", 2.7);
            put("C+", 2.3);
            put("C", 2.0);
            put("C-", 1.7);
            put("D+", 1.3);
            put("D", 1.0);
            put("D-", 0.7);
            put("F", 0.0);
    }};

    private Double cumulative_gpa = 0.0;
    private Double new_cumulative_gpa = 0.0;
    private Double semester_hours = 0.0;
    private Double semester_points = 0.0;
    private Double total_hours = 0.0;

    GpaCalculator() { }

//    var cumulative_gpa: Double {
//        get { return _cumulative_gpa }
//        set { _cumulative_gpa = newValue }
//    }
//
//    var total_hours: Double {
//        get { return _total_hours }
//        set { _total_hours = newValue }
//    }

    Double getCumulativeGPA() {
        updateCumulative();
        return new_cumulative_gpa;
    }

    Double getGPA( Vector<CourseInfo> gradeInfo) {
        semester_points = 0.0;
        semester_hours = 0.0;

        for (CourseInfo i : gradeInfo) {
            Double grade = GRADE_MAP.get(i.getGrade());
            if (grade != null && grade > -1 && i.getCredits() > 0) {
                semester_hours += i.getCredits();
                semester_points += (i.getCredits() * grade);
            }
        }

        if (semester_hours == 0.0) { return 0.0; }

        updateCumulative();
        return semester_points / semester_hours;
    }

    void reset() {
        cumulative_gpa = 0.0;
        total_hours = 0.0;
    }

    void updateCumulative() {
        double t_points = ( total_hours * cumulative_gpa ) + semester_points;
        double t_hours = total_hours + semester_hours;
        new_cumulative_gpa = t_points / t_hours;
    }
}
