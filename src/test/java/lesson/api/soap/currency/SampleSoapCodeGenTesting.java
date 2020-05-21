package lesson.api.soap.currency;

import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleSoapCodeGenTesting {

    @Test
    public void test() {
        CountryInfoService cis = new CountryInfoService();
        String actualCurrency = cis.getCountryInfoServiceSoap().currencyName("RUB");
        Assert.assertEquals(actualCurrency, "Rubles");
    }
}
