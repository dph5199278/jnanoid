package org.dely.jnanoid;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author fishzhao
 * @since 2022-05-06
 */
public class InstantTest {

  private static <T> T instant(Class<? extends T> type) throws Exception {
    final Constructor<? extends T> declaredConstructor = type.getDeclaredConstructor();
    declaredConstructor.setAccessible(true);
    return declaredConstructor.newInstance();
  }

  @Test(expected = Exception.class)
  public void MathUtils_Instant_ExceptionThrown() throws Exception {
    instant(Math.class);
  }

  @Test(expected = Exception.class)
  public void NanoIdUtils_Instant_ExceptionThrown() throws Exception {
    instant(NanoId.class);
  }
}