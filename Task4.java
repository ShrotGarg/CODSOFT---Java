import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CurrencyConverter{

    public static double getExchangeRate(String base, String target){
        try {
            String api = "https://open.er-api.com/v6/latest/" + base;

            URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while((line = reader.readLine()) != null){
                response.append(line);
            }

            reader.close();

            String json = response.toString();
            String search = "\"" + target + "\":";
            int start = json.indexOf(search);

            if(start == -1){
                return -1;
            }

            start += search.length();
            int end = json.indexOf(",", start);

            String rateString = json.substring(start,end);
            return Double.parseDouble(rateString);

        }

        catch(Exception e){
            System.out.println("Error fetching exchange rate.");
            return -1;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Base Currency: ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency: ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        double rate = getExchangeRate(base,target);

        if(rate == -1){
            System.out.println("Invalid currency code or API issue.");
            sc.close();
            return;
        }

        double converted = amount * rate;
        System.out.println("\nExchange Rate: 1 " + base + " = " + rate + " " + target);
        System.out.println("Converted Amount: " + converted + " " + target);

        sc.close();
    }
}
