package model_weither_api.weither;

public class Weither {
    private Current current;
    private Location location;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "city='" + location.getName() + '\'' + '\n' +
                "temperature=" + current.getTemperature() + '\n' +
                "observation_time='" + current.getObservation_time() + '\'' + '\n' +
                "pressure=" + current.getPressure() + '\n' +
                "humidity=" + current.getHumidity() + '\n' +
                "lat='" + location.getLat() + '\'' + '\n' +
                "lon='" + location.getLon() + '\'';
    }
}
