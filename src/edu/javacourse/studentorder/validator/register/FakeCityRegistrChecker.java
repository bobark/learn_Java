package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class FakeCityRegistrChecker implements CityRegisterChecker {
    private static final String hS = "1000";
    private static final String wS = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";


    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException {

        CityRegisterResponse res = new CityRegisterResponse();



        if (person instanceof Adult) {
            Adult t = (Adult) person;
            String ps = t.getPassportSeria();
            if (t.getPassportSeria().equals(hS) || t.getPassportSeria().equals(wS)) {
                res.setExisting(true);
                res.setTemporal(false);
            }

            if (t.getPassportSeria().equals(BAD_1) || t.getPassportSeria().equals(BAD_2)) {
                res.setExisting(false);
            }
            if (t.getPassportSeria().equals(ERROR_1) || t.getPassportSeria().equals(ERROR_2)) {
                CityRegisterException ex = new CityRegisterException("Fake ERROR " + ps);
                throw ex;
            }

        }

        if (person instanceof Child) {
            res.setExisting(true);
            res.setTemporal(true);
        }

        System.out.println(res);

        return res;
    }
}
