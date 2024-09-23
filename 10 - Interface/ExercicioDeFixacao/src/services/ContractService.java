package services;

import entities.Contract;
import entities.Installment;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public void processContract(Contract contract, int months){
        double installmentValue = contract.getTotalValue() / months;
        contract.getInstallments().add(new Installment(installmentValue, ));
    }

}
