
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ConferirData {
    public static boolean isDate(String strDate) {
    	  String dateFormat = "dd/MM/uuuu";
    	  

    	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
    	    .ofPattern(dateFormat)
    	    .withResolverStyle(ResolverStyle.STRICT);
    	    
    	    LocalDate dataHoje = LocalDate.parse("01/01/2018", dateTimeFormatter);
    	    LocalDate dataMinimo= LocalDate.parse("01/01/1900", dateTimeFormatter);
    	    try {
    	        LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
    	        if(date.isAfter(dataMinimo)&&date.isBefore(dataHoje)) {
    	        return true;
    	        } else return false;
    	    } catch (DateTimeParseException e) {
    	       return false;
    	    } 
    	}
}