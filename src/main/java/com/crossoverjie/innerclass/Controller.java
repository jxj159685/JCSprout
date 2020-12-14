package com.crossoverjie.innerclass;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (eventList.size() > 0) {
            for (Event event : new ArrayList<>(eventList)) {
                System.out.println(event.toString());
                event.action();
                eventList.remove(event);
            }
        }
    }

    public List<Event> getEventList() {
        return eventList;
    }
}
