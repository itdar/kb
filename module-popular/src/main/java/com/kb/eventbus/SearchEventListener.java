package com.kb.eventbus;

import com.google.common.eventbus.Subscribe;

public class SearchEventListener {

//    @AllowConcurrentEvents
    @Subscribe
    public void searchEventListener(SearchEvent searchEvent) {
        System.out.println(" >> searchEventListener = " + searchEvent);

    }

//    @Subscribe
//    public void handleDeadEvent(DeadEvent deadEvent) {
//        System.out.println(" >> deadEvent = " + deadEvent);
//        eventsHandled--;
//    }

}
