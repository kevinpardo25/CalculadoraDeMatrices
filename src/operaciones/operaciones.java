/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

/**
 *
 * @author jeisonnisperuza
 */
public class operaciones {

    //Fuente de los siguientes metodos http://www.taringa.net/posts/ciencia-educacion/14534230/Algunos-Ejemplos-De-Matrices-Java.html
    public static String[][] sumarDosMatrices(String[][] a, String[][] b) {

        // En este metodo se supone que las 2 matrices tienen el mismo tamaño
        String matrizResultante[][];
        int i, j, filasA, columnasA;
        filasA = a.length;
        columnasA = a[0].length;
        Fraccion f2 = null;

        matrizResultante = new String[filasA][columnasA];

        for (i = 0; i < filasA; i++) {
            for (j = 0; j < columnasA; j++) {
                responsePOJO converter = convertToFraction(a[i][j], b[i][j], "suma");
                if (converter.getIsFraction() == true) {
                    matrizResultante[i][j] = converter.getResponse();
                } else {
                    matrizResultante[i][j] = String.valueOf(Integer.parseInt(a[i][j]) + Integer.parseInt(b[i][j]));
                }
            }
        }
        return matrizResultante;
    }

    public static String[][] restarDosMatrices(String[][] a, String[][] b) {

        // En este metodo se supone que las 2 matrices tienen el mismo tamaño
        String matrizResultante[][];
        int i, j, filasA, columnasA;

        filasA = a.length;
        columnasA = a[0].length;

        matrizResultante = new String[filasA][columnasA];

        for (i = 0; i < filasA; i++) {
            for (j = 0; j < columnasA; j++) {
                responsePOJO converter = convertToFraction(a[i][j], b[i][j], "resta");
                if (converter.getIsFraction() == true) {
                    matrizResultante[i][j] = converter.getResponse();
                } else {
                    matrizResultante[i][j] = String.valueOf(Integer.parseInt(a[i][j]) - Integer.parseInt(b[i][j]));
                }
            }
        }
        return matrizResultante;
    }

    //el siguiente metodo se saco de la siguiente URL http://javayourmind.blogspot.com/2010/11/producto-de-una-matriz-por-un-escalar.html
    public static String[][] matrizPorEscalar(String[][] a, String b) {

        String[][] matrizResultado = new String[a.length][a[0].length];
        for (int i = 0; i != a.length; i++) {
            for (int j = 0; j != a[i].length; j++) {

                responsePOJO converter = convertToFraction(a[i][j], b, "multiplica");
                if (converter.getIsFraction() == true) {
                    matrizResultado[i][j] = converter.getResponse();
                } else {
                    matrizResultado[i][j] = String.valueOf(Integer.parseInt(a[i][j]) * Integer.parseInt(b)); //simplemente se multiplica cada valor de la matriz por el valor escalar.
                }
            }
        }
        return matrizResultado;
    }

    public static String[][] multiplicarDosMatrices(String[][] a, String[][] b) {

        String sum, c[][] = new String[a.length][b[0].length];
        int iterator = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                sum = "0";
                for (int k = 0; k < a[0].length; k++) {
                    responsePOJO converter = convertToFraction(a[i][k], b[k][j], "multiplica");
                    if (converter.getIsFraction() == true) {
                        iterator++;
                        if (iterator == 1) {sum = "0/1";}
                        responsePOJO converter1 = convertToFraction(sum, converter.getResponse(), "suma");
                        sum = converter1.getResponse();
                    } else {
                        iterator++;
                        if (iterator == 1) {sum = "0";}
                        String preCalc = String.valueOf(Integer.parseInt(a[i][k]) * Integer.parseInt(b[k][j]));
                        responsePOJO converter2 = convertToFraction(sum, preCalc, "suma");
                        if (converter2.getIsFraction() == true) {
                            sum = converter2.getResponse();
                        } else {
                            sum = String.valueOf(Integer.parseInt(sum) + Integer.parseInt(preCalc));
                        }
                    }
                }
                c[i][j] = sum;
            }
        }
        return c;

    }

    // métodos Jeison Nisperuza
    private static responsePOJO convertToFraction(String a, String b, String method) {
        Fraccion f1 = new Fraccion(1, 1), f2 = new Fraccion(1, 1);
        int num1, num2, den1, den2;
        responsePOJO pojo = new responsePOJO();

        if (a.contains("/")) {
            String[] parts1 = a.split("/");
            num1 = Integer.parseInt(parts1[0].trim());
            den1 = Integer.parseInt(parts1[1].trim());
            f1 = new Fraccion(num1, den1);

            if (b.contains("/")) {
                String[] parts2 = String.valueOf(b).split("/");
                num2 = Integer.parseInt(parts2[0].trim());
                den2 = Integer.parseInt(parts2[1].trim());
                f2 = new Fraccion(num2, den2);
            } else {
                f2 = new Fraccion(Integer.parseInt(b), 1);
            }

            // respuesta fracción
            String operated = ("suma".equals(method)) ? Fraccion.sumar(f1, f2).simplificar().toString()
                    : (("resta".equals(method)) ? Fraccion.restar(f1, f2).simplificar().toString()
                    : (("multiplica".equals(method)) ? Fraccion.multiplicar(f1, f2).simplificar().toString() : ""));

            pojo.setIsFraction(true);
            pojo.setResponse(operated);

        } else if (b.contains("/")) {
            String[] parts2 = b.split("/");
            num2 = Integer.parseInt(parts2[0].trim());
            den2 = Integer.parseInt(parts2[1].trim());
            f2 = new Fraccion(num2, den2);

            if (a.contains("/")) {
                String[] parts1 = a.split("/");
                num1 = Integer.parseInt(parts1[0].trim());
                den1 = Integer.parseInt(parts1[1].trim());
                f1 = new Fraccion(num1, den1);
            } else {
                f1 = new Fraccion(Integer.parseInt(a), 1);
            }
            // respuesta fracción
            String operated = ("suma".equals(method)) ? Fraccion.sumar(f1, f2).simplificar().toString()
                    : (("resta".equals(method)) ? Fraccion.restar(f1, f2).simplificar().toString()
                    : (("multiplica".equals(method)) ? Fraccion.restar(f1, f2).simplificar().toString() : "suma"));

            pojo.setIsFraction(true);
            pojo.setResponse(operated);

        } else {
            pojo.setIsFraction(false);
            // antes era 1/1
            String defaultVal = ("suma".equals(method)) ? "0"
                    : (("resta".equals(method)) ? "0"
                    : (("multiplica".equals(method)) ? "1" : "0"));
            pojo.setResponse(defaultVal);
        }

        return pojo;
    }

}
