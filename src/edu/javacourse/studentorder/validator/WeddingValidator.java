package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerWedding;
import edu.javacourse.studentorder.domain.StudentOrder;

public class WeddingValidator {
   public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Weddingcheck запущен");
        //edu.javacourse.studentorder.domain.AnswerWedding ans = new edu.javacourse.studentorder.domain.AnswerWedding();
        //ans.success = false;

        return new AnswerWedding();
    }

}
