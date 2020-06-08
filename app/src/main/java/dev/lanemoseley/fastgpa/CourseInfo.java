package dev.lanemoseley.fastgpa;

///
/// Author: Lane Moseley
/// Description: This file contains the courseInfo class.
/// This class holds the student's grade and the credit hours
/// for a single course.
///

public class CourseInfo {
    private String grade;
    private Double credits;

    CourseInfo( String grade, Double credits) {
        this.grade = grade;
        this.credits = credits;
    }

    String getGrade() {
        return grade;
    }

    Double getCredits() {
        return credits;
    }

    void setGrade(String grade) {
        this.grade = grade;
    }

    void setCredits(Double credits) {
        this.credits = credits;
    }
}
