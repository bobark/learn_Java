package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.student.AnswerStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentValidator {

     public AnswerStudent checkStudent (StudentOrder so) {
        System.out.println("Student check запущен");
        //edu.javacourse.studentorder.domain.student.AnswerStudent ans = new edu.javacourse.studentorder.domain.student.AnswerStudent();
        //ans.success = false;
        return new AnswerStudent();
    }
}
