/**
 * Telephone class is used to represent a telephone number
 * Contains function to check if phone number is toll free
 *
 * @author ID#1826702 on 8/31/2017.
 * @version 1.0
 */
public class PhoneNumber {
    // variables
    private int _area;
    private int _exchange;
    private int _extension;
    private static final int LOCAL_AREA_CODE = 503;

    /**
     * Constructor with inputs of area code, exchange, and extension
     * @param area Area code of telephone number
     * @param exchange Exchange code of telephone number
     * @param extension Exchange code of telephone number
     */
    private PhoneNumber(int area, int exchange, int extension) {
        _area = area;
        _exchange = exchange;
        _extension = extension;
    } // constructor with 3 inputs passed in. (area, exchange, and extension)

    /**
     * Constructor for known or local area code, with parameters exchange
     * and extension. 2 inputs passed into constructor
     * @param exchange Exchange code of telephone number
     * @param extension Exchange code of telephone number
     */
    private PhoneNumber(int exchange, int extension) {
        this(LOCAL_AREA_CODE, exchange, extension);
    } // constructor with local area code known. Pass in only exchange extension

    /**
     * Constructor with phone number input as a string.
     * @param phoneNumber
     */
    private PhoneNumber(String phoneNumber) {
        // check whether the phone contains letters
        if(!containsOnlyDigits(phoneNumber)) {
            String phoneNumberConverted = LettersToNumbers(phoneNumber); // convert letters to numbers
            // After letters have been converted, assign to valid variable
            _area = Integer.parseInt(String.valueOf(phoneNumberConverted.
                    substring(0, 3)));
            _exchange = Integer.parseInt(String.valueOf(phoneNumberConverted.
                    substring(4, 7)));
            _extension = Integer.parseInt(String.valueOf(phoneNumberConverted.
                    substring(8,12)));
        } else { // Else statement if phone number does not contain letters
            _area = Integer.parseInt(String.valueOf(phoneNumber.
                    substring(0, 3)));
            _exchange = Integer.parseInt(String.valueOf(phoneNumber.
                    substring(4, 7)));
            _extension = Integer.parseInt(String.valueOf(phoneNumber.
                    substring(8,12)));
        }

    }

    /**
     * Method to determine if phone number is Toll free based on any
     * of these combinations 800, 866, 877, 880, 881, 882, and 888
     * @return
     */
    private boolean isTollFree() {
        String isTollFreeTest = String.valueOf(this._area); // convert to string
        // for test if toll free
        return isTollFreeTest.contains("800") || isTollFreeTest.contains("866")
                || isTollFreeTest.contains("877") ||
                isTollFreeTest.contains("880") || isTollFreeTest.contains("881")
                || isTollFreeTest.contains("882") ||
                isTollFreeTest.contains("888");
    }

    private boolean containsOnlyDigits(String phoneNumber) {
        String phoneNumberOnly =
                phoneNumber.replaceAll("[\\s\\-()]", "");
        for (int i = 0; i < phoneNumberOnly.length(); i++) {
            if(!Character.isDigit(phoneNumberOnly.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private String LettersToNumbers(String phoneNumberToConvert) {
        char[] data = phoneNumberToConvert.toCharArray();
        for (int i=0; i<data.length; ++i) {
            char phoneCharacter = data[i];
            phoneCharacter = Character.toLowerCase(phoneCharacter);
            switch (phoneCharacter) {
                case 'a':
                case 'b':
                case 'c':   data[i] = '2';
                    break;
                case 'd':
                case 'e':
                case 'f':   data[i] = '3';
                    break;
                case 'g':
                case 'h':
                case 'i':   data[i] = '4';
                    break;
                case 'j':
                case 'k':
                case 'l':   data[i] = '5';
                    break;
                case 'm':
                case 'n':
                case 'o':   data[i] = '6';
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':   data[i] = '7';
                    break;
                case 't':
                case 'u':
                case 'v':   data[i] = '8';
                    break;
                case 'w':
                case 'x':
                case 'y':
                case 'z':   data[i] = '9';
            }
        }
        return String.valueOf(data);
    }

    /**
     * method to 'pretty-print' the phone number as '(999) 999-9999'
     * @return formatted phone number
     */
    public String toString() {
        return String.format("(%03d) %03d-%04d", _area, _exchange, _extension);
    }

    public static void main(String[] args) {
        PhoneNumber a = new PhoneNumber(609, 258, 4455);
        PhoneNumber b = new PhoneNumber(609, 876, 5309);
        PhoneNumber c = new PhoneNumber(609, 203, 5309);
        PhoneNumber d = new PhoneNumber(215, 876, 5309);
        PhoneNumber e = new PhoneNumber(876, 5309);
        PhoneNumber f = new PhoneNumber("888-897-1234");
        PhoneNumber g = new PhoneNumber("255-get-loot");
        PhoneNumber h = new PhoneNumber("255-SOn-Beam");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(e.isTollFree());
        System.out.println(f);
        System.out.println(f.isTollFree());
        System.out.println(g);
        System.out.println(h);
    }

}
