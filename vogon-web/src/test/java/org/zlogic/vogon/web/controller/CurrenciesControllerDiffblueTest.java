package org.zlogic.vogon.web.controller;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.zlogic.vogon.web.data.model.CurrencyDetails;

@ContextConfiguration(classes = {CurrenciesController.class})
@RunWith(SpringRunner.class)
public class CurrenciesControllerDiffblueTest {
    @Autowired
    private CurrenciesController currenciesController;

    @Test
    public void testCurrencies() {
        Collection<CurrencyDetails> actualCurrenciesResult = this.currenciesController.currencies();
        assertEquals(228, actualCurrenciesResult.size());
        assertEquals("Algerian Dinar", ((List<CurrencyDetails>) actualCurrenciesResult).get(5).getDisplayName());
        assertEquals("ZWN", ((List<CurrencyDetails>) actualCurrenciesResult).get(222).getDisplayName());
        assertEquals("AFN", ((List<CurrencyDetails>) actualCurrenciesResult).get(2).getCurrencyCode());
        assertEquals("ZWR", ((List<CurrencyDetails>) actualCurrenciesResult).get(226).getCurrencyCode());
        assertEquals("ZWD", ((List<CurrencyDetails>) actualCurrenciesResult).get(225).getCurrencyCode());
        assertEquals("ALL", ((List<CurrencyDetails>) actualCurrenciesResult).get(4).getCurrencyCode());
        assertEquals("ZMK", ((List<CurrencyDetails>) actualCurrenciesResult).get(224).getCurrencyCode());
        assertEquals("ZMW", ((List<CurrencyDetails>) actualCurrenciesResult).get(223).getCurrencyCode());
        assertEquals("AFA", ((List<CurrencyDetails>) actualCurrenciesResult).get(3).getCurrencyCode());
        assertEquals("AYM", ((List<CurrencyDetails>) actualCurrenciesResult).get(1).getCurrencyCode());
        assertEquals("ZWL", ((List<CurrencyDetails>) actualCurrenciesResult).get(227).getCurrencyCode());
        assertEquals("XUA", ((List<CurrencyDetails>) actualCurrenciesResult).get(0).getCurrencyCode());
    }

