package domain;

public class StarvedStateObserver implements StateObserver{

	@Override
	public void Update(Process process) {
		process.setState(ProcessState.Starved);
	}

}
