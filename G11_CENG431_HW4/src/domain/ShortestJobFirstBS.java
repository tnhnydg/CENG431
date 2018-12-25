package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShortestJobFirstBS implements Scheduling{

	@Override
	public List<Process> Schedule(List<Process> pList) {
		List<Process> pListScheduled = new ArrayList<Process>();
		
		for(int i=0;i<pList.size();i++) {
			pListScheduled.add(pList.get(i));
		}
		
		Collections.sort(pListScheduled, new Comparator<Process>() {
			public int compare(Process o1, Process o2) 
			{
						return Integer.compare(o1.getBurstTime(), o2.getBurstTime());
			}
		});
		
		return pListScheduled;
		
	}

}
