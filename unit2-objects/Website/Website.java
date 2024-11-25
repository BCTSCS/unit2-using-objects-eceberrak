import java.io.*;
import java.net.*;

public class Website {


 // Put your code here
    private String domain;
    private String topLevelDomain;
    private long numUsers;
    private GeoLocation geoLocation;

//Default constructor

public Website(){
    domain="google";
    topLevelDomain="com";
    numUsers=4_300_000_000L;
    geoLocation = new GeoLocation(41.2219, 95.8608);
}

// Specify website URL
// Register a new website

public Website(String domainName, String topDomain){
    domain=domainName;
    topLevelDomain=topDomain;
    numUsers=0;
    geoLocation = new GeoLocation(0, 0);
}

// Specify website URL
// Register an old website
public Website(String domainName, String topDomain, long numPeople, GeoLocation geo){
    domain=domainName;
    topLevelDomain=topDomain;
    numUsers=numPeople;
    geoLocation=geo;
}

public GeoLocation getLocation(){
    return geoLocation;
}
 // String representation for printing
    // Do not modify this method
    public String toString()
    {
       
        String res =  "http://" + domain + "." + topLevelDomain;
       // res += " has " + numUsers + " users";
       
        return res;
    }
    // Method to fetch data
    public void fetchData(String api)
 {
        String urlString=toString()+ "/"+api;

        try {
            // Create the URL from the provided string
         
            URL url = new URL(urlString);
           
            // Open a connection to the API
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
           
            // Read the response and print each line
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            //System.out.println("Response from the API:");

            // Print each line of the response directly
            while ((inputLine = in.readLine()) != null) {
                //System.out.println(inputLine);
            }
           
            String jsonResponse = response.toString();
            double lat = extractValue(jsonResponse, "\"lat\":", ",");
            double lon = extractValue(jsonResponse, "\"lon\":", ",");
            // Update the geoLocation field with the new values
            geoLocation = new GeoLocation(lat, lon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  private double extractValue(String json, String key, String delimiter) {
        int keyIndex = json.indexOf(key);
        if (keyIndex == -1) {
            return 0.0;  // Default value if key is not found
        }
        int startIndex = keyIndex + key.length();
        int endIndex = json.indexOf(delimiter, startIndex);
        if (endIndex == -1) {
            endIndex = json.length(); // If it's the last value in the JSON, set to end of string
        }
        return Double.parseDouble(json.substring(startIndex, endIndex).trim());
    }
//never use access modifier inside methods, here every vairable is local, local variable use type only
    // Main method to test the API call
    public static void main(String[] args) {
        //Website website = new Website("randomuser", "me"); // Create an instance of Website
        // Call the instance method
       
        //Website website2= new Website();
        //System.out.println(website2);
       
        //Website website3= new Website("google", "com", 900,);
        //System.out.println(website3);
        
        Website website1 = new Website("ip-api","com");
        website1.fetchData("json");
        System.out.println(website1);
        
        Website google = new Website();
        System.out.println("My location to Google: "+google.getLocation().distanceFrom(website1.getLocation()));
        
        Website aws = new Website("Amazon","com",1_000_000L,new GeoLocation(38.9339,77.1773));
        System.out.println("Google to Amazon: "+aws.getLocation().distanceFrom(google.getLocation()));
        
        Website azure = new Website("Microsoft Azure","com",1_000_000_000L, new GeoLocation(36.6636,78.3897));
        System.out.println("Google to Microsoft: "+azure.getLocation().distanceFrom(google.getLocation()));

        Website meta = new Website("Meta","com",3_200_000_000L,new GeoLocation(44.2995,120.8346));
        System.out.println("Google to Meta: "+meta.getLocation().distanceFrom(google.getLocation()));
        System.out.println("Meta to Amazon: "+aws.getLocation().distanceFrom(meta.getLocation()));
        System.out.println("Meta to Microsoft: "+azure.getLocation().distanceFrom(meta.getLocation()));
       
    }
}
