package edu.berkeley.ischool.aep;

/**
 *understands how to convert between different quantities
 */
public class Unit {

    public enum UnitType{LENGTH, VOLUME, TEMPERATURE}

    public static Unit INCHES = new Unit(1.0/12, 0, "Inches", UnitType.LENGTH);
    public static Unit FEET = new Unit(1, 0, "Feet",UnitType.LENGTH);
    public static Unit YARDS = new Unit(3, 0, "Yards",UnitType.LENGTH);
    public static Unit MILES = new Unit(1760 * 3, 0, "Miles",UnitType.LENGTH);

    public static Unit TSP = new Unit(1, 0, "Tsp", UnitType.VOLUME);
    public static Unit TBSP = new Unit(3, 0, "Tbsp",UnitType.VOLUME);
    public static Unit OZ = new Unit(2 * 3, 0, "Oz",UnitType.VOLUME);
    public static Unit CUP = new Unit(2 * 3 * 8, 0, "Cup",UnitType.VOLUME);

    public static Unit C = new Unit(1, 0, "C", UnitType.TEMPERATURE);
    public static Unit F = new Unit((5.0/9), -32, "F",UnitType.TEMPERATURE);


    private final double conversionFactor;
    private final double shift;
    private final String name;
    private final UnitType typ;


    @Override
    public String toString() {
        return name;
    }

    public Unit(double inBaseUnits, double shifted, String name, UnitType ut) {

        this.conversionFactor = inBaseUnits;
        this.shift = shifted;
        this.name = name;
        this.typ = ut;
    }


    public double convertTo(double size, Unit otherUnit) throws RuntimeException{

        if (this.typ  != otherUnit.typ){
//            System.out.println(" you can't add a " + this.typ + " to a " + otherUnit.typ);
            throw new RuntimeException();
        }
        return ((size + shift)* conversionFactor) / otherUnit.conversionFactor;

    }
}
