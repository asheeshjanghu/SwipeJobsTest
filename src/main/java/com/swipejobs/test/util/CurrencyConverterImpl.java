package com.swipejobs.test.util;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Service
public class CurrencyConverterImpl implements CurrencyConverter {

    @Override
    public BigDecimal getBillingRate(String billRate) {
        try {
            return parse(billRate, Locale.US);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new BigDecimal(0);
    }

    private static BigDecimal parse(final String amount, final Locale locale) throws ParseException, ParseException {
        final NumberFormat format = NumberFormat.getNumberInstance(locale);
        if (format instanceof DecimalFormat) {
            ((DecimalFormat) format).setParseBigDecimal(true);
        }
        return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
    }
}
