package com.test2.demos.demo7.test4;

import java.awt.*;

/**
 * Created by thinkpad on 2018/1/31.
 */
public class FontFamilyNames {
    String allFontNames[];
    public String [] getFontName(){
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        allFontNames=ge.getAvailableFontFamilyNames();
        return allFontNames;
    }
}
