// Strategy Pattern
import java.util.List;
class EarlyMorningShift implements ShiftType {
    @Override
    public List<String> getShifts() {
        return List.of("12AM - 8AM");
    }
}