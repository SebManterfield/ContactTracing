package Controllers;

import GUI.SubmitATestScreen;
import Loaders.AgentLoginLoader;
import Loaders.SubmitATestLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SubmitATestController extends Controller {


    public void addListeners(SubmitATestScreen sts) {
        super.returnButtonListener(sts);

        sts.getSubmitBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String patientOutcome;
                if (sts.getPatientTestOutcomeBox().getSelectedIndex() == 0)
                    patientOutcome = "0";
                else
                    patientOutcome ="1";

                String patientName = sts.getPatientNameTF().getText();
                String patientPostcode = sts.getPatientPostcodeTF().getText();
                String patientTestDate = sts.getPatientTestDateTF().getText();
                String patientMobile = sts.getPatientMobileTF().getText();
                String cc1Name = sts.getCloseContact1NameTF().getText();
                String cc1Number = sts.getCloseContact1NumberTF().getText();
                String cc2Name = sts.getCloseContact2NameTF().getText();
                String cc2Number = sts.getCloseContact2NumberTF().getText();

                ArrayList<String> patientInfo = new ArrayList<>();
                patientInfo.add(patientName);
                patientInfo.add(patientTestDate);
                patientInfo.add(patientPostcode);
                patientInfo.add(patientOutcome);
                patientInfo.add(patientMobile);
                patientInfo.add(cc1Name);
                patientInfo.add(cc1Number);
                patientInfo.add(cc2Name);
                patientInfo.add(cc2Number);

                try {
                    SubmitATestLoader.submitBtnClicked(sts, patientInfo);
                } catch (Exception f) {
                    System.out.println("submitBtn method call failed (SubmitATestController) Error Message: " + f.getMessage());
                }
            }

        });

    }
}
