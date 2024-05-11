import com.google.gson.annotations.SerializedName;
// Clase para obtener la tasa de conversión así como hacer la conversión
public class Conversion {
    @SerializedName("conversion_rate")
    private float conversion;

    public float getConversion() {
        return conversion;
    }
}
