package bus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BusManager {
    private List<Bus> buses;

    public BusManager() {
        this.buses = new ArrayList<>();
    }

    public boolean addBus(Bus bus) {
        boolean b = this.buses.add(bus);
        return b;
    }

    public List<Bus> getBuses() {
        return this.buses;
    }

    public boolean deleteBus(String busNumber) {
        int index = findBybusNumber(busNumber);
        if (index == -1 || buses.isEmpty()) {
            return false;
        }

        buses.remove(buses.get(index));
        save();
        return true;
    }

    public boolean modifyBus(String busNumber, Bus newBus) {
        int index = findBybusNumber(busNumber);
        if (index == -1) {
            return false;
        }
        buses.remove(buses.get(index));
        buses.add(index, newBus);
        return true;
    }

    public int findBybusNumber(String busNumber) {
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getBusNumber().equals(busNumber)) {
                return i;
            }
        }
        return -1;
    }

    public List<Bus> findByendStation(String endStation) {
        List<Bus> temp = new ArrayList<>();
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getEndStation().equals(endStation)) {
                temp.add(buses.get(i));
            }
        }
        return temp;
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\java_code\\BusManager\\busData.txt", false))) {
            oos.writeObject(buses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loading() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\java_code\\BusManager\\busData.txt"))) {
            buses = (List<Bus>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("加载成功");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}