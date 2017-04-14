import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by wuchangli on 4/13/17.
 */
public class delayTimeGenerator {
    public static double delayTimeGenerators(double time , String valueOfDestination) {
        String month;
        String day;
        String description = "a";
        HashMap<String,Double> delayTimeHashmap = new HashMap<String,Double>();
        int timeInDouble = (int) Math.round(time/24);
        if(timeInDouble == 0){
        	timeInDouble = 1;
        }
        if(time < 31*24){
            month = "01";
            if(timeInDouble<10){
                day = "0" + Integer.toString(timeInDouble);
            }else{
                day = Integer.toString(timeInDouble);
            }
        }else if(time < 1440){
            month = "02";
            if(timeInDouble-31<10){
                day = "0" + Integer.toString(timeInDouble-31);
            }else{
                day = Integer.toString(timeInDouble-31);
            }
        }else if(time < 1440+31*24){
            month = "03";
            if(timeInDouble - 60<10){
                day = "0" + Integer.toString(timeInDouble-60);
            }else{
                day = Integer.toString(timeInDouble-60);
            }
        }else if(time < 1440+31*24+30*24){
            month = "04";
            if(timeInDouble - 91<10){
                day = "0" + Integer.toString(timeInDouble-91);
            }else{
                day = Integer.toString(timeInDouble-91);
            }
        }else if(time < 1440+31*24+30*24+31*24){
            month = "05";
            if(timeInDouble - 121<10){
                day = "0" + Integer.toString(timeInDouble-121);
            }else{
                day = Integer.toString(timeInDouble-121);
            }
        }else if(time < 1440+31*24+30*24+31*24+30*24){
            month = "06";
            if(timeInDouble - 152<10){
                day = "0" + Integer.toString(timeInDouble-152);
            }else{
                day = Integer.toString(timeInDouble-152);
            }
        }else if(time < 1440+31*24+30*24+31*24+30*24+31*24){
            month = "07";
            if(timeInDouble - 182<10){
                day = "0" + Integer.toString(timeInDouble-182);
            }else{
                day = Integer.toString(timeInDouble-182);
            }
        }else if(time < 1440+31*24+30*24+31*24+30*24+31*24+31*24){
            month = "08";
            if(timeInDouble - 213<10){
                day = "0" + Integer.toString(timeInDouble-213);
            }else{
                day = Integer.toString(timeInDouble-213);
            }
        }else if(time < 1440+31*24+30*24+31*24+30*24+31*24+31*24+30*24){
            month = "09";
            if(timeInDouble - 244<10){
                day = "0" + Integer.toString(timeInDouble-244);
            }else{
                day = Integer.toString(timeInDouble-244);
            }
        }else if(time < 1440+31*24+30*24+31*24+30*24+31*24+31*24+30*24+31*24){
            month = "10";
            if(timeInDouble - 274<10){
                day = "0" + Integer.toString(timeInDouble-274);
            }else{
                day = Integer.toString(timeInDouble-274);
            }
        }else if(time < 1440+31*24+30*24+31*24+30*24+31*24+31*24+30*24+31*24+30*24){
            month = "11";
            if(timeInDouble - 305<10){
                day = "0" + Integer.toString(timeInDouble-305);
            }else{
                day = Integer.toString(timeInDouble-305);
            }
        }else if(time < 1440+31*24+30*24+31*24+30*24+31*24+31*24+30*24+31*24+30*24+31*24){
            month = "12";
            if(timeInDouble - 335<10){
                day = "0" + Integer.toString(timeInDouble-335);
            }else{
                day = Integer.toString(timeInDouble-335);
            }
        }else{
            System.out.println("time is longer than one year");
            month="01";
            day="01";
        }
        String destination = valueOfDestination;
        try {
            String urlString = "http://api.apixu.com/v1/history.json?key=33686c607cb746879cf14314171404&q="+destination+"&dt=2016-"+month+"-"+day;
            URL url = new URL(urlString);
            InputStream is = url.openStream();
            JsonReader rdr = Json.createReader(is);
            JsonObject obj = rdr.readObject().getJsonObject("forecast");
            JsonArray objj = obj.getJsonArray("forecastday");
            JsonObject objDay = objj.getJsonObject(0).getJsonObject("day").getJsonObject("condition");
            description = objDay.getString("text");
            System.out.println(description);
            delayTimeHashmap.put("Moderate or heavy sleet showers", new Double(1));
            delayTimeHashmap.put("Thundery outbreaks in nearby", new Double(2));
            delayTimeHashmap.put("Blowing snow", new Double(3));
            delayTimeHashmap.put("Blizzard", new Double(5));
            delayTimeHashmap.put("Fog", new Double(10));
            delayTimeHashmap.put("Freezing fog", new Double(1));
            delayTimeHashmap.put("Freezing drizzle", new Double(1));
            delayTimeHashmap.put("Heavy freezing drizzle", new Double(4));
            delayTimeHashmap.put("Moderate rain", new Double(1));
            delayTimeHashmap.put("Heavy rain", new Double(3));
            delayTimeHashmap.put("Light freezing rain", new Double(1));
            delayTimeHashmap.put("Light sleet", new Double(2));
            delayTimeHashmap.put("Moderate or heavy sleet", new Double(3));
            delayTimeHashmap.put("Light snow", new Double(1));
            delayTimeHashmap.put("Patchy moderate snow", new Double(1));
            delayTimeHashmap.put("Moderate snow", new Double(2));
            delayTimeHashmap.put("Patchy heavy snow", new Double(2));
            delayTimeHashmap.put("Heavy snow", new Double(3));
            delayTimeHashmap.put("Ice pellets", new Double(1));
            delayTimeHashmap.put("Moderate or heavy rain shower", new Double(1));
            delayTimeHashmap.put("Torrential rain shower", new Double(4));
            delayTimeHashmap.put("Light sleet showers", new Double(2));
            delayTimeHashmap.put("Light snow showers", new Double(1));
            delayTimeHashmap.put("Patchy freezing drizzle nearby", new Double(2));
            delayTimeHashmap.put("Moderate or heavy snow showers", new Double(2));
            delayTimeHashmap.put("Light showers of ice pellets", new Double(2));
            delayTimeHashmap.put("Moderate or heavy showers of ice pellets", new Double(2));
            delayTimeHashmap.put("Patchy light rain in area with thunder", new Double(3));
            delayTimeHashmap.put("Moderate or heavy rain in area with thunder", new Double(4));
            delayTimeHashmap.put("Patchy light snow in area with thunder", new Double(3));
            delayTimeHashmap.put("Moderate or heavy snow in area with thunder", new Double(4));
        } catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace(System.out);
        }
        if(delayTimeHashmap.containsKey(description)) {
            return  delayTimeHashmap.get(description);
        }else{
            return 0;
        }
    }
}

