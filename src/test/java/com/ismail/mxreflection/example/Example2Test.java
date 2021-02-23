package com.ismail.mxreflection.example;

import com.ismail.mxreflection.annotations.Arg;
import com.ismail.mxreflection.annotations.Expression;
import com.ismail.mxreflection.core.Calculator;
import com.ismail.mxreflection.factory.MXFactory;
import org.junit.Test;

public class Example2Test {

    public class Example2{

        @Arg("f1")
        private String field1;

        @Arg("f2")
        private Long field2;

        @Expression("f2 - f1")
        @Arg("f3")
        private double field3;

        @Expression("f3 - f2")
        @Arg("f4")
        private double field4;

        @Expression("f1 - f2")
        @Arg("f5")
        private Double field5;

        @Expression("f4-f5")
        @Arg("f6")
        private String field6;

        @Expression("f6-f5")
        @Arg("f7")
        private long field7;

        @Expression("f7+5")
        private Long field8;
    }

    @Test
    public void exampleTest() {
        Example2 example2 = new Example2();
        example2.field1 = "2.2";
        example2.field2 = 5L;

        Calculator<Example2> calculator = MXFactory.createCalculator(Example2.class);
        calculator.calculate(example2);
        System.out.println("Field 3 result: " + example2.field3);
        System.out.println("Field 4 result: " + example2.field4);
        System.out.println("Field 5 result: " + example2.field5);
        System.out.println("Field 6 result: " + example2.field6);
        System.out.println("Field 7 result: " + example2.field7);
        System.out.println("Field 8 result: " + example2.field8);
    }
}
