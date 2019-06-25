package Container;

public class ContainerInfor {
    private String numberOfContainer;
    private int height;
    private int longSize;
    private int typeOfContainer;
    private char brokenContainer;
    private String dateToCatLaiPort;
    private char noPermission;


    public String getNumberOfContainer() {
        return numberOfContainer;
    }

    public void setNumberOfContainer(String number) {
        this.numberOfContainer = number;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLongSize() {
        return longSize;
    }

    public void setLongSize(int longSize) {
        this.longSize = longSize;
    }

    public int getTypeOfContainer() {
        return typeOfContainer;
    }

    public void setTypeOfContainer(int typeOfContainer) {
        this.typeOfContainer = typeOfContainer;
    }

    public char getBrokenContainer() {
        return brokenContainer;
    }

    public void setBrokenContainer(char brokenContainer) {
        this.brokenContainer = brokenContainer;
    }

    public String getDateToCatLaiPort(){return dateToCatLaiPort;};

    public void setDateToCatLaiPort(String dateToCatLaiPort){this.dateToCatLaiPort=dateToCatLaiPort;};

    public char getNoPermission(){return noPermission;}
    public void setNoPermission(char noPermission){this.noPermission=noPermission;}




}
