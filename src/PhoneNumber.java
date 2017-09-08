/**
 * Telephone class is used to represent a telephone number
 * Contains function to check if phone number is toll free
 *
 * @author ID#1826702 on 8/31/2017.
 * @version 1.0
 */
public class PhoneNumber {
    // variables used in Phone number
    private int _area;
    private int _exchange;
    private int _extension;
    private static final int LOCAL_AREA_CODE = 503; // Constant known areaCode
    private static final int[] TOLLFREES = {800, 866, 877, 880, 881, 882, 888};

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
     * @param phoneNumber the string value of a phone number with possible
     *                    letters and numbers combinations
     */
    private PhoneNumber(String phoneNumber) {
        getPhoneNumberStringValue(phoneNumber);
        /*
        call method to decode
        string value of phone number if necessary and assign each phone
        number variable(_area, _exchange, _extension)
        */
    } // PhoneNumber constructor with String parameter

    /**
     * Method used by constructor with Sting parameter to check and convert
     * if necessary the area code, exchange, and extension to a usable
     * value.
     * @param phoneNumber the number passed in from the constructor
     */
    private void getPhoneNumberStringValue(String phoneNumber) {
        if(!containsOnlyDigits(phoneNumber)) {
            String phoneNumberConverted = LettersToNumbers(phoneNumber);
            // convert letters to numbers then assign each variable that
            // the phone number uses (_area, _exchange, _extension)
            _area = Integer.parseInt((String.valueOf(phoneNumberConverted.
                    substring(0, 3))));
            _exchange = Integer.parseInt(String.valueOf(phoneNumberConverted.
                    substring(4, 7)));
            _extension = Integer.parseInt(String.valueOf(phoneNumberConverted.
                    substring(8, 12)));
        } else {
            _area = Integer.parseInt((String.valueOf(phoneNumber.
                    substring(0, 3))));
            _exchange = Integer.parseInt(String.valueOf(phoneNumber.
                    substring(4, 7)));
            _extension = Integer.parseInt(String.valueOf(phoneNumber.
                    substring(8, 12)));
        }
    } // getPhoneNumberStringValue method

    /**
     * Method to determine if phone number is Toll free based on any
     * of these combinations 800, 866, 877, 880, 881, 882, and 888
     * @return true if is toll free matches set of toll free numbers
     */
    private boolean isTollFree() {
        boolean tollFreeCheck = false;
        int tollFreeValueToCheck = _area; // convert to string

        for(int areaCode : TOLLFREES) {
            if(areaCode == tollFreeValueToCheck) {
                tollFreeCheck = true;
            }
        }// for test if toll fre
        return tollFreeCheck;// return true iff any are toll free
    } // isTollFree method

    /**
     * Helper method to determine if phone number contains only digits
     * @param phoneNumber the phone number to check
     * @return true if phone number is only digits
     */
    private boolean containsOnlyDigits(String phoneNumber) {
        boolean containsOnlyDigits = true;
        String phoneNumberOnly =
                phoneNumber.replaceAll("[\\s\\-()]", "");
        for (int i = 0; i < phoneNumberOnly.length(); i++) {
            if(!Character.isDigit(phoneNumberOnly.charAt(i))) {
                containsOnlyDigits = false;
            }
        }
        return containsOnlyDigits;
    } // containsOnlyDigits method

    /**
     * Method to convert string formatted phone number with letters to all
     * numbers.
     * @param phoneNumberToConvert phone number with letters
     * @return A string representing phone number without letters
     */
    private String LettersToNumbers(String phoneNumberToConvert) {
        char[] phoneNumberConverted = phoneNumberToConvert.toCharArray();
        // loop through the phone number to decode from letters to numbers
        for (int i=0; i<phoneNumberConverted.length; ++i) {
            char phoneCharacter = phoneNumberConverted[i];
            phoneCharacter = Character.toLowerCase(phoneCharacter);
            // store each index value as number once looped over.
            switch (phoneCharacter) {
                case 'a':
                case 'b':
                case 'c':   phoneNumberConverted[i] = '2';
                    break;
                case 'd':
                case 'e':
                case 'f':   phoneNumberConverted[i] = '3';
                    break;
                case 'g':
                case 'h':
                case 'i':   phoneNumberConverted[i] = '4';
                    break;
                case 'j':
                case 'k':
                case 'l':   phoneNumberConverted[i] = '5';
                    break;
                case 'm':
                case 'n':
                case 'o':   phoneNumberConverted[i] = '6';
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':   phoneNumberConverted[i] = '7';
                    break;
                case 't':
                case 'u':
                case 'v':   phoneNumberConverted[i] = '8';
                    break;
                case 'w':
                case 'x':
                case 'y':
                case 'z':   phoneNumberConverted[i] = '9';
            }
        }
        return String.valueOf(phoneNumberConverted);
    } // Method to convert letters to numbers and return value

    /**
     * method to 'pretty-print' the phone number as '(999) 999-9999'
     * @return formatted phone number
     */
    public String toString() {
        return String.format("(%03d) %03d-%04d", _area, _exchange, _extension);
    } // toString overide
} // PhoneNumber class end
