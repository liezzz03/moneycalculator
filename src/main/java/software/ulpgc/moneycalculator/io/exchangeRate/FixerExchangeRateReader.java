package software.ulpgc.moneycalculator.io.exchangeRate;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.moneycalculator.io.FixerAPI;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class FixerExchangeRateReader implements ExchangeRateReader {
    @Override
    public String read() {
        try {
            return read(FixerAPI.getExchangeRate + FixerAPI.key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        if(response.statusCode() != 200) {
            throw new RuntimeException();
        }

        return response.body();
    }
}