 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SendRequest {

    public void sendPostRequest(String data) {
        
        //Build parameter string
        
        try {
            
            // Send the request
            URL url = new URL("http://localhost:3000/devices.json");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            
            //write parameters
            writer.write(data);
            writer.flush();
            
            // Get the response
            StringBuffer answer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                answer.append(line);
            }
            writer.close();
            reader.close();
            
            //Output the response
            System.out.println(answer.toString());
            
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Starts the program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SendRequest().sendPostRequest("number=w");
    }
}