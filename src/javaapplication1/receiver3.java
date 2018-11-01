package javaapplication1;

public class receiver3 extends Protocol { 
    public static void main(String args[]) throws Exception 
   {   int frame_expected; 
        Frame r = new Frame(888); 
        Frame s = new Frame(999);  
        int event;
        frame_expected = 0; 
        while (true) 
        {   event = r.wait_for_event(); 
             if (event == frame_arrival) 
            {   r.from_physical_layer(); 
                 if (r.seq == frame_expected) 
                {   to_network_layer(r.info); 
                     frame_expected = (frame_expected + 1) % 2; 
                } 
                s.ack = 1 - frame_expected; 
                s.to_physical_layer("localhost", 777); 
             } 
			 else
			 {
			 System.out.println("timeout");
			 }
         } 
    } 
} 
