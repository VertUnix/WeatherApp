package ro.mta.se.lab.model;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.image.Image;
import org.json.*;

/**
 * Clasa este responsabila de conexiunea cu
 * API-ul OpenWeatherMap si de interpretarea
 * raspunsului. Va scrie informatiile meteo
 * intr-o clasa de tipul WeatherInfo si va
 * trimite controller-ului pentru afisare
 *
 * @author VertUnix
 */
public class WeatherAPI {

    private String APIKey;
    private String APIURL;
    private String jsonResponse;

    public WeatherAPI() {
        APIKey = "d92f9abae3ec563c46bb83223b00fd02";
        APIURL = "http://api.openweathermap.org/data/2.5/weather?";
    }

    /**
     * Functie responsabila cu descarcarea informatiilor meteo,
     * parsarea si memorarea lor intr-un obiect tip WeatherInfo.
     * @param cityID ID-ul orasului despre care interogam API-ul
     * @return obiect tip WeatherInfo cu datele meteo
     *         din orasul specificat prin ID
     */
    public WeatherInfo getWeatherInfo(String cityID) {
        WeatherInfo weather = new WeatherInfo();

        try {
        queryWeatherServer(cityID);
        parseJSON(weather);
        fetchIcon(weather);
        }
        catch (Exception e) {
            System.out.println(e.getMessage() + " tip clasa:" + e.getClass());
        }
        return weather;
    }

    /**
     * Functia interogheaza API-ul si scrie raspunsul intr-un membru privat al clasei
     * @param cityID ID-ul orasului despre care dorim sa aflam informatii meteo
     * @throws Exception
     */
    private void queryWeatherServer(String cityID) throws MalformedURLException, IOException {
        String URLQuery = "id=" + cityID + "&appid=" + APIKey + "&units=metric";

        URL url = new URL(APIURL + URLQuery);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer serverResponse = new StringBuffer(10000);
        String line = "";

        while((line = reader.readLine()) != null)
            serverResponse.append(line);
        reader.close();
        this.jsonResponse = serverResponse.toString();

        System.out.println(this.jsonResponse);
    }

    /**
     * Functia parseaza fisierul JSON primit de la
     * API-ul OpenWeather si scrie datele intr-un
     * obiect de tip WeatherInfo
     * @param info obiect WeatherInfo in care vor fi scrise datele din JSON
     */
    private void parseJSON(WeatherInfo info) {
        JSONObject jsonObject = new JSONObject(jsonResponse);

        // temperatura=jsonObject.getJSONObject("main").getString("temp");
        info.cityName = jsonObject.getString("name");
        info.temperature = (int) Math.round(jsonObject.getJSONObject("main").getDouble("temp"));
        info.feelsLike = (int) Math.round(jsonObject.getJSONObject("main").getDouble("feels_like"));
        info.tempMin = (int) Math.round(jsonObject.getJSONObject("main").getDouble("temp_min"));
        info.tempMax = (int) Math.round(jsonObject.getJSONObject("main").getDouble("temp_max"));
        info.pressure = (int) Math.round(jsonObject.getJSONObject("main").getDouble("pressure"));
        info.humidity = (int) Math.round(jsonObject.getJSONObject("main").getDouble("humidity"));
        info.windSpeed = (int) Math.round(jsonObject.getJSONObject("wind").getDouble("speed"));
        info.description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        info.iconCode = jsonObject.getJSONArray("weather").getJSONObject(0).getString("icon");
        //System.out.println(info.feelsLike);
    }

    /**
     * Functia descarca icon-ul asociat codului din membrul String
     * "iconCode" al variabilei tip WeatherInfo
     * @param info obiect WeatherInfo in care variabila String
     *             iconCode trebuie sa contina un cod valid pt un icon
     * @throws IOException
     */
    private void fetchIcon(WeatherInfo info) throws IOException {
        String iconCode = info.iconCode;
        URL imageURL = new URL("http://openweathermap.org/img/wn/" + iconCode + "@2x.png");

        InputStream in = new BufferedInputStream(imageURL.openStream());
        OutputStream out = new BufferedOutputStream(new FileOutputStream("src/main/java/ro/mta/se/lab/resources/" + iconCode + ".png"));

        for (int i; (i = in.read()) != -1; ) {
            out.write(i);
        }

        //System.out.println("http://openweathermap.org/img/wn/" + iconCode + "@2x.png");
        info.image = new Image("file:" + "src/main/java/ro/mta/se/lab/resources/" + iconCode + ".png");
    }


}
