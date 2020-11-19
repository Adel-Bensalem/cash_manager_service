package eu.epitech.cashmanager.core.usecases;

public interface Interactor<RequestModel> {
    public void execute(RequestModel requestModel);
}
