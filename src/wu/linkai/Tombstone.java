package wu.linkai;

class Tombstone {
    private String name;
    private wu.linkai.Date burialDate;
    private double deathAge;
    private String address;

    public Tombstone(String name, Date burialDate, double deathAge, String address) {
        this.name = name;
        this.burialDate = burialDate;
        this.deathAge = deathAge;
        this.address = address;
    }

    public boolean equals(Tombstone other) {
        if (!name.equals(other.getName())) return false;
        if (!(burialDate.compareTo(other.getBurialDate()) == 0)) return false;
        if (!(deathAge == other.deathAge)) return false;
        if (!address.equals(other.getAddress())) return false;
        return true;
    }

    public String getName() { return name; }
    public wu.linkai.Date getBurialDate() { return burialDate; }
    public double getDeathAge() { return deathAge; }
    public String getAddress() { return address; }
}