    @Test
    public void testGetAllCurrencies() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/service/currencies");
        MockMvcBuilders.standaloneSetup(this.currenciesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"displayName\":\"ADB Unit of Account\",\"currencyCode\":\"XUA\"},{\"displayName\":\"AYM\",\"currencyCode\":\"AYM"
                                        + "\"},{\"displayName\":\"Afghan Afghani\",\"currencyCode\":\"AFN\"},{\"displayName\":\"Afghan Afghani (1927–2002)\""
                                        + ",\"currencyCode\":\"AFA\"},{\"displayName\":\"Albanian Lek\",\"currencyCode\":\"ALL\"},{\"displayName\":\"Algerian"
                                        + " Dinar\",\"currencyCode\":\"DZD\"},{\"displayName\":\"Andorran Peseta\",\"currencyCode\":\"ADP\"},{\"displayName\":\"Angolan"
                                        + " Kwanza\",\"currencyCode\":\"AOA\"},{\"displayName\":\"Argentine Peso\",\"currencyCode\":\"ARS\"},{\"displayName\":\"Armenian"
                                        + " Dram\",\"currencyCode\":\"AMD\"},{\"displayName\":\"Aruban Florin\",\"currencyCode\":\"AWG\"},{\"displayName\":\"Australian"
                                        + " Dollar\",\"currencyCode\":\"AUD\"},{\"displayName\":\"Austrian Schilling\",\"currencyCode\":\"ATS\"},{\"displayName"
                                        + "\":\"Azerbaijani Manat\",\"currencyCode\":\"AZN\"},{\"displayName\":\"Azerbaijani Manat (1993–2006)\",\"currencyCode"
                                        + "\":\"AZM\"},{\"displayName\":\"Bahamian Dollar\",\"currencyCode\":\"BSD\"},{\"displayName\":\"Bahraini Dinar\","
                                        + "\"currencyCode\":\"BHD\"},{\"displayName\":\"Bangladeshi Taka\",\"currencyCode\":\"BDT\"},{\"displayName\":\"Barbadian"
                                        + " Dollar\",\"currencyCode\":\"BBD\"},{\"displayName\":\"Belarusian New Rouble (1994–1999)\",\"currencyCode\":\"BYB"
                                        + "\"},{\"displayName\":\"Belarusian Rouble\",\"currencyCode\":\"BYN\"},{\"displayName\":\"Belarusian Rouble"
                                        + " (2000–2016)\",\"currencyCode\":\"BYR\"},{\"displayName\":\"Belgian Franc\",\"currencyCode\":\"BEF\"},{\"displayName"
                                        + "\":\"Belize Dollar\",\"currencyCode\":\"BZD\"},{\"displayName\":\"Bermudan Dollar\",\"currencyCode\":\"BMD\"},{"
                                        + "\"displayName\":\"Bhutanese Ngultrum\",\"currencyCode\":\"BTN\"},{\"displayName\":\"Bolivian Boliviano\",\"currencyCode"
                                        + "\":\"BOB\"},{\"displayName\":\"Bolivian Mvdol\",\"currencyCode\":\"BOV\"},{\"displayName\":\"Bosnia-Herzegovina"
                                        + " Convertible Mark\",\"currencyCode\":\"BAM\"},{\"displayName\":\"Botswanan Pula\",\"currencyCode\":\"BWP\"},{"
                                        + "\"displayName\":\"Brazilian Real\",\"currencyCode\":\"BRL\"},{\"displayName\":\"British Pound\",\"currencyCode\":"
                                        + "\"GBP\"},{\"displayName\":\"Brunei Dollar\",\"currencyCode\":\"BND\"},{\"displayName\":\"Bulgarian Hard Lev\","
                                        + "\"currencyCode\":\"BGL\"},{\"displayName\":\"Bulgarian Lev\",\"currencyCode\":\"BGN\"},{\"displayName\":\"Burundian"
                                        + " Franc\",\"currencyCode\":\"BIF\"},{\"displayName\":\"CFP Franc\",\"currencyCode\":\"XPF\"},{\"displayName\":\"Cambodian"
                                        + " Riel\",\"currencyCode\":\"KHR\"},{\"displayName\":\"Canadian Dollar\",\"currencyCode\":\"CAD\"},{\"displayName\":\"Cape"
                                        + " Verdean Escudo\",\"currencyCode\":\"CVE\"},{\"displayName\":\"Cayman Islands Dollar\",\"currencyCode\":\"KYD\"},"
                                        + "{\"displayName\":\"Central African CFA Franc\",\"currencyCode\":\"XAF\"},{\"displayName\":\"Chilean Peso\","
                                        + "\"currencyCode\":\"CLP\"},{\"displayName\":\"Chilean Unit of Account (UF)\",\"currencyCode\":\"CLF\"},{\"displayName"
                                        + "\":\"Chinese Yuan\",\"currencyCode\":\"CNY\"},{\"displayName\":\"Colombian Peso\",\"currencyCode\":\"COP\"},{\"displayName"
                                        + "\":\"Colombian Real Value Unit\",\"currencyCode\":\"COU\"},{\"displayName\":\"Comorian Franc\",\"currencyCode\":"
                                        + "\"KMF\"},{\"displayName\":\"Congolese Franc\",\"currencyCode\":\"CDF\"},{\"displayName\":\"Costa Rican Colón\","
                                        + "\"currencyCode\":\"CRC\"},{\"displayName\":\"Croatian Kuna\",\"currencyCode\":\"HRK\"},{\"displayName\":\"Cuban"
                                        + " Convertible Peso\",\"currencyCode\":\"CUC\"},{\"displayName\":\"Cuban Peso\",\"currencyCode\":\"CUP\"},{\"displayName"
                                        + "\":\"Cypriot Pound\",\"currencyCode\":\"CYP\"},{\"displayName\":\"Czech Koruna\",\"currencyCode\":\"CZK\"},{\"displayName"
                                        + "\":\"Danish Krone\",\"currencyCode\":\"DKK\"},{\"displayName\":\"Djiboutian Franc\",\"currencyCode\":\"DJF\"},{"
                                        + "\"displayName\":\"Dominican Peso\",\"currencyCode\":\"DOP\"},{\"displayName\":\"Dutch Guilder\",\"currencyCode\":"
                                        + "\"NLG\"},{\"displayName\":\"East Caribbean Dollar\",\"currencyCode\":\"XCD\"},{\"displayName\":\"Egyptian"
                                        + " Pound\",\"currencyCode\":\"EGP\"},{\"displayName\":\"Eritrean Nakfa\",\"currencyCode\":\"ERN\"},{\"displayName\":\"Estonian"
                                        + " Kroon\",\"currencyCode\":\"EEK\"},{\"displayName\":\"Ethiopian Birr\",\"currencyCode\":\"ETB\"},{\"displayName\":"
                                        + "\"Euro\",\"currencyCode\":\"EUR\"},{\"displayName\":\"European Composite Unit\",\"currencyCode\":\"XBA\"},{\"displayName"
                                        + "\":\"European Monetary Unit\",\"currencyCode\":\"XBB\"},{\"displayName\":\"European Unit of Account (XBC)\","
                                        + "\"currencyCode\":\"XBC\"},{\"displayName\":\"European Unit of Account (XBD)\",\"currencyCode\":\"XBD\"},{\"displayName"
                                        + "\":\"Falkland Islands Pound\",\"currencyCode\":\"FKP\"},{\"displayName\":\"Fijian Dollar\",\"currencyCode\":\"FJD\""
                                        + "},{\"displayName\":\"Finnish Markka\",\"currencyCode\":\"FIM\"},{\"displayName\":\"French Franc\",\"currencyCode\""
                                        + ":\"FRF\"},{\"displayName\":\"French Gold Franc\",\"currencyCode\":\"XFO\"},{\"displayName\":\"French UIC-Franc\","
                                        + "\"currencyCode\":\"XFU\"},{\"displayName\":\"Gambian Dalasi\",\"currencyCode\":\"GMD\"},{\"displayName\":\"Georgian"
                                        + " Lari\",\"currencyCode\":\"GEL\"},{\"displayName\":\"German Mark\",\"currencyCode\":\"DEM\"},{\"displayName\":\"Ghanaian"
                                        + " Cedi\",\"currencyCode\":\"GHS\"},{\"displayName\":\"Ghanaian Cedi (1979–2007)\",\"currencyCode\":\"GHC\"},{"
                                        + "\"displayName\":\"Gibraltar Pound\",\"currencyCode\":\"GIP\"},{\"displayName\":\"Gold\",\"currencyCode\":\"XAU\"},{"
                                        + "\"displayName\":\"Greek Drachma\",\"currencyCode\":\"GRD\"},{\"displayName\":\"Guatemalan Quetzal\",\"currencyCode"
                                        + "\":\"GTQ\"},{\"displayName\":\"Guinea-Bissau Peso\",\"currencyCode\":\"GWP\"},{\"displayName\":\"Guinean Franc\","
                                        + "\"currencyCode\":\"GNF\"},{\"displayName\":\"Guyanaese Dollar\",\"currencyCode\":\"GYD\"},{\"displayName\":\"Haitian"
                                        + " Gourde\",\"currencyCode\":\"HTG\"},{\"displayName\":\"Honduran Lempira\",\"currencyCode\":\"HNL\"},{\"displayName\":\"Hong"
                                        + " Kong Dollar\",\"currencyCode\":\"HKD\"},{\"displayName\":\"Hungarian Forint\",\"currencyCode\":\"HUF\"},{\"displayName"
                                        + "\":\"Icelandic Króna\",\"currencyCode\":\"ISK\"},{\"displayName\":\"Indian Rupee\",\"currencyCode\":\"INR\"},{"
                                        + "\"displayName\":\"Indonesian Rupiah\",\"currencyCode\":\"IDR\"},{\"displayName\":\"Iranian Rial\",\"currencyCode\""
                                        + ":\"IRR\"},{\"displayName\":\"Iraqi Dinar\",\"currencyCode\":\"IQD\"},{\"displayName\":\"Irish Pound\",\"currencyCode"
                                        + "\":\"IEP\"},{\"displayName\":\"Israeli New Shekel\",\"currencyCode\":\"ILS\"},{\"displayName\":\"Italian Lira\","
                                        + "\"currencyCode\":\"ITL\"},{\"displayName\":\"Jamaican Dollar\",\"currencyCode\":\"JMD\"},{\"displayName\":\"Japanese"
                                        + " Yen\",\"currencyCode\":\"JPY\"},{\"displayName\":\"Jordanian Dinar\",\"currencyCode\":\"JOD\"},{\"displayName\":"
                                        + "\"Kazakhstani Tenge\",\"currencyCode\":\"KZT\"},{\"displayName\":\"Kenyan Shilling\",\"currencyCode\":\"KES\"},{"
                                        + "\"displayName\":\"Kuwaiti Dinar\",\"currencyCode\":\"KWD\"},{\"displayName\":\"Kyrgystani Som\",\"currencyCode\":"
                                        + "\"KGS\"},{\"displayName\":\"Laotian Kip\",\"currencyCode\":\"LAK\"},{\"displayName\":\"Latvian Lats\",\"currencyCode"
                                        + "\":\"LVL\"},{\"displayName\":\"Lebanese Pound\",\"currencyCode\":\"LBP\"},{\"displayName\":\"Lesotho Loti\",\"currencyCode"
                                        + "\":\"LSL\"},{\"displayName\":\"Liberian Dollar\",\"currencyCode\":\"LRD\"},{\"displayName\":\"Libyan Dinar\","
                                        + "\"currencyCode\":\"LYD\"},{\"displayName\":\"Lithuanian Litas\",\"currencyCode\":\"LTL\"},{\"displayName\":\"Luxembourgian"
                                        + " Franc\",\"currencyCode\":\"LUF\"},{\"displayName\":\"Macanese Pataca\",\"currencyCode\":\"MOP\"},{\"displayName\":"
                                        + "\"Macedonian Denar\",\"currencyCode\":\"MKD\"},{\"displayName\":\"Malagasy Ariary\",\"currencyCode\":\"MGA\"},{"
                                        + "\"displayName\":\"Malagasy Franc\",\"currencyCode\":\"MGF\"},{\"displayName\":\"Malawian Kwacha\",\"currencyCode\""
                                        + ":\"MWK\"},{\"displayName\":\"Malaysian Ringgit\",\"currencyCode\":\"MYR\"},{\"displayName\":\"Maldivian Rufiyaa\","
                                        + "\"currencyCode\":\"MVR\"},{\"displayName\":\"Maltese Lira\",\"currencyCode\":\"MTL\"},{\"displayName\":\"Mauritanian"
                                        + " Ouguiya\",\"currencyCode\":\"MRU\"},{\"displayName\":\"Mauritanian Ouguiya (1973–2017)\",\"currencyCode\":\"MRO"
                                        + "\"},{\"displayName\":\"Mauritian Rupee\",\"currencyCode\":\"MUR\"},{\"displayName\":\"Mexican Investment"
                                        + " Unit\",\"currencyCode\":\"MXV\"},{\"displayName\":\"Mexican Peso\",\"currencyCode\":\"MXN\"},{\"displayName\":\"Moldovan"
                                        + " Leu\",\"currencyCode\":\"MDL\"},{\"displayName\":\"Mongolian Tugrik\",\"currencyCode\":\"MNT\"},{\"displayName\":\"Moroccan"
                                        + " Dirham\",\"currencyCode\":\"MAD\"},{\"displayName\":\"Mozambican Metical\",\"currencyCode\":\"MZN\"},{\"displayName"
                                        + "\":\"Mozambican Metical (1980–2006)\",\"currencyCode\":\"MZM\"},{\"displayName\":\"Myanmar Kyat\",\"currencyCode"
                                        + "\":\"MMK\"},{\"displayName\":\"Namibian Dollar\",\"currencyCode\":\"NAD\"},{\"displayName\":\"Nepalese Rupee\","
                                        + "\"currencyCode\":\"NPR\"},{\"displayName\":\"Netherlands Antillean Guilder\",\"currencyCode\":\"ANG\"},{\"displayName"
                                        + "\":\"New Taiwan Dollar\",\"currencyCode\":\"TWD\"},{\"displayName\":\"New Zealand Dollar\",\"currencyCode\":\"NZD\""
                                        + "},{\"displayName\":\"Nicaraguan Córdoba\",\"currencyCode\":\"NIO\"},{\"displayName\":\"Nigerian Naira\",\"currencyCode"
                                        + "\":\"NGN\"},{\"displayName\":\"North Korean Won\",\"currencyCode\":\"KPW\"},{\"displayName\":\"Norwegian Krone\","
                                        + "\"currencyCode\":\"NOK\"},{\"displayName\":\"Omani Rial\",\"currencyCode\":\"OMR\"},{\"displayName\":\"Pakistani"
                                        + " Rupee\",\"currencyCode\":\"PKR\"},{\"displayName\":\"Palladium\",\"currencyCode\":\"XPD\"},{\"displayName\":\"Panamanian"
                                        + " Balboa\",\"currencyCode\":\"PAB\"},{\"displayName\":\"Papua New Guinean Kina\",\"currencyCode\":\"PGK\"},{\"displayName"
                                        + "\":\"Paraguayan Guarani\",\"currencyCode\":\"PYG\"},{\"displayName\":\"Peruvian Sol\",\"currencyCode\":\"PEN\"},{"
                                        + "\"displayName\":\"Philippine Piso\",\"currencyCode\":\"PHP\"},{\"displayName\":\"Platinum\",\"currencyCode\":\"XPT\""
                                        + "},{\"displayName\":\"Polish Zloty\",\"currencyCode\":\"PLN\"},{\"displayName\":\"Portuguese Escudo\",\"currencyCode"
                                        + "\":\"PTE\"},{\"displayName\":\"Qatari Rial\",\"currencyCode\":\"QAR\"},{\"displayName\":\"Romanian Leu\",\"currencyCode"
                                        + "\":\"RON\"},{\"displayName\":\"Romanian Leu (1952–2006)\",\"currencyCode\":\"ROL\"},{\"displayName\":\"Russian"
                                        + " Rouble\",\"currencyCode\":\"RUB\"},{\"displayName\":\"Russian Rouble (1991–1998)\",\"currencyCode\":\"RUR\"},{"
                                        + "\"displayName\":\"Rwandan Franc\",\"currencyCode\":\"RWF\"},{\"displayName\":\"Salvadoran Colón\",\"currencyCode\""
                                        + ":\"SVC\"},{\"displayName\":\"Samoan Tala\",\"currencyCode\":\"WST\"},{\"displayName\":\"Saudi Riyal\",\"currencyCode"
                                        + "\":\"SAR\"},{\"displayName\":\"Serbian Dinar\",\"currencyCode\":\"RSD\"},{\"displayName\":\"Serbian Dinar"
                                        + " (2002–2006)\",\"currencyCode\":\"CSD\"},{\"displayName\":\"Seychellois Rupee\",\"currencyCode\":\"SCR\"},{\"displayName"
                                        + "\":\"Sierra Leonean Leone\",\"currencyCode\":\"SLL\"},{\"displayName\":\"Silver\",\"currencyCode\":\"XAG\"},{\"displayName"
                                        + "\":\"Singapore Dollar\",\"currencyCode\":\"SGD\"},{\"displayName\":\"Slovak Koruna\",\"currencyCode\":\"SKK\"},{"
                                        + "\"displayName\":\"Slovenian Tolar\",\"currencyCode\":\"SIT\"},{\"displayName\":\"Solomon Islands Dollar\","
                                        + "\"currencyCode\":\"SBD\"},{\"displayName\":\"Somali Shilling\",\"currencyCode\":\"SOS\"},{\"displayName\":\"South"
                                        + " African Rand\",\"currencyCode\":\"ZAR\"},{\"displayName\":\"South Korean Won\",\"currencyCode\":\"KRW\"},{\"displayName"
                                        + "\":\"South Sudanese Pound\",\"currencyCode\":\"SSP\"},{\"displayName\":\"Spanish Peseta\",\"currencyCode\":\"ESP\"}"
                                        + ",{\"displayName\":\"Special Drawing Rights\",\"currencyCode\":\"XDR\"},{\"displayName\":\"Sri Lankan Rupee\","
                                        + "\"currencyCode\":\"LKR\"},{\"displayName\":\"St. Helena Pound\",\"currencyCode\":\"SHP\"},{\"displayName\":\"Sucre\""
                                        + ",\"currencyCode\":\"XSU\"},{\"displayName\":\"Sudanese Dinar (1992–2007)\",\"currencyCode\":\"SDD\"},{\"displayName"
                                        + "\":\"Sudanese Pound\",\"currencyCode\":\"SDG\"},{\"displayName\":\"Surinamese Dollar\",\"currencyCode\":\"SRD\"},{"
                                        + "\"displayName\":\"Surinamese Guilder\",\"currencyCode\":\"SRG\"},{\"displayName\":\"Swazi Lilangeni\",\"currencyCode"
                                        + "\":\"SZL\"},{\"displayName\":\"Swedish Krona\",\"currencyCode\":\"SEK\"},{\"displayName\":\"Swiss Franc\",\"currencyCode"
                                        + "\":\"CHF\"},{\"displayName\":\"Syrian Pound\",\"currencyCode\":\"SYP\"},{\"displayName\":\"São Tomé & Príncipe"
                                        + " Dobra\",\"currencyCode\":\"STN\"},{\"displayName\":\"São Tomé & Príncipe Dobra (1977–2017)\",\"currencyCode\":"
                                        + "\"STD\"},{\"displayName\":\"Tajikistani Somoni\",\"currencyCode\":\"TJS\"},{\"displayName\":\"Tanzanian Shilling\""
                                        + ",\"currencyCode\":\"TZS\"},{\"displayName\":\"Testing Currency Code\",\"currencyCode\":\"XTS\"},{\"displayName\":\"Thai"
                                        + " Baht\",\"currencyCode\":\"THB\"},{\"displayName\":\"Timorese Escudo\",\"currencyCode\":\"TPE\"},{\"displayName\":\"Tongan"
                                        + " Paʻanga\",\"currencyCode\":\"TOP\"},{\"displayName\":\"Trinidad & Tobago Dollar\",\"currencyCode\":\"TTD\"},{"
                                        + "\"displayName\":\"Tunisian Dinar\",\"currencyCode\":\"TND\"},{\"displayName\":\"Turkish Lira\",\"currencyCode\":\"TRY"
                                        + "\"},{\"displayName\":\"Turkish Lira (1922–2005)\",\"currencyCode\":\"TRL\"},{\"displayName\":\"Turkmenistani"
                                        + " Manat\",\"currencyCode\":\"TMT\"},{\"displayName\":\"Turkmenistani Manat (1993–2009)\",\"currencyCode\":\"TMM\"}"
                                        + ",{\"displayName\":\"US Dollar\",\"currencyCode\":\"USD\"},{\"displayName\":\"US Dollar (Next day)\",\"currencyCode"
                                        + "\":\"USN\"},{\"displayName\":\"US Dollar (Same day)\",\"currencyCode\":\"USS\"},{\"displayName\":\"Ugandan"
                                        + " Shilling\",\"currencyCode\":\"UGX\"},{\"displayName\":\"Ukrainian Hryvnia\",\"currencyCode\":\"UAH\"},{\"displayName"
                                        + "\":\"United Arab Emirates Dirham\",\"currencyCode\":\"AED\"},{\"displayName\":\"Unknown Currency\",\"currencyCode"
                                        + "\":\"XXX\"},{\"displayName\":\"Uruguayan Peso\",\"currencyCode\":\"UYU\"},{\"displayName\":\"Uruguayan Peso (Indexed"
                                        + " Units)\",\"currencyCode\":\"UYI\"},{\"displayName\":\"Uzbekistani Som\",\"currencyCode\":\"UZS\"},{\"displayName\":\"Vanuatu"
                                        + " Vatu\",\"currencyCode\":\"VUV\"},{\"displayName\":\"Venezuelan Bolívar\",\"currencyCode\":\"VEF\"},{\"displayName"
                                        + "\":\"Venezuelan Bolívar (1871–2008)\",\"currencyCode\":\"VEB\"},{\"displayName\":\"Venezuelan Bolívar"
                                        + " Soberano\",\"currencyCode\":\"VES\"},{\"displayName\":\"Vietnamese Dong\",\"currencyCode\":\"VND\"},{\"displayName\":\"WIR"
                                        + " Euro\",\"currencyCode\":\"CHE\"},{\"displayName\":\"WIR Franc\",\"currencyCode\":\"CHW\"},{\"displayName\":\"West"
                                        + " African CFA Franc\",\"currencyCode\":\"XOF\"},{\"displayName\":\"Yemeni Rial\",\"currencyCode\":\"YER\"},{\"displayName"
                                        + "\":\"Yugoslavian New Dinar (1994–2002)\",\"currencyCode\":\"YUM\"},{\"displayName\":\"ZWN\",\"currencyCode\":\"ZWN"
                                        + "\"},{\"displayName\":\"Zambian Kwacha\",\"currencyCode\":\"ZMW\"},{\"displayName\":\"Zambian Kwacha (1968–2012)\""
                                        + ",\"currencyCode\":\"ZMK\"},{\"displayName\":\"Zimbabwean Dollar (1980–2008)\",\"currencyCode\":\"ZWD\"},{\"displayName"
                                        + "\":\"Zimbabwean Dollar (2008)\",\"currencyCode\":\"ZWR\"},{\"displayName\":\"Zimbabwean Dollar (2009)\",\"currencyCode"
                                        + "\":\"ZWL\"}]"));
    }

    @Test
    public void testGetAllCurrencies2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/service/currencies", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.currenciesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"displayName\":\"ADB Unit of Account\",\"currencyCode\":\"XUA\"},{\"displayName\":\"AYM\",\"currencyCode\":\"AYM"
                                        + "\"},{\"displayName\":\"Afghan Afghani\",\"currencyCode\":\"AFN\"},{\"displayName\":\"Afghan Afghani (1927–2002)\""
                                        + ",\"currencyCode\":\"AFA\"},{\"displayName\":\"Albanian Lek\",\"currencyCode\":\"ALL\"},{\"displayName\":\"Algerian"
                                        + " Dinar\",\"currencyCode\":\"DZD\"},{\"displayName\":\"Andorran Peseta\",\"currencyCode\":\"ADP\"},{\"displayName\":\"Angolan"
                                        + " Kwanza\",\"currencyCode\":\"AOA\"},{\"displayName\":\"Argentine Peso\",\"currencyCode\":\"ARS\"},{\"displayName\":\"Armenian"
                                        + " Dram\",\"currencyCode\":\"AMD\"},{\"displayName\":\"Aruban Florin\",\"currencyCode\":\"AWG\"},{\"displayName\":\"Australian"
                                        + " Dollar\",\"currencyCode\":\"AUD\"},{\"displayName\":\"Austrian Schilling\",\"currencyCode\":\"ATS\"},{\"displayName"
                                        + "\":\"Azerbaijani Manat\",\"currencyCode\":\"AZN\"},{\"displayName\":\"Azerbaijani Manat (1993–2006)\",\"currencyCode"
                                        + "\":\"AZM\"},{\"displayName\":\"Bahamian Dollar\",\"currencyCode\":\"BSD\"},{\"displayName\":\"Bahraini Dinar\","
                                        + "\"currencyCode\":\"BHD\"},{\"displayName\":\"Bangladeshi Taka\",\"currencyCode\":\"BDT\"},{\"displayName\":\"Barbadian"
                                        + " Dollar\",\"currencyCode\":\"BBD\"},{\"displayName\":\"Belarusian New Rouble (1994–1999)\",\"currencyCode\":\"BYB"
                                        + "\"},{\"displayName\":\"Belarusian Rouble\",\"currencyCode\":\"BYN\"},{\"displayName\":\"Belarusian Rouble"
                                        + " (2000–2016)\",\"currencyCode\":\"BYR\"},{\"displayName\":\"Belgian Franc\",\"currencyCode\":\"BEF\"},{\"displayName"
                                        + "\":\"Belize Dollar\",\"currencyCode\":\"BZD\"},{\"displayName\":\"Bermudan Dollar\",\"currencyCode\":\"BMD\"},{"
                                        + "\"displayName\":\"Bhutanese Ngultrum\",\"currencyCode\":\"BTN\"},{\"displayName\":\"Bolivian Boliviano\",\"currencyCode"
                                        + "\":\"BOB\"},{\"displayName\":\"Bolivian Mvdol\",\"currencyCode\":\"BOV\"},{\"displayName\":\"Bosnia-Herzegovina"
                                        + " Convertible Mark\",\"currencyCode\":\"BAM\"},{\"displayName\":\"Botswanan Pula\",\"currencyCode\":\"BWP\"},{"
                                        + "\"displayName\":\"Brazilian Real\",\"currencyCode\":\"BRL\"},{\"displayName\":\"British Pound\",\"currencyCode\":"
                                        + "\"GBP\"},{\"displayName\":\"Brunei Dollar\",\"currencyCode\":\"BND\"},{\"displayName\":\"Bulgarian Hard Lev\","
                                        + "\"currencyCode\":\"BGL\"},{\"displayName\":\"Bulgarian Lev\",\"currencyCode\":\"BGN\"},{\"displayName\":\"Burundian"
                                        + " Franc\",\"currencyCode\":\"BIF\"},{\"displayName\":\"CFP Franc\",\"currencyCode\":\"XPF\"},{\"displayName\":\"Cambodian"
                                        + " Riel\",\"currencyCode\":\"KHR\"},{\"displayName\":\"Canadian Dollar\",\"currencyCode\":\"CAD\"},{\"displayName\":\"Cape"
                                        + " Verdean Escudo\",\"currencyCode\":\"CVE\"},{\"displayName\":\"Cayman Islands Dollar\",\"currencyCode\":\"KYD\"},"
                                        + "{\"displayName\":\"Central African CFA Franc\",\"currencyCode\":\"XAF\"},{\"displayName\":\"Chilean Peso\","
                                        + "\"currencyCode\":\"CLP\"},{\"displayName\":\"Chilean Unit of Account (UF)\",\"currencyCode\":\"CLF\"},{\"displayName"
                                        + "\":\"Chinese Yuan\",\"currencyCode\":\"CNY\"},{\"displayName\":\"Colombian Peso\",\"currencyCode\":\"COP\"},{\"displayName"
                                        + "\":\"Colombian Real Value Unit\",\"currencyCode\":\"COU\"},{\"displayName\":\"Comorian Franc\",\"currencyCode\":"
                                        + "\"KMF\"},{\"displayName\":\"Congolese Franc\",\"currencyCode\":\"CDF\"},{\"displayName\":\"Costa Rican Colón\","
                                        + "\"currencyCode\":\"CRC\"},{\"displayName\":\"Croatian Kuna\",\"currencyCode\":\"HRK\"},{\"displayName\":\"Cuban"
                                        + " Convertible Peso\",\"currencyCode\":\"CUC\"},{\"displayName\":\"Cuban Peso\",\"currencyCode\":\"CUP\"},{\"displayName"
                                        + "\":\"Cypriot Pound\",\"currencyCode\":\"CYP\"},{\"displayName\":\"Czech Koruna\",\"currencyCode\":\"CZK\"},{\"displayName"
                                        + "\":\"Danish Krone\",\"currencyCode\":\"DKK\"},{\"displayName\":\"Djiboutian Franc\",\"currencyCode\":\"DJF\"},{"
                                        + "\"displayName\":\"Dominican Peso\",\"currencyCode\":\"DOP\"},{\"displayName\":\"Dutch Guilder\",\"currencyCode\":"
                                        + "\"NLG\"},{\"displayName\":\"East Caribbean Dollar\",\"currencyCode\":\"XCD\"},{\"displayName\":\"Egyptian"
                                        + " Pound\",\"currencyCode\":\"EGP\"},{\"displayName\":\"Eritrean Nakfa\",\"currencyCode\":\"ERN\"},{\"displayName\":\"Estonian"
                                        + " Kroon\",\"currencyCode\":\"EEK\"},{\"displayName\":\"Ethiopian Birr\",\"currencyCode\":\"ETB\"},{\"displayName\":"
                                        + "\"Euro\",\"currencyCode\":\"EUR\"},{\"displayName\":\"European Composite Unit\",\"currencyCode\":\"XBA\"},{\"displayName"
                                        + "\":\"European Monetary Unit\",\"currencyCode\":\"XBB\"},{\"displayName\":\"European Unit of Account (XBC)\","
                                        + "\"currencyCode\":\"XBC\"},{\"displayName\":\"European Unit of Account (XBD)\",\"currencyCode\":\"XBD\"},{\"displayName"
                                        + "\":\"Falkland Islands Pound\",\"currencyCode\":\"FKP\"},{\"displayName\":\"Fijian Dollar\",\"currencyCode\":\"FJD\""
                                        + "},{\"displayName\":\"Finnish Markka\",\"currencyCode\":\"FIM\"},{\"displayName\":\"French Franc\",\"currencyCode\""
                                        + ":\"FRF\"},{\"displayName\":\"French Gold Franc\",\"currencyCode\":\"XFO\"},{\"displayName\":\"French UIC-Franc\","
                                        + "\"currencyCode\":\"XFU\"},{\"displayName\":\"Gambian Dalasi\",\"currencyCode\":\"GMD\"},{\"displayName\":\"Georgian"
                                        + " Lari\",\"currencyCode\":\"GEL\"},{\"displayName\":\"German Mark\",\"currencyCode\":\"DEM\"},{\"displayName\":\"Ghanaian"
                                        + " Cedi\",\"currencyCode\":\"GHS\"},{\"displayName\":\"Ghanaian Cedi (1979–2007)\",\"currencyCode\":\"GHC\"},{"
                                        + "\"displayName\":\"Gibraltar Pound\",\"currencyCode\":\"GIP\"},{\"displayName\":\"Gold\",\"currencyCode\":\"XAU\"},{"
                                        + "\"displayName\":\"Greek Drachma\",\"currencyCode\":\"GRD\"},{\"displayName\":\"Guatemalan Quetzal\",\"currencyCode"
                                        + "\":\"GTQ\"},{\"displayName\":\"Guinea-Bissau Peso\",\"currencyCode\":\"GWP\"},{\"displayName\":\"Guinean Franc\","
                                        + "\"currencyCode\":\"GNF\"},{\"displayName\":\"Guyanaese Dollar\",\"currencyCode\":\"GYD\"},{\"displayName\":\"Haitian"
                                        + " Gourde\",\"currencyCode\":\"HTG\"},{\"displayName\":\"Honduran Lempira\",\"currencyCode\":\"HNL\"},{\"displayName\":\"Hong"
                                        + " Kong Dollar\",\"currencyCode\":\"HKD\"},{\"displayName\":\"Hungarian Forint\",\"currencyCode\":\"HUF\"},{\"displayName"
                                        + "\":\"Icelandic Króna\",\"currencyCode\":\"ISK\"},{\"displayName\":\"Indian Rupee\",\"currencyCode\":\"INR\"},{"
                                        + "\"displayName\":\"Indonesian Rupiah\",\"currencyCode\":\"IDR\"},{\"displayName\":\"Iranian Rial\",\"currencyCode\""
                                        + ":\"IRR\"},{\"displayName\":\"Iraqi Dinar\",\"currencyCode\":\"IQD\"},{\"displayName\":\"Irish Pound\",\"currencyCode"
                                        + "\":\"IEP\"},{\"displayName\":\"Israeli New Shekel\",\"currencyCode\":\"ILS\"},{\"displayName\":\"Italian Lira\","
                                        + "\"currencyCode\":\"ITL\"},{\"displayName\":\"Jamaican Dollar\",\"currencyCode\":\"JMD\"},{\"displayName\":\"Japanese"
                                        + " Yen\",\"currencyCode\":\"JPY\"},{\"displayName\":\"Jordanian Dinar\",\"currencyCode\":\"JOD\"},{\"displayName\":"
                                        + "\"Kazakhstani Tenge\",\"currencyCode\":\"KZT\"},{\"displayName\":\"Kenyan Shilling\",\"currencyCode\":\"KES\"},{"
                                        + "\"displayName\":\"Kuwaiti Dinar\",\"currencyCode\":\"KWD\"},{\"displayName\":\"Kyrgystani Som\",\"currencyCode\":"
                                        + "\"KGS\"},{\"displayName\":\"Laotian Kip\",\"currencyCode\":\"LAK\"},{\"displayName\":\"Latvian Lats\",\"currencyCode"
                                        + "\":\"LVL\"},{\"displayName\":\"Lebanese Pound\",\"currencyCode\":\"LBP\"},{\"displayName\":\"Lesotho Loti\",\"currencyCode"
                                        + "\":\"LSL\"},{\"displayName\":\"Liberian Dollar\",\"currencyCode\":\"LRD\"},{\"displayName\":\"Libyan Dinar\","
                                        + "\"currencyCode\":\"LYD\"},{\"displayName\":\"Lithuanian Litas\",\"currencyCode\":\"LTL\"},{\"displayName\":\"Luxembourgian"
                                        + " Franc\",\"currencyCode\":\"LUF\"},{\"displayName\":\"Macanese Pataca\",\"currencyCode\":\"MOP\"},{\"displayName\":"
                                        + "\"Macedonian Denar\",\"currencyCode\":\"MKD\"},{\"displayName\":\"Malagasy Ariary\",\"currencyCode\":\"MGA\"},{"
                                        + "\"displayName\":\"Malagasy Franc\",\"currencyCode\":\"MGF\"},{\"displayName\":\"Malawian Kwacha\",\"currencyCode\""
                                        + ":\"MWK\"},{\"displayName\":\"Malaysian Ringgit\",\"currencyCode\":\"MYR\"},{\"displayName\":\"Maldivian Rufiyaa\","
                                        + "\"currencyCode\":\"MVR\"},{\"displayName\":\"Maltese Lira\",\"currencyCode\":\"MTL\"},{\"displayName\":\"Mauritanian"
                                        + " Ouguiya\",\"currencyCode\":\"MRU\"},{\"displayName\":\"Mauritanian Ouguiya (1973–2017)\",\"currencyCode\":\"MRO"
                                        + "\"},{\"displayName\":\"Mauritian Rupee\",\"currencyCode\":\"MUR\"},{\"displayName\":\"Mexican Investment"
                                        + " Unit\",\"currencyCode\":\"MXV\"},{\"displayName\":\"Mexican Peso\",\"currencyCode\":\"MXN\"},{\"displayName\":\"Moldovan"
                                        + " Leu\",\"currencyCode\":\"MDL\"},{\"displayName\":\"Mongolian Tugrik\",\"currencyCode\":\"MNT\"},{\"displayName\":\"Moroccan"
                                        + " Dirham\",\"currencyCode\":\"MAD\"},{\"displayName\":\"Mozambican Metical\",\"currencyCode\":\"MZN\"},{\"displayName"
                                        + "\":\"Mozambican Metical (1980–2006)\",\"currencyCode\":\"MZM\"},{\"displayName\":\"Myanmar Kyat\",\"currencyCode"
                                        + "\":\"MMK\"},{\"displayName\":\"Namibian Dollar\",\"currencyCode\":\"NAD\"},{\"displayName\":\"Nepalese Rupee\","
                                        + "\"currencyCode\":\"NPR\"},{\"displayName\":\"Netherlands Antillean Guilder\",\"currencyCode\":\"ANG\"},{\"displayName"
                                        + "\":\"New Taiwan Dollar\",\"currencyCode\":\"TWD\"},{\"displayName\":\"New Zealand Dollar\",\"currencyCode\":\"NZD\""
                                        + "},{\"displayName\":\"Nicaraguan Córdoba\",\"currencyCode\":\"NIO\"},{\"displayName\":\"Nigerian Naira\",\"currencyCode"
                                        + "\":\"NGN\"},{\"displayName\":\"North Korean Won\",\"currencyCode\":\"KPW\"},{\"displayName\":\"Norwegian Krone\","
                                        + "\"currencyCode\":\"NOK\"},{\"displayName\":\"Omani Rial\",\"currencyCode\":\"OMR\"},{\"displayName\":\"Pakistani"
                                        + " Rupee\",\"currencyCode\":\"PKR\"},{\"displayName\":\"Palladium\",\"currencyCode\":\"XPD\"},{\"displayName\":\"Panamanian"
                                        + " Balboa\",\"currencyCode\":\"PAB\"},{\"displayName\":\"Papua New Guinean Kina\",\"currencyCode\":\"PGK\"},{\"displayName"
                                        + "\":\"Paraguayan Guarani\",\"currencyCode\":\"PYG\"},{\"displayName\":\"Peruvian Sol\",\"currencyCode\":\"PEN\"},{"
                                        + "\"displayName\":\"Philippine Piso\",\"currencyCode\":\"PHP\"},{\"displayName\":\"Platinum\",\"currencyCode\":\"XPT\""
                                        + "},{\"displayName\":\"Polish Zloty\",\"currencyCode\":\"PLN\"},{\"displayName\":\"Portuguese Escudo\",\"currencyCode"
                                        + "\":\"PTE\"},{\"displayName\":\"Qatari Rial\",\"currencyCode\":\"QAR\"},{\"displayName\":\"Romanian Leu\",\"currencyCode"
                                        + "\":\"RON\"},{\"displayName\":\"Romanian Leu (1952–2006)\",\"currencyCode\":\"ROL\"},{\"displayName\":\"Russian"
                                        + " Rouble\",\"currencyCode\":\"RUB\"},{\"displayName\":\"Russian Rouble (1991–1998)\",\"currencyCode\":\"RUR\"},{"
                                        + "\"displayName\":\"Rwandan Franc\",\"currencyCode\":\"RWF\"},{\"displayName\":\"Salvadoran Colón\",\"currencyCode\""
                                        + ":\"SVC\"},{\"displayName\":\"Samoan Tala\",\"currencyCode\":\"WST\"},{\"displayName\":\"Saudi Riyal\",\"currencyCode"
                                        + "\":\"SAR\"},{\"displayName\":\"Serbian Dinar\",\"currencyCode\":\"RSD\"},{\"displayName\":\"Serbian Dinar"
                                        + " (2002–2006)\",\"currencyCode\":\"CSD\"},{\"displayName\":\"Seychellois Rupee\",\"currencyCode\":\"SCR\"},{\"displayName"
                                        + "\":\"Sierra Leonean Leone\",\"currencyCode\":\"SLL\"},{\"displayName\":\"Silver\",\"currencyCode\":\"XAG\"},{\"displayName"
                                        + "\":\"Singapore Dollar\",\"currencyCode\":\"SGD\"},{\"displayName\":\"Slovak Koruna\",\"currencyCode\":\"SKK\"},{"
                                        + "\"displayName\":\"Slovenian Tolar\",\"currencyCode\":\"SIT\"},{\"displayName\":\"Solomon Islands Dollar\","
                                        + "\"currencyCode\":\"SBD\"},{\"displayName\":\"Somali Shilling\",\"currencyCode\":\"SOS\"},{\"displayName\":\"South"
                                        + " African Rand\",\"currencyCode\":\"ZAR\"},{\"displayName\":\"South Korean Won\",\"currencyCode\":\"KRW\"},{\"displayName"
                                        + "\":\"South Sudanese Pound\",\"currencyCode\":\"SSP\"},{\"displayName\":\"Spanish Peseta\",\"currencyCode\":\"ESP\"}"
                                        + ",{\"displayName\":\"Special Drawing Rights\",\"currencyCode\":\"XDR\"},{\"displayName\":\"Sri Lankan Rupee\","
                                        + "\"currencyCode\":\"LKR\"},{\"displayName\":\"St. Helena Pound\",\"currencyCode\":\"SHP\"},{\"displayName\":\"Sucre\""
                                        + ",\"currencyCode\":\"XSU\"},{\"displayName\":\"Sudanese Dinar (1992–2007)\",\"currencyCode\":\"SDD\"},{\"displayName"
                                        + "\":\"Sudanese Pound\",\"currencyCode\":\"SDG\"},{\"displayName\":\"Surinamese Dollar\",\"currencyCode\":\"SRD\"},{"
                                        + "\"displayName\":\"Surinamese Guilder\",\"currencyCode\":\"SRG\"},{\"displayName\":\"Swazi Lilangeni\",\"currencyCode"
                                        + "\":\"SZL\"},{\"displayName\":\"Swedish Krona\",\"currencyCode\":\"SEK\"},{\"displayName\":\"Swiss Franc\",\"currencyCode"
                                        + "\":\"CHF\"},{\"displayName\":\"Syrian Pound\",\"currencyCode\":\"SYP\"},{\"displayName\":\"São Tomé & Príncipe"
                                        + " Dobra\",\"currencyCode\":\"STN\"},{\"displayName\":\"São Tomé & Príncipe Dobra (1977–2017)\",\"currencyCode\":"
                                        + "\"STD\"},{\"displayName\":\"Tajikistani Somoni\",\"currencyCode\":\"TJS\"},{\"displayName\":\"Tanzanian Shilling\""
                                        + ",\"currencyCode\":\"TZS\"},{\"displayName\":\"Testing Currency Code\",\"currencyCode\":\"XTS\"},{\"displayName\":\"Thai"
                                        + " Baht\",\"currencyCode\":\"THB\"},{\"displayName\":\"Timorese Escudo\",\"currencyCode\":\"TPE\"},{\"displayName\":\"Tongan"
                                        + " Paʻanga\",\"currencyCode\":\"TOP\"},{\"displayName\":\"Trinidad & Tobago Dollar\",\"currencyCode\":\"TTD\"},{"
                                        + "\"displayName\":\"Tunisian Dinar\",\"currencyCode\":\"TND\"},{\"displayName\":\"Turkish Lira\",\"currencyCode\":\"TRY"
                                        + "\"},{\"displayName\":\"Turkish Lira (1922–2005)\",\"currencyCode\":\"TRL\"},{\"displayName\":\"Turkmenistani"
                                        + " Manat\",\"currencyCode\":\"TMT\"},{\"displayName\":\"Turkmenistani Manat (1993–2009)\",\"currencyCode\":\"TMM\"}"
                                        + ",{\"displayName\":\"US Dollar\",\"currencyCode\":\"USD\"},{\"displayName\":\"US Dollar (Next day)\",\"currencyCode"
                                        + "\":\"USN\"},{\"displayName\":\"US Dollar (Same day)\",\"currencyCode\":\"USS\"},{\"displayName\":\"Ugandan"
                                        + " Shilling\",\"currencyCode\":\"UGX\"},{\"displayName\":\"Ukrainian Hryvnia\",\"currencyCode\":\"UAH\"},{\"displayName"
                                        + "\":\"United Arab Emirates Dirham\",\"currencyCode\":\"AED\"},{\"displayName\":\"Unknown Currency\",\"currencyCode"
                                        + "\":\"XXX\"},{\"displayName\":\"Uruguayan Peso\",\"currencyCode\":\"UYU\"},{\"displayName\":\"Uruguayan Peso (Indexed"
                                        + " Units)\",\"currencyCode\":\"UYI\"},{\"displayName\":\"Uzbekistani Som\",\"currencyCode\":\"UZS\"},{\"displayName\":\"Vanuatu"
                                        + " Vatu\",\"currencyCode\":\"VUV\"},{\"displayName\":\"Venezuelan Bolívar\",\"currencyCode\":\"VEF\"},{\"displayName"
                                        + "\":\"Venezuelan Bolívar (1871–2008)\",\"currencyCode\":\"VEB\"},{\"displayName\":\"Venezuelan Bolívar"
                                        + " Soberano\",\"currencyCode\":\"VES\"},{\"displayName\":\"Vietnamese Dong\",\"currencyCode\":\"VND\"},{\"displayName\":\"WIR"
                                        + " Euro\",\"currencyCode\":\"CHE\"},{\"displayName\":\"WIR Franc\",\"currencyCode\":\"CHW\"},{\"displayName\":\"West"
                                        + " African CFA Franc\",\"currencyCode\":\"XOF\"},{\"displayName\":\"Yemeni Rial\",\"currencyCode\":\"YER\"},{\"displayName"
                                        + "\":\"Yugoslavian New Dinar (1994–2002)\",\"currencyCode\":\"YUM\"},{\"displayName\":\"ZWN\",\"currencyCode\":\"ZWN"
                                        + "\"},{\"displayName\":\"Zambian Kwacha\",\"currencyCode\":\"ZMW\"},{\"displayName\":\"Zambian Kwacha (1968–2012)\""
                                        + ",\"currencyCode\":\"ZMK\"},{\"displayName\":\"Zimbabwean Dollar (1980–2008)\",\"currencyCode\":\"ZWD\"},{\"displayName"
                                        + "\":\"Zimbabwean Dollar (2008)\",\"currencyCode\":\"ZWR\"},{\"displayName\":\"Zimbabwean Dollar (2009)\",\"currencyCode"
                                        + "\":\"ZWL\"}]"));
    }
}

