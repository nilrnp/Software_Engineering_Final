// Strategy Pattern
import java.util.List;
class EveningShift implements ShiftType {
    @Override
    public List<String> getShifts() {
        return List.of("4PM - 12AM");
    }
}