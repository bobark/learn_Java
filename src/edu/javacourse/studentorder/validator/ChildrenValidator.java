package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerChildren;
import edu.javacourse.studentorder.domain.StudentOrder;

public class ChildrenValidator {
   public AnswerChildren checkChilden(StudentOrder so) {
        System.out.println("Childen check запущен");
        // edu.javacourse.studentorder.domain.AnswerChildren ans = new edu.javacourse.studentorder.domain.AnswerChildren();
        // ans.success = false;
        return new AnswerChildren();
    }
}
