package wu.linkai;

import java.util.*;
import java.io.*;

class Cemetery {
    private TreeMap<Date, HashSet<Tombstone>> tombstones;

    public Cemetery() {
        tombstones = new TreeMap<Date, HashSet<Tombstone>>();
    }
    public void parseData(String pathName) {
        // reads data and adds to treemap
        try {
            File file = new File(pathName);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();

                String name = line.substring(0,25).trim();
                String rawBurialDate = line.substring(25,36).trim();
                String rawDeathAge = line.substring(36,42).trim();
                String address = line.substring(42).trim();

                Date burialDate = new Date(
                    rawBurialDate.split(" ")[1],
                    Integer.parseInt(rawBurialDate.split(" ")[0]),
                    Integer.parseInt(rawBurialDate.split(" ")[2])
                );

                double deathAge;
                if (rawDeathAge.endsWith("w") || rawDeathAge.endsWith("d")) {
                    deathAge = Double.parseDouble(rawDeathAge.substring(0, rawDeathAge.length()-1));
                    if (rawDeathAge.endsWith("w")) deathAge *= 7;
                    deathAge /= 365;
                } else {
                    deathAge = (int) Double.parseDouble(rawDeathAge);
                    deathAge += (Double.parseDouble(rawDeathAge)-deathAge)*100/12;
                }

                Tombstone tomb = new Tombstone(name, burialDate, deathAge, address);
                if (!tombstones.containsKey(burialDate)) {
                    tombstones.put(burialDate, new HashSet<Tombstone>() {{ add(tomb); }});
                } else {
                    HashSet<Tombstone> newSet = tombstones.get(burialDate);
                    if (newSet.contains(tomb)) {
                        newSet.add(tomb);
                        tombstones.put(burialDate, newSet);
                    }
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            e.printStackTrace();
        }
    }

    public int size() {
        int size = 0;

        Iterator<HashSet<Tombstone>> i = this.tombstones.values().iterator();
        while (i.hasNext()) {
            size += i.next().size();
        }

        return size;
    }

    public HashSet<Tombstone> query(Date date) {
        return tombstones.get(date);
    }

    public HashSet<Tombstone> query(Date date1, Date date2) {
        LinkedHashSet<Tombstone> results = new LinkedHashSet<Tombstone>();

        Iterator<Date> i = this.tombstones.keySet().iterator();
        while (i.hasNext()) {
            Date current = i.next();
            if ((current.compareTo(date1) == 1 || current.compareTo(date1) == 0)
                && (current.compareTo(date2) == -1 || current.compareTo(date2) == 0)) {
                results.addAll(this.tombstones.get(current));
            }
        }

        return results;
    }

    public HashSet allEntries() {
        LinkedHashSet<Tombstone> entries = new LinkedHashSet<Tombstone>();
        Iterator<HashSet<Tombstone>> i = this.tombstones.values().iterator();
        while (i.hasNext()) {
            entries.addAll(i.next());
        }
        return entries;
    }

    public static void printEntries(HashSet entries) {
        Iterator<Tombstone> i = entries.iterator();
        while (i.hasNext()) {
            Tombstone current = i.next();
            System.out.println("  - "+current.getName()+" "+current.getBurialDate().format()+" "+current.getDeathAge()+" "+current.getAddress());
        }
    }

}