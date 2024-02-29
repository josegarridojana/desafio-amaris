/*
 * @(#)MapperUtils.java
 *
 * Copyright (c) (Chile). All rights reserved.
 *
 * All rights to this product are owned by and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.amaris.ms.utils;

import com.amaris.ms.constants.Constants;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * MapperUtils.
 *
 * @author Jose.
 * @version 1.0.0
 */
@Slf4j
public class MapperUtils {

    /** Locale. */
    private static final Locale LOCALE = new Locale("es", "CL");

    // -------------------------------------------------------------------
    // -- Constructor ----------------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Constructor.
     */
    private MapperUtils() {
        throw new UnsupportedOperationException("Prohibido Instanciar esta clase");
    }

    // -------------------------------------------------------------------
    // -- Métodos Públicos -----------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Obtener el valor de un campo BigDecimal, devolviendo 0, si es nulo o hay un error.
     *
     * @param value String
     * @return BigDecimal del valor de entrada o 0.
     */
    public static BigDecimal safeBigDecimalValue(final String value) {
        final var result = MapperUtils.safeNumericValue(value, BigDecimal.class);
        if (null == result) {
            return BigDecimal.ZERO;
        }
        return result;
    }

    /**
     * Obtener el valor de un campo BigInteger, devolviendo 0, si es nulo o hay un error.
     *
     * @param value String
     * @return BigInteger del valor de entrada o 0.
     */
    public static BigInteger safeBigIntegerValue(final String value) {
        final var result = MapperUtils.safeNumericValue(value, BigInteger.class);
        if (null == result) {
            return BigInteger.ZERO;
        }
        return result;
    }

    /**
     * Obtener el valor de un campo double, devolviendo 0, si es nulo o hay un error.
     *
     * @param value String
     * @return Double del valor de entrada o 0.
     */
    public static Double safeDoubleValue(final String value) {
        final var result = MapperUtils.safeNumericValue(value, Double.class);
        if (null == result) {
            return 0D;
        }
        return result;
    }

    /**
     * Obtener el valor de un campo integer, devolviendo 0, si es nulo o hay un error.
     *
     * @param value String
     * @return Integer del valor de entrada o 0.
     */
    public static Integer safeIntegerValue(final String value) {
        final var result = MapperUtils.safeNumericValue(value, Integer.class);
        if (null == result) {
            return 0;
        }
        return result;
    }

    /**
     * Convierte un String en un objeto de la clase suministrada,
     * devolviendo <code>null</code>, si es nulo o hay un error.
     *
     * @param <T> Tipo Objeto
     * @param value String
     * @param clazz Clase a retornar
     * @return Conversion del valor de entrada o <code>null</code>.
     */
    public static <T> T safeNumericValue(final String value, final Class<T> clazz) {
        try {
            if (StringUtils.isNoneBlank(value)) {
                return clazz.getConstructor(String.class).newInstance(value.trim());
            }
        } catch (final Exception e) {
            MapperUtils.log.warn("safeNumericValue", e);
        }
        return null;
    }

    /**
     * Convierte Objeto a String.
     *
     * @param object {@link Object}
     * @return <code>String.valueOf();</code> sin {@link NullPointerException}
     */
    public static String safeValueOf(final Object object) {
        if (null == object) {
            return null;
        }
        return String.valueOf(object);
    }

    /**
     * formatToString.
     *
     * @param date date
     * @param pattern pattern
     * @return String
     */
    public static String formatToString(final Date date, final String pattern) {
        final var format = new SimpleDateFormat(pattern, MapperUtils.LOCALE);
        return format.format(date);
    }

    /**
     * formatToDate.
     *
     * @param date String
     * @param pattern String
     * @return Date
     * @throws ParseException ParseException
     */
    public static Date formatToDate(final String date, final String pattern) throws ParseException {
        final var format = new SimpleDateFormat(pattern, MapperUtils.LOCALE);
        return format.parse(date);
    }

