package com.gradle.gradle.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.gradle.gradle.util.UtilForPhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilPhoneTest {
    @Test
    void reformatRuPhoneRemoveWhiteSpaces() throws NumberParseException {
        String removeWhiteSpaces = UtilForPhoneNumber.reformatRuTelephone("+7(999)222-33-11");
        assertEquals("+79992223311", removeWhiteSpaces);
        removeWhiteSpaces = UtilForPhoneNumber.reformatRuTelephone("+7-999-222-33-11");
        assertEquals("+79992223311", removeWhiteSpaces);
        removeWhiteSpaces = UtilForPhoneNumber.reformatRuTelephone("+7(999)222-33-11");
        assertEquals("+79992223311", removeWhiteSpaces);
        removeWhiteSpaces = UtilForPhoneNumber.reformatRuTelephone("+7(999)    222 - 33  -  11");
        assertEquals("+79992223311", removeWhiteSpaces);
        removeWhiteSpaces = UtilForPhoneNumber.reformatRuTelephone("+78008888888");
        assertEquals("+78008888888", removeWhiteSpaces);
    }

    @Test
    void reformatRuTelephoneRemoveNotRu() {
        Assertions.assertThrows(Exception.class, () -> UtilForPhoneNumber.reformatRuTelephone("+9(999)222-33-11"));
        Assertions.assertThrows(Exception.class, () -> UtilForPhoneNumber.reformatRuTelephone("+7(899)222-33-11"));
    }

    @Test
    void reformatRuTelephoneRemoveNotTelephone() {
        Assertions.assertThrows(Exception.class, () -> UtilForPhoneNumber.reformatRuTelephone("+cdvbgfcdxdsaxd"));
        Assertions.assertThrows(Exception.class, () -> UtilForPhoneNumber.reformatRuTelephone("+7(ddddd899)222-33-11"));
        Assertions.assertThrows(Exception.class, () -> UtilForPhoneNumber.reformatRuTelephone("+7000000899)2-0-----0999922-33-11"));
        Assertions.assertThrows(Exception.class, () -> UtilForPhoneNumber.reformatRuTelephone("+70000008900000000000000000000"));
    }
}
