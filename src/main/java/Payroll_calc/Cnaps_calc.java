package main.java.Payroll_calc;

public class Cnaps_calc {
    
    public static double f_calc() {
        double gain = Gain_sum.f_gain();
        double percent = Cnaps_percent.f_percent(gain);
        double range = Cnaps_range.f_range(percent);
        return range;
    }
}