    /**
     * Convierte un String en un Date según formato suministrado,
     * devolviendo <code>null</code>, si es nulo o hay un error.
     *
     * @param date {@link String}
     * @param pattern {@link String}
     * @return {@link Date}
     */
    public static Date safeFormatToDate(final String date, final String pattern) {
        try {
            if (null != date) {
                return MapperUtils.formatToDate(date, pattern);
            }
        } catch (final ParseException e) {
            MapperUtils.log.warn("safeFormatToDate", e);
        }
        return null;
    }

    /**
     * Valida un dato fecha de JAXB y lo devuelve como un Date o null
     *
     * @param date {@link XMLGregorianCalendar}
     * @return {@link Date}
     */
    public static Date xmlGregorianCalendarToDate(final XMLGregorianCalendar date) {
        if (date != null) {
            return date.toGregorianCalendar().getTime();
        }
        return null;
    }

    /**
     * Valida un dato fecha de JAXB y lo devuelve como un Instant o null
     *
     * @param date {@link XMLGregorianCalendar}
     * @return {@link Instant}
     */
    public static Instant xmlGregorianCalendarToInstant(final XMLGregorianCalendar date) {
        if (date != null) {
            return date.toGregorianCalendar().getTime().toInstant();
        }
        return null;
    }

    /**
     * Valida un dato fecha de JAXB y lo devuelve como un Long o null
     *
     * @param date {@link XMLGregorianCalendar}
     * @return {@link Long}
     */
    public static Long xmlGregorianCalendarToLong(final XMLGregorianCalendar date) {
        if (date != null) {
            return date.toGregorianCalendar().getTime().toInstant().toEpochMilli();
        }
        return null;
    }

    /**
     * Valida un dato date y lo devuelve como un XMLGregorianCalendar.
     *
     * @param date {@link Date}
     * @param format {@link String}
     * @return {@link XMLGregorianCalendar}
     */
    public static XMLGregorianCalendar dateToXmlGregorianCalendar(final Date date, final String format) {
        try {
            if (date != null) {
                final var dateFormat = new SimpleDateFormat(format, MapperUtils.LOCALE);
                return DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFormat.format(date));
            }
        } catch (final Exception e) {
            MapperUtils.log.warn("dateToXmlGregorianCalendar", e);
        }
        return null;
    }

    /**
     * Valida un dato date y lo devuelve como un XMLGregorianCalendar.
     *
     * @param date Date
     * @return XMLGregorianCalendar
     */
    public static XMLGregorianCalendar dateToXmlGregorianCalendar(final Date date) {
        try {
            final var gc = new GregorianCalendar();
            gc.setTime(date);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (final Exception e) {
            MapperUtils.log.warn("dateToXmlGregorianCalendar", e);
            return null;
        }
    }

    /**
     * Convierte de {@link LocalDate} a {@link Date}
     *
     * @param local {@link LocalDate}
     * @return {@link Date}
     */
    public static Date localDateToDate(final LocalDate local) {
        if (null != local) {
            return Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
        return null;
    }

    /**
     * Convierte de {@link Date} a {@link LocalDate}
     *
     * @param date {@link Date}
     * @return {@link LocalDate}
     */
    public static LocalDate dateToLocalDate(final Date date) {
        if (null != date) {
            return LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
        }
        return null;
    }

    /**
     * Da formato de decimales.
     *
     * @param toFormat {@link BigDecimal}
     * @param minimum {@link Integer}
     * @param maximum {@link Integer}
     * @return {@link BigDecimal}
     */
    public static BigDecimal toDecimalFormat(final BigDecimal toFormat, final int minimum, final int maximum) {
        var result = toFormat;
        try {
            final var df = (DecimalFormat) NumberFormat.getNumberInstance(Constants.LOCALE);
            df.setParseBigDecimal(true);
            df.setMinimumFractionDigits(minimum);
            df.setMaximumFractionDigits(maximum);
            final var value = df.format(toFormat);
            result = (BigDecimal) df.parse(value);
        } catch (final Exception e) {
            MapperUtils.log.warn("Error Formatear Decimal.", e);
        }
        return result;
    }

}
