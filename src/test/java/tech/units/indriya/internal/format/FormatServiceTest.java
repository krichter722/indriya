/*
 * Units of Measurement Reference Implementation
 * Copyright (c) 2005-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385, Indriya nor the names of their contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tech.units.indriya.internal.format;

import static org.junit.jupiter.api.Assertions.*;
import static javax.measure.spi.FormatService.FormatType.*;
import java.util.List;

import javax.measure.spi.FormatService;
import javax.measure.spi.ServiceProvider;

import org.junit.jupiter.api.Test;

/**
 * Tests for services provided via {@link ServiceProvider}.
 */
public class FormatServiceTest {

  @Test
  public void testGetServices() throws Exception {
    List<ServiceProvider> services = ServiceProvider.available();
    assertNotNull(services);
    assertFalse(services.isEmpty());
    assertEquals(1, services.size());
  }

  @Test
  public void testGetService() throws Exception {
    FormatService fs = ServiceProvider.current().getFormatService();
    assertNotNull(fs);
    assertNotNull(fs.getUnitFormat());
    assertEquals("DefaultFormat", fs.getUnitFormat().getClass().getSimpleName());
  }

  @Test
  public void testGetUnitFormatFound() throws Exception {
    final FormatService fs = ServiceProvider.current().getFormatService();
    assertNotNull(fs);
    assertNotNull(fs.getUnitFormat("EBNF"));
  }

  @Test
  public void testGetUnitFormatNotFound() throws Exception {
    final FormatService fs = ServiceProvider.current().getFormatService();
    assertNotNull(fs);
    assertNull(fs.getUnitFormat("XYZ"));
  }

  @Test
  public void testGetUnitFormatNames() throws Exception {
    final FormatService fs = ServiceProvider.current().getFormatService();
    assertNotNull(fs);
    assertEquals(4, fs.getAvailableFormatNames(UNIT_FORMAT).size());
  }

  @Test
  public void testGetQuantityFormatFound() throws Exception {
    final FormatService fs = ServiceProvider.current().getFormatService();
    assertNotNull(fs);
    assertNotNull(fs.getQuantityFormat("Simple"));
  }

  @Test
  public void testGetQuantityFormatNotFound() throws Exception {
    final FormatService fs = ServiceProvider.current().getFormatService();
    assertNotNull(fs);
    assertNull(fs.getQuantityFormat("XYZ"));
  }

  @Test
  public void testGetQuantityFormatNames() throws Exception {
    final FormatService fs = ServiceProvider.current().getFormatService();
    assertNotNull(fs);
    assertEquals(3, fs.getAvailableFormatNames(QUANTITY_FORMAT).size());
  }
}
