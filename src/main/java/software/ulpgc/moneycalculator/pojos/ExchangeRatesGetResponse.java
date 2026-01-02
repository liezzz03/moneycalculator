package software.ulpgc.moneycalculator.pojos;

import java.util.Map;

public record ExchangeRatesGetResponse(boolean success, int timestamp, String base, String date, Map<String, Double> rates) {
}