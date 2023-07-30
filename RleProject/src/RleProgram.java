import  java.util.*;

//Create the main class
public class RleProgram {
    //Create a method to present the menu
    public static void menu() {
        System.out.println("\nRLE Menu\n--------");
        System.out.println("0. Exit");
        System.out.println("1. Load File");
        System.out.println("2. Load Test Image");
        System.out.println("3. Read RLE String");
        System.out.println("4. Read RLE Hex String");
        System.out.println("5. Read Data Hex String");
        System.out.println("6. Display Image");
        System.out.println("7. Display RLE String");
        System.out.println("8. Display Hex RLE Data");
        System.out.println("9. Display Hex Flat Data\n");
        System.out.print("Select a Menu Option: ");
    }
    //Create method to translate hexadecimal string
    public static String toHexString (byte[] data) {
        String decoded = "";

        for(int i = 0; i < data.length; i++) {
            decoded = decoded.concat(Integer.toHexString(data[i]));
        }
        return decoded;
    }

    //Create method to return number of runs of data in an image data set
    public static int countRuns(byte[] flatData) {
        int count = 1;
        int again =  1;

        //Create a loop to step through all the bytes
        for (int i = 0; i < flatData.length - 1; i++)  {
            if (flatData [i] != flatData[i + 1]) {
                count++;
                again = 1;
            }
            else {
                again++;
            }
            if (again > 15) {
                count++;
                again = 1;
            }
        }
        return count;
    }

    //Create method to return coding in Rle
    public static byte[] encodeRle(byte[] flatData) {
        byte[] encoded = new byte[countRuns(flatData) * 2];
        int ct = 1;
        int ct2 = 0;

        for (int i = 0; i < flatData.length; i++) {
                if (i != flatData.length - 1 && (flatData[i] == flatData[i + 1]) && ct < 15) {
                    ct++;
                }
            else {
                encoded[ct2] = (byte) ct;
                encoded[ct2 + 1] = flatData [i];
                ct = 1;
                ct2+=2;
            }

        }

        return encoded;
    }

    //Create method return decompressed Rle data size
    public static int getDecodedLength(byte[] rleData) {
        int x = rleData[0];
        for (int i = 2; i < rleData.length - 1; i+= 2){
            x += rleData[i];
        }
        return x;
    }

    //Create method to return decoded data set from RLE encoded data
    public static byte[] decodeRle(byte[] rleData) {
        byte[] decoded = new byte[getDecodedLength(rleData)];

        int index = 0;
            for (int i = 0; i < rleData.length; i+= 2) {

                int value = rleData[i + 1];
                int times = rleData[i];
                for (int j = 0; j < times; j++) {
                    decoded[index] =(byte) value;
                            index++;
                }
            }
        return decoded;
    }

    //Create method to translate string in hexadecimal into byte data
    public static byte[] stringToData(String dataString) {
        byte[] data = new byte[dataString.length()];
        int hex;
        for (int i = 0; i < dataString.length(); i++) {
            data[i] =(byte) Integer.parseInt(String.valueOf(dataString.charAt(i)), 16);
        }
        return data;

    }

    //Create method to translate RLE data into human-readable representation
    public static String toRleString(byte[] rleData) {

        String translated = "";

        for (int i = 0; i < rleData.length - 1; i += 2) {
                translated += rleData[i] + Integer.toHexString(rleData[i + 1]) + ":";
            }
            translated = translated.substring(0, translated.length() - 1);
        return translated;
    }

    //Create method to translate human-readable RLE into RLE byte data
    public static byte[] stringToRle(String rleString) {
        String[] cutting = rleString.split(":");
        byte[] rle = new byte[2 * cutting.length];
        char caught;
        for (int i = 0; i < cutting.length; i++) {
            rle[i * 2] = Byte.parseByte(cutting[i].substring(0, cutting[i].length() - 1));
            caught = cutting[i].charAt(cutting[i].length() - 1);
            if (caught <= '9') {
                rle[2 * i + 1] = (byte) (caught - '0');
            } else {
                rle[2 * i + 1] = (byte) (10 + (caught - 'a'));
            }
        }
        return rle;
    }

    //Create the main method
    public static void main (String[] args) {
        //Create scanner for user input and initialize variables
        Scanner input = new Scanner (System.in);
        int option;
        String rle, rleHex,rleDataHex;
        byte[] data = null;

        //Welcome the user and present the menu and ask the user to select their option
        System.out.println("Welcome to the RLE image encoder!\n");
        System.out.println("Displaying Spectrum Image:");

        //Display the spectrum
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);

        menu();
        option = input.nextInt();



        //Create a loop to only exit when the user chooses 0

        while (option != 0) {
            //Throw the user in a loop if they choose an invalid option
            while (option < 0 || option > 9) {
                System.out.println("Error! Invalid input.\n");
                menu();
                option = input.nextInt();
            }

            //Create switch cases for each option
            switch (option) {
                case 1:
                    System.out.print("Enter name of file to load: ");
                    String fileName = input.next();
                    data = ConsoleGfx.loadFile(fileName);
                    break;
                case 2:
                    data = ConsoleGfx.testImage;
                    System.out.println("Test image data loaded.");
                    break;
                case 3:
                    System.out.print("Enter an RLE string to be decoded: ");
                    rle = input.next();
                    data = decodeRle(stringToRle(rle));
                    break;
                case 4:
                    System.out.print("Enter the hex string holding RLE data: ");
                    rleHex = input.next();
                    data = decodeRle(stringToData(rleHex));
                    break;
                case 5:
                    System.out.print("Enter the hex string holding flat data: ");
                    rleDataHex = input.next();
                    data = stringToData(rleDataHex);
                    break;
                case 6:
                    System.out.println("Displaying image...");
                    ConsoleGfx.displayImage(data);
                    break;
                case 7:
                    System.out.println("RLE representation: " +
                    toRleString(encodeRle(data)));
                    break;
                case 8:
                    System.out.print("RLE hex values: " +
                    toHexString(encodeRle(data)));
                    break;
                case 9:
                    System.out.print("Flat hex values: " +
                    toHexString(data));
                    break;
            }
            menu();
            option = input.nextInt();
        }

    }
}
