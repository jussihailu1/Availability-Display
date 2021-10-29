package android_serialport_api;

public class LedColorCodes {
    private final ColorOption colorIdentifier;
    private final int numR;
    private final int numB;
    private final int numG;

    public LedColorCodes(ColorOption colorIdentifier, int numR, int numB, int numG) {
        this.colorIdentifier = colorIdentifier;
        this.numR = numR;
        this.numB = numB;
        this.numG = numG;
    }

    public ColorOption getColorIdentifier() {
        return colorIdentifier;
    }

    public int getNumR() {
        return numR;
    }

    public int getNumB() {
        return numB;
    }

    public int getNumG() {
        return numG;
    }
}
