package software.ulpgc.moneycalculator.pojos;

import java.util.Map;

public record CurrencySymbolsGetResponse(boolean success, Map<String, String> symbols) {
}