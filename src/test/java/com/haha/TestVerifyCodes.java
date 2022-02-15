package com.haha;

import com.haha.utils.VerifyCodeUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class TestVerifyCodes {

    @Test
    public void testGenerate() throws IOException {
        String s = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println("s = " + s);
        VerifyCodeUtils.outputImage(220, 80,
                new FileOutputStream(new File("D:\\Main\\JavaDemos\\ems/aa.png")), s);

    }
}
