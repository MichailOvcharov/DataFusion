package ru.omb.exception;

public class CsvIllegalArgumentException extends BaseException {

    public CsvIllegalArgumentException(String message) {
        super(message);
    }

    public CsvIllegalArgumentException(String value, String mark, Object exception) {
        this(formatMessage(value, mark, exception));
    }

    public static String formatMessage(String value, String mark, Object exception) {
        return String.format("Неверно заданно целое значение  %s для %s, %s", value, mark, exception);
    }
}
