package model_weither_api;

import model_weither_api.weither.Weither;

public class WeitherService {

    private Connection connection;
    private Formatter formatter;

    private static final String EMPTY_ERROR = "Вы не ввели город";
    private static final String CITY_ERROR = "Неверное название города";

    public WeitherService() {
        connection = new Connection();
        formatter = new Formatter();
    }

    public String getWeither(String city) {
        if (city.equals("")) {
            return EMPTY_ERROR;
        }
        try {
            String info = connection.getJson(city);
            Weither weither = formatter.parse(info);
            String answer = weither.toString();
            return answer;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return CITY_ERROR;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
