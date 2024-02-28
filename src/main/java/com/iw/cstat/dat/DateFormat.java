package com.iw.cstat.dat;

import com.iw.cstat.Format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public final class DateFormat implements Format {

    private final String format;
    private final String date;
    private final String language;

    public DateFormat(String format, String date, String language) {
        this.format = format;
        this.date = date;
        this.language = language;
    }

    @Override
    public String text() {
        final DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(format);
        final String text = LocalDateTime.parse(date, inputFormatter).format(
                DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.forLanguageTag(language)));
        return text;
    }
}
