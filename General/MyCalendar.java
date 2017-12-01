package LeetCode.General;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    class Event
{
    int start;
    int end;
    
    public Event(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
 List<Event> events;

    public MyCalendar() {
    
        events = new ArrayList<Event>();
        
    }
    
    public boolean book(int start, int end) {
        
        if(events.size() == 0)
        {
            events.add(new Event(start,end));
            return true;
        }
        Event prev = new Event(start,end);
        for(int i=0;i<events.size();i++)
        {
            if(i== 0 && prev.end <= events.get(0).start)
            {
             events.add(0,prev);
             return true;
            }
            if(i>0 && prev.end <= events.get(i).start &&  events.get(i-1).end <= prev.start)
            {
                events.add(i,prev);
                return true;
            }
            if(i== events.size() -1 && events.get(i).end <= prev.start)
            {
                events.add(prev);
                return true;
            }
        }
            
        return false;
    }

    public static void main(String[] args) {
    	MyCalendar obj = new MyCalendar();
    	boolean param_1 = obj.book(10,20);
    	obj.book(15,25);
    	obj.book(20,30);
	}
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */