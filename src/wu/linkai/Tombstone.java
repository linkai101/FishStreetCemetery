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

    public String getName() { return name; }
    public wu.linkai.Date getBurialDate() { return burialDate; }
    public double getDeathAge() { return deathAge; }
    public String getAddress() { return address; }
}
