package task_1.src_code.intrfc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IsoDateConverter implements DateConverter {
    @Override
    public String convert(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_DATE);
    }
}
