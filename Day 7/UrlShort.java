import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class URLService{
    String chars="de";
    Random random = new Random();
    Map<String, String> urlMap = new HashMap<>();

    public String generateUrl(){
        String sUrl="";
        StringBuilder sb = new StringBuilder();

        int index=0;

        for (int i = 0; i < 6; i++) {
            index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        sUrl = sb.toString();

        return sUrl;
    }
}

public class UrlShort {

    public static void main(String[] args) {
        String url = "a.com";
        String sUrl = "";

        URLService service = new URLService();

        do{
            sUrl = service.generateUrl();
            System.out.println("Created");
        }while(service.urlMap.containsValue(url));

        service.urlMap.put(url, sUrl);

        System.out.println("short.ly/"+sUrl);
    }
}
