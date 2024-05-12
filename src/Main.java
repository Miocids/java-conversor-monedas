import api.conversor.ConversorApi;
import api.conversor.ConversorClass;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner typing = new Scanner(System.in);
            String message = """
                    **************************************************
                    Sea bienvenido al conversor de moneda.
                    
                    Seleccione una opción válida:
                    
                    1) Dólar --> Peso argentino
                    2) Peso argentino --> Dólar
                    3) Dólar --> Real brasileño
                    4) Real brasileño --> Dólar
                    5) Dólar --> Peso colombiano
                    6) Peso colombiano --> Dólar
                    7) Salir
                    """;
            System.out.println(message);

            int optionSelected;
            while ((optionSelected = Integer.valueOf(typing.nextInt())) != 7){
                String baseCurrency = "";
                String targetCurrency = "";
                switch (optionSelected){
                    case 1:
                        baseCurrency = "USD";
                        targetCurrency = "ARS";
                        break;
                    case 2:
                        baseCurrency = "ARS";
                        targetCurrency = "USD";
                        break;
                    case 3:
                        baseCurrency = "USD";
                        targetCurrency = "BRL";
                        break;
                    case 4:
                        baseCurrency = "BRL";
                        targetCurrency = "USD";
                        break;
                    case 5:
                        baseCurrency = "USD";
                        targetCurrency = "COP";
                        break;
                    case 6:
                        baseCurrency = "COP";
                        targetCurrency = "USD";
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;

                }
                ConversorApi conversor = (new ConversorApi());
                var conversorResponse = conversor.getConversionBase(baseCurrency,targetCurrency);
                System.out.println("Ingresa el valor que desea convertir");
                var stringValue = typing.next().replace(".",",");
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

                ConversorClass conversionCurrency = new ConversorClass(format.parse(stringValue).floatValue(),conversorResponse.conversion_rate());
                float result = conversionCurrency.calculateConversion();
                System.out.println("La conversión de " + baseCurrency + " a " + targetCurrency + " es: " + result + "\n\n");
                message = """
                    **************************************************                    
                    Seleccione una opción válida:
                    
                    1) Dólar --> Peso argentino
                    2) Peso argentino --> Dólar
                    3) Dólar --> Real brasileño
                    4) Real brasileño --> Dólar
                    5) Dólar --> Peso colombiano
                    6) Peso colombiano --> Dólar
                    7) Salir
                    """;
                System.out.println(message);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}