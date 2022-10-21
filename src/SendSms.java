import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;

import javax.net.ssl.HttpsURLConnection;

public class SendSms {


    public  static void sendSms(String message,String number)
    {
//	System.out.println(message);
//	System.out.println(number);
        try {
            String apiKey="SRMTCbrNEa3m7uZvVzxfsGFhqgL025nKPj8ktX91BYIOAcWelyJ8kLGisNn1AKQcX9Fd5Cb2mPUfejxz";
            String sender_id ="FSTSMS";
            // Encode msg


            message= URLEncoder.encode(message,"UTF-8");
            String language =  "english";
            String route = "p";

            String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization="+apiKey+"&sender_id="+sender_id+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number+"";

            System.out.println(myUrl);

            // send request

            URL url = new URL(myUrl);

            HttpsURLConnection con =(HttpsURLConnection)url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", "Mozila/5.0");
            con.setRequestProperty("cache-control", "no-cache");

            System.out.println("Wait.....................");

            int code =con.getResponseCode();

            System.out.println("Response code: "+code);

            StringBuffer response = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while(true)
            {
                String line = br.readLine();
                if(line==null) {
                    break;
                }
                response.append(line);

            }

            System.out.println(response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    private static Reader InputStreamReader(InputStream inputStream) {
        // TODO Auto-generated method stub
        return null;
    }
    public static void main(String[] args) {
        System.out.println("Program is starting .......");
        SendSms.sendSms("this message using java code..."+new Date(0).toLocaleString(), "6260958716");
    }

}
