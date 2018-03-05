package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12()
            .getGeoIP("93.72.198.117");
    assertEquals(geoIP.getCountryCode(), "UKR");
  }

//  @Test
//  public void testInvalidIp(){
//    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12()
//            .getGeoIP("93.72.198.xxx");
//    assertEquals(geoIP.getCountryCode(), "UKR");
//  }
}
