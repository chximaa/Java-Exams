public abstract class Wagon {
    private String code;
    private String description;

    public Wagon(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() { return code; }
    public String getDescription() { return description; }

    public void setCode(String code) { this.code = code; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Code=" + code + ", Description=" + description;
    }
}
