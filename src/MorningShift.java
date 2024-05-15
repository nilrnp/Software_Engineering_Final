// Strategy Pattern
import java.util.List;
class MorningShift implements ShiftType {
    @Override
    public List<String> getShifts() {
        return List.of("8AM - 4PM");
    }
}