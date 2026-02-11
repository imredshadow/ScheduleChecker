import java.util.ArrayList;

public class CanAttend {

	//precondition: Meetings has more than null and each meeting has a start and end time
	//postcondition: If no meetings overlap, it returns true, if any meetings conflicts it returns false
	public static boolean canAttend(ArrayList<MeetingInterval> meetings) {
		//your implementation here
		if (meetings.size() <= 1) {
			return true;
		}
		for (int i = 0; i < meetings.size(); i++) {
			for (int j = i + 1; j < meetings.size(); j++) {
				MeetingInterval m1 = meetings.get(i);
                MeetingInterval m2 = meetings.get(j);
				if (m1.getStart() < m2.getEnd() && m2.getStart() < m1.getEnd()) {
                    return false;
                }
			}
		}
		return true;
	}
	public static void main(String[] args) {
		ArrayList<MeetingInterval> meet = new ArrayList<MeetingInterval>();
		for(int i =0; i<10; i++) {
			int start = (int)(Math.random()*2399);
			int end = start + ((int)(Math.random()*(2399-start)));
			meet.add(new MeetingInterval(start, end));
		}
		System.out.println(canAttend(meet) ? "There is no conflict with attending "+meet+" meetings":"Can't attend "+meet+" meetings due to conflict");
		//please include additional testing here!
	}
}
