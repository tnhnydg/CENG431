package domain;

public class BlockedStateObserver implements StateObserver{

	@Override
	public void Update(Process process) {
		process.setState(ProcessState.Blocked);
	}

}
