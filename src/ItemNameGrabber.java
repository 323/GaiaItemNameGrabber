import java.util.*;
import java.io.*;
import java.io.UnsupportedEncodingException; 
import org.apache.commons.lang3.StringUtils;

class ItemNameGrabber
{
    public static void main(String[] args)
    {
        //Item Name Grabber
        //For Gaia Online
        //Made by 323
        //Grabs item names from the market and outputs them to a text file
        
        Scanner scan = new Scanner(System.in);
        
        int startvalue;
        int endvalue;
        int current;
        
        HTTPRequest request = new HTTPRequest(); 
        request.setURL("http://www.gaiaonline.com/");
        
        System.out.println("ING by 323");
        System.out.println("Enter Start Value:");
        startvalue = scan.nextInt();
        System.out.println("Enter End Value: (Don't make it too big!)");
        endvalue = scan.nextInt();
        System.out.println("Scanning Marketplace...");
        String source = request.get();
        
        if (source != null) { 
            //"Grab Sources" test successful
            System.out.println("GS Test Successful.");
            System.out.println("Still Scanning Market...");
        } 
        else { 
            System.out.println("Error: Couldn't grab page source! ABORTING."); 
        }
        
        current = startvalue;
        
        try {
            PrintWriter out = new PrintWriter(new FileWriter("MarketNames.txt"));
            while(current < endvalue) {
                request.setURL("http://www.gaiaonline.com/marketplace/itemdetail/" + current);
                source = request.get();
                String name = StringUtils.substringBetween(source, "<h2 id=\"vend_item_title\">", "</h2>");
                if (name != null )
                {
                    out.println(current + ": " + name);
                }
                current++;
            }
            out.close();
        }
        catch ( IOException error ) {
            System.err.println( "Error writing to output file: " + error );
        }
        
        System.out.println("Finished Scanning Marketplace!");
        System.out.println("Check MarketNames.txt for your output!");
    }
}