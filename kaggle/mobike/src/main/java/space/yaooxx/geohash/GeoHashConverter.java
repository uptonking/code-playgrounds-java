package space.yaooxx.geohash;

import java.util.HashMap;
import java.util.Map;

/**
 * The class {@link GeoHashConverter}.
 * This class is based on http://en.wikipedia.org/wiki/Geohash.
 */
public class GeoHashConverter {

    /**
     * The Constant char map BASE_32.
     */
    private static final char[] BASE_32 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b',
            'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'};

    /**
     * The Constant DECODE_MAP.
     */
    private static final Map<Character, Integer> DECODE_MAP = new HashMap<>();

    static {
        int counter = 0;
        for (final char c : BASE_32) {
            DECODE_MAP.put(c, counter++);
        }
    }

    /**
     * The precision. 默认geohash编码为12位，精度为1厘米左右
     */
    private static final int precision = 12;

    /**
     * The bits.
     */
    private static final int[] bits = {16, 8, 4, 2, 1};

    /**
     * Decode the given geohash into a latitude and longitude.
     *
     * @param geohash the geohash
     * @return the double[]
     */
    public static double[] decode(final String geohash) {
        if ((geohash == null) || geohash.isEmpty()) {
            throw new IllegalArgumentException("Argument geohash should not be null.");
        }

        boolean even = true;
        double latitudeError = 90.0;
        double longitudeError = 180.0;
        double latitude;
        double longitude;
        final double[] latitudeInterval = {-90.0, 90.0};
        final double[] longitudeInterval = {-180.0, 180.0};
        for (int i = 0; i < geohash.length(); i++) {

            final int cd = DECODE_MAP.get(geohash.charAt(i));

            for (int j = 0; j < bits.length; j++) {
                final int mask = bits[j];
                if (even) {
                    longitudeError /= 2;
                    if ((cd & mask) != 0) {
                        longitudeInterval[0] = (longitudeInterval[0] + longitudeInterval[1]) / 2D;
                    } else {
                        longitudeInterval[1] = (longitudeInterval[0] + longitudeInterval[1]) / 2D;
                    }

                } else {
                    latitudeError /= 2;

                    if ((cd & mask) != 0) {
                        latitudeInterval[0] = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
                    } else {
                        latitudeInterval[1] = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
                    }
                }

                even = !even;
            }

        }
        latitude = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
        longitude = (longitudeInterval[0] + longitudeInterval[1]) / 2D;

        return new double[]{latitude, longitude, latitudeError, longitudeError};
    }

    /**
     * Decodes the given geohash into a latitude and longitude.
     *
     * @param geohash the geohash
     * @return the double[]
     */
    public static double[] decodeAndRound(final String geohash) {
        final double[] ge = decode(geohash);
        double latitude = ge[0];
        double longitude = ge[1];
        final double latitudeError = ge[2];
        final double longitudeError = ge[3];

        final double latitudePrecision = Math.max(1, Math.round(-Math.log10(latitudeError))) - 1;
        final double longitudePrecision = Math.max(1, Math.round(-Math.log10(longitudeError))) - 1;

        latitude = getPrecision(latitude, latitudePrecision);
        longitude = getPrecision(longitude, longitudePrecision);

        return new double[]{latitude, longitude};
    }

    /**
     * Encodes the given latitude and longitude into a geohash code.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return The generated geohash from the given latitude and longitude.
     */
    public static String encode(final double latitude, final double longitude) {
        final StringBuilder geohash = new StringBuilder();
        boolean even = true;
        int bit = 0;
        int ch = 0;

        final double[] latitudeInterval = {-90.0, 90.0};
        final double[] longitudeInterval = {-180.0, 180.0};

        while (geohash.length() < precision) {
            double mid = 0.0;
            if (even) {
                mid = (longitudeInterval[0] + longitudeInterval[1]) / 2D;
                if (longitude > mid) {
                    //将指定位的值置1
                    ch |= bits[bit];

                    longitudeInterval[0] = mid;
                } else {
                    longitudeInterval[1] = mid;
                }

            } else {
                mid = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
                if (latitude > mid) {
                    ch |= bits[bit];
                    latitudeInterval[0] = mid;
                } else {
                    latitudeInterval[1] = mid;
                }
            }

            even = !even;

            if (bit < 4) {
                bit++;
            } else {
                geohash.append(BASE_32[ch]);
                bit = 0;
                ch = 0;
            }
        }

        return geohash.toString();
    }

    /**
     * Gets the longitude from the given geohash value.
     *
     * @param geohash the geohash
     * @return the longitude
     */
    public static double getLongitude(final String geohash) {
        return decodeAndRound(geohash)[1];
    }

    /**
     * Gets the precision.
     *
     * @param x         the x
     * @param precision the precision
     * @return the precision
     */
    private static double getPrecision(final double x, final double precision) {
        final double base = Math.pow(10, -precision);
        final double diff = x % base;
        return x - diff;
    }


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        ///geohash编码与还原测试
        System.out.println("原始经纬度是：53.5526394, 10.0067103");
        final String geohash = GeoHashConverter.encode(53.5526394, 10.0067103);
        System.out.println("geohash编码后是：" + geohash);
        final double[] decoded = GeoHashConverter.decode(geohash);
        System.out.println("geohash还原经纬度：" + decoded[0] + ", " + decoded[1]);

        ///边界测试与精度测试
        System.out.println("原始经纬度是：30.0, -90.0");
        System.out.println("原始经纬度是：51.4797, -0.0124");
        final String gc1 = GeoHashConverter.encode(30.0, -90.0);
        final String gc2 = GeoHashConverter.encode(51.4797, -0.0124);
        System.out.println("gc1:" + gc1);
        System.out.println("gc2:" + gc2);

        System.out.println("====decodeAndRound");
        double[] gd1 = GeoHashConverter.decodeAndRound(gc1);
        double[] gd2 = GeoHashConverter.decodeAndRound(gc2);
        System.out.println(gd1[0] + ", " + gd1[1]);
        System.out.println(gd2[0] + ", " + gd2[1]);

        System.out.println("====decode");
        gd1 = GeoHashConverter.decode(gc1);
        gd2 = GeoHashConverter.decode(gc2);
        System.out.println(gd1[0] + ", " + gd1[1]);
        System.out.println(gd2[0] + ", " + gd2[1]);

    }

}
