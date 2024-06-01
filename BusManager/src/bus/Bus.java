package bus;

import java.io.Serial;
import java.io.Serializable;

public class Bus implements Serializable {
    @Serial
    private static final long serialVersionUID = -7206801619101271507L;
    private String busNumber;
    private String departureTime;
    private String startStation;
    private String endStation;
    private String travelTime;
    private int ticketCount;

    public Bus(String busNumber, String departureTime, String startStation, String endStation, String travelTime, int ticketCount) {
        this.busNumber = busNumber;
        this.departureTime = departureTime;
        this.startStation = startStation;
        this.endStation = endStation;
        this.travelTime = travelTime;
        this.ticketCount = ticketCount;
    }

    // getters and setters
    // ...


    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber='" + busNumber + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", startStation='" + startStation + '\'' +
                ", endStation='" + endStation + '\'' +
                ", travelTime='" + travelTime + '\'' +
                ", ticketCount=" + ticketCount +
                '}';
    }
}
