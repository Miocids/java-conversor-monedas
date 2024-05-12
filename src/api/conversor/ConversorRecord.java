package api.conversor;

public record ConversorRecord(
        String base_code,
        String target_code,
        float conversion_rate
) {
}
