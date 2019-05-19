/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.School.util;

import com.google.myanmartools.TransliterateU2Z;
import com.google.myanmartools.TransliterateZ2U;
import com.google.myanmartools.ZawgyiDetector;

/**
 *
 * @author myatko
 */
public class MyanmarFontManager {

    private static final ZawgyiDetector detector = new ZawgyiDetector();
    private static final TransliterateZ2U toUnicode = new TransliterateZ2U("Zawgyi to Unicode");
    private static final TransliterateU2Z toZawGyi = new TransliterateU2Z("Unicode to Zawgyi");
    private static double THRESHOLD = 0.2;

    public static String zawgyiToUnicode(String text) {
        double zawgyiProbability = detector.getZawgyiProbability(text);
        if (zawgyiProbability > 0.2) {
            return toUnicode.convert(text);
        } else {
            return text;
        }
    }

    public static String unicodeToZawgyi(String text) {
        return toZawGyi.convert(text);
    }
}
