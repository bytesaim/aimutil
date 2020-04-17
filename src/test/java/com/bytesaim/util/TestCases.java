package com.bytesaim.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Adewale Azeez <azeezadewale98@gmail.com>
 */
public class TestCases {

    @Test
    public void Test1() {
        Assert.assertEquals(1, 0);
        Assert.assertEquals(2, 2);
    }

    @Test
    public void Test2() {
        Assert.assertEquals(12, 11);
        Assert.assertEquals(12, 121);
    }

}
