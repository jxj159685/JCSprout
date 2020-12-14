package com.crossoverjie.innerclass;

import java.util.List;

public class GreenController extends Controller {
    private boolean light = false;

    class lightOn extends Event {

        protected lightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "light on";
        }
    }

    class lightOff extends Event {

        protected lightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "light off";
        }
    }


    class Restart extends Event {
        private final List<Event> eventList;

        protected Restart(long delayTime, List<Event> eventList) {
            super(delayTime);
            this.eventList = eventList;
        }

        @Override
        public void action() {
            for (Event event : eventList) {
                event.start();
                addEvent(event);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restart on";
        }
    }

    public static void main(String[] args) {
        GreenController gc = new GreenController();
        gc.addEvent(gc.new lightOff(200));
        gc.run();
    }
}
