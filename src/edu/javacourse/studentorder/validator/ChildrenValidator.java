package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.children.AnswerChildren;
import edu.javacourse.studentorder.domain.StudentOrder;

public class ChildrenValidator {
   public AnswerChildren checkChilden(StudentOrder so) {
        System.out.println("Childen check запущен");
        // edu.javacourse.studentorder.domain.children.AnswerChildren ans = new edu.javacourse.studentorder.domain.children.AnswerChildren();
        // ans.success = false;
        return new AnswerChildren();
    }
}
