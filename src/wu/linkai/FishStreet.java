package wu.linkai;

import java.util.*;

class FishStreet {
    public static void main(String[] args) {
        Cemetery fishSt = new Cemetery();
        fishSt.parseData("src/data.txt");

        Scanner s = new Scanner(System.in);

        System.out.println("Fish Street Cemetery Directory");
        System.out.println("(1) Lookup by date");
        System.out.println("(2) Lookup by date range");
        System.out.println("(3) All burials");
        System.out.println("(4) Burial count");
        System.out.println("(exit) Exit program");

        while (true) {
            System.out.print(">>> ");
            String option = s.nextLine();

            if (option.trim().toLowerCase().equals("exit")) break;

            switch (option.trim()) {
                case "1": {// Lookup by date
                    System.out.println("Lookup by date");
                    System.out.print("  m: ");
                    String month = s.nextLine();
                    System.out.print("  d: ");
                    String day = s.nextLine();
                    System.out.print("  y: ");
                    String year = s.nextLine();

                    Date date;
                    if (month.matches("-?\\d+(\\.\\d+)?")) {
                        date = new Date(Integer.parseInt(month), Integer.parseInt(day), Integer.parseInt(year));
                    } else {
                        date = new Date(month, Integer.parseInt(day), Integer.parseInt(year));
                    }

                    HashSet<Tombstone> results = fishSt.query(date);
                    if (results != null) {
                        System.out.println("Search results for " + date.format() + ":");
                        Cemetery.printEntries(results);
                    } else {
                        System.out.println("No entries found for " + date.format());
                    }
                    break;
                }
                case "2": {// Lookup by date range
                    System.out.println("Lookup by date range");
                    System.out.println("start date:");
                    System.out.print("  m: ");
                    String month1 = s.nextLine();
                    System.out.print("  d: ");
                    String day1 = s.nextLine();
                    System.out.print("  y: ");
                    String year1 = s.nextLine();
                    System.out.println("end date:");
                    System.out.print("  m: ");
                    String month2 = s.nextLine();
                    System.out.print("  d: ");
                    String day2 = s.nextLine();
                    System.out.print("  y: ");
                    String year2 = s.nextLine();

                    System.out.print("(optional) address: ");
                    String address = s.nextLine().trim();

                    Date date1;
                    if (month1.matches("-?\\d+(\\.\\d+)?")) {
                        date1 = new Date(Integer.parseInt(month1), Integer.parseInt(day1), Integer.parseInt(year1));
                    } else {
                        date1 = new Date(month1, Integer.parseInt(day1), Integer.parseInt(year1));
                    }

                    Date date2;
                    if (month2.matches("-?\\d+(\\.\\d+)?")) {
                        date2 = new Date(Integer.parseInt(month2), Integer.parseInt(day2), Integer.parseInt(year2));
                    } else {
                        date2 = new Date(month2, Integer.parseInt(day2), Integer.parseInt(year2));
                    }

                    HashSet<Tombstone> results = fishSt.query(date1, date2);

                    // if address is given, filter by address
                    if (!address.isEmpty()) {
                        LinkedHashSet<Tombstone> filteredResults = new LinkedHashSet<Tombstone>();
                        Iterator<Tombstone> i = results.iterator();
                        while (i.hasNext()) {
                            Tombstone current = i.next();
                            if (address.equals(current.getAddress())) filteredResults.add(current);
                        }
                        results = filteredResults;
                    }

                    if (results != null) {
                        if (!address.isEmpty()) {
                            System.out.println("Search results at " + address + " from " + date1.format() + " to " + date2.format() +  ":");
                        } else {
                            System.out.println("Search results from " + date1.format() + " to " + date2.format() +  ":");
                        }
                        Cemetery.printEntries(results);
                    } else {
                        if (!address.isEmpty()) {

                        } else {
                            System.out.println("No entries found at" + address + " from " + date1.format() + " to " + date2.format());
                        }
                    }
                    break;
                }
                case "3": {// All burials
                    System.out.println("All burials");
                    Cemetery.printEntries(fishSt.allEntries());
                    break;
                }
                case "4": {// Burial count
                    System.out.println("Burial count: " + String.valueOf(fishSt.size()));
                    break;
                }
            }

            System.out.println();
        }

        s.close();
    }
}
