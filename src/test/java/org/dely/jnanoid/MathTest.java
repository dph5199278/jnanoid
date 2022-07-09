package org.dely.jnanoid;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author fishzhao
 * @since 2022-05-06
 */
public class MathTest {

  private static int slowLog2(int x, RoundingMode roundingMode) {
    double value = java.lang.Math.log(x) / java.lang.Math.log(2);
    return BigDecimal.valueOf(value).setScale(0, roundingMode).intValue();
  }

  @Test
  public void Math_enum_isPowerOf2_Verified() {
    assertTrue(Math.INSTANCE.isPowerOfTwo(1));
    assertTrue(Math.INSTANCE.isPowerOfTwo(2));
    assertTrue(Math.INSTANCE.isPowerOfTwo(4));
    assertTrue(Math.INSTANCE.isPowerOfTwo(256));
    assertTrue(Math.INSTANCE.isPowerOfTwo(1 << 15));

    assertFalse(Math.INSTANCE.isPowerOfTwo(3));
    assertFalse(Math.INSTANCE.isPowerOfTwo(5));
    assertFalse(Math.INSTANCE.isPowerOfTwo(456721));
    assertFalse(Math.INSTANCE.isPowerOfTwo(-99));
  }

  @Test
  public void Math_enum_log2_Verified() {
    final RoundingMode[] roundingModes = RoundingMode.values();
    for (int i = 2; i < 256; ++i) {
      for (RoundingMode roundingMode : roundingModes) {
        if (roundingMode != RoundingMode.UNNECESSARY)
          assertEquals(slowLog2(i, roundingMode), Math.INSTANCE.log2(i, roundingMode));
      }
    }
    for (int i = 0; i < Integer.SIZE - 1; ++i) {
      assertEquals(i, Math.INSTANCE.log2(1 << i, RoundingMode.UNNECESSARY));
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void log2_negativeNumber_ExceptionThrown() {
    Math.INSTANCE.log2(-99, RoundingMode.FLOOR);
  }

  @Test(expected = ArithmeticException.class)
  public void log2_roundingMode_ExceptionThrown() {
    Math.INSTANCE.log2(1821, RoundingMode.UNNECESSARY);
  }

  @Test
  public void test_log_time() {
    final RoundingMode[] roundingModes = RoundingMode.values();
    long time = System.nanoTime();
    for (int i = 2; i < 256; ++i) {
      for (RoundingMode roundingMode : roundingModes) {
        if (roundingMode != RoundingMode.UNNECESSARY)
          Math.INSTANCE.log2(i, roundingMode);
      }
    }

    long log2Time = System.nanoTime();
    System.out.printf("Log2:%d%n", log2Time - time);
    log2Time = System.nanoTime();

    for (int i = 2; i < 256; ++i) {
      for (RoundingMode roundingMode : roundingModes) {
        if (roundingMode != RoundingMode.UNNECESSARY)
          slowLog2(i, roundingMode);
      }
    }

    System.out.printf("SlowLog2:%d%n", System.nanoTime() - log2Time);
  }
}
