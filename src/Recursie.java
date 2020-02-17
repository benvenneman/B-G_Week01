import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Recursie {
    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if(getal <= 0) {
            throw new IllegalArgumentException("Negatief");
        } else if (getal == 1 || getal == 2) {
            return 1;
        } else {
            return fibonacci(getal - 1) + fibonacci(getal - 2);
        }
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if (getal < 0) {
            return somVanCijfers(-getal);
        } else if (getal <= 9) {
            return getal;
        } else {
            return getal % 10 + somVanCijfers(getal / 10);
        }
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
//        if (s == null) {
//            throw new IllegalArgumentException("FOUT");
//        } else if(s.trim().isEmpty()) {
//            return "";
//        } else if (s.length() == 1) {
//            return s;
//        } else {
//            return s.substring(s.length() -1) + keerOm(s.substring(0,s.length()-1));
//        }

        if (s == null) {
            throw new IllegalArgumentException("FOUT");
        } else if(s.trim().isEmpty()) {
            return "";
        } else if (s.length() == 1) {
            return s;
        } else {
            return keerOm(s.substring(1,s.length())) + s.substring(0,1);
        }
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) {
            throw new IllegalArgumentException("FOUT");
        } else if(s.trim().isEmpty()) {
            return 0;
        } else if (s.length() == 1) {
            if(s.equalsIgnoreCase("x")) {
                return 1;
            }
        } else if(s.substring(0, 1).equalsIgnoreCase("x")) {
            return 1 + countX(s.substring(1));
        } return  countX(s.substring(1));
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) {
            throw new IllegalArgumentException("FOUT");
        } else if(s.trim().isEmpty()) {
            return 0;
        } if (s.endsWith("hi")) {
            return 1 + countHi(s.substring(0, s.length() -2));
        }  else if (s.length() > 1) {
            return countHi(s.substring(0, s.length() - 1));
        }
        return 0;
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Sting is leeg");
        }
        if (s.length() == 0) {
            return "";
        }
        char x = s.charAt(0);
        if (x =='x') {
            x = 'y';
        }
        return x + changeXY(s.substring(1));
    }

    // oefening 7

    public static String changePi(String s) {
        if (s == null) {
            throw new IllegalArgumentException("FOUT");
        } else if(s.trim().isEmpty()) {
            return "";
        } if (s.startsWith("pi")) {
            return "3.14" + changePi(s.substring(2));
        }
        char x = s.charAt(0);
        return x + changePi(s.substring(1));
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal < 0) {
            throw new IllegalArgumentException("Mag niet negatief zijn.");
        }
        if (getal == 0) {
            throw new IllegalArgumentException("Mag niet 0 zijn.");
        }
        if (getal == 1) {
            return 0;
        }
        return 1 + tweelog(getal/2);
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst == null) {
            throw new IllegalArgumentException("Lijst is bestaat niet.");
        }
        if (lijst.size() == 0) {
            throw new IllegalArgumentException("Lijst mag niet leeg zijn.");
        }
        if (lijst.size() == 1) {
            return lijst.get(0);
        }
        if (lijst.get(0) < lijst.get(1)) {
            lijst.remove(0);
        } else {
            lijst.remove(1);
        }
        return findMaximum(lijst);
    }

    //oefening 10;
//    public static ArrayList<String> findSubstrings(String string) {
//        ArrayList<String> lijst = new ArrayList<>();
//        if (string == null) {
//            throw new IllegalArgumentException("String bestaat niet.");
//        }
//        if (string.trim().isEmpty()) {
//            lijst.add("");
//            return lijst;
//        }
//        if (string.length() == 1) {
//            lijst.add(string);
//            return lijst;
//        }
//        return lijst;
    public static ArrayList<String> findSubstrings(String string) {
        if (string == null)
            throw new IllegalArgumentException("String bestaat niet");
        ArrayList<String> res = new ArrayList<String>();
        if (string.length() <= 1) {
            res.add(string);
            return res;
        } else {
            res.add(string.substring(0, 1));
            ArrayList<String> res2 = findSubstrings(string.substring(1));
            res.addAll(res2);
            for (String s : res2) {
                res.add(string.charAt(0) + s);
            }
            return res;

        }
    }
}