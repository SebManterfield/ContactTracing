package Controllers;

import GUI.ReviewATestScreen;
import GUI.SubmitATestScreen;
import Loaders.ReviewATestLoader;
import Other.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReviewATestController extends Controller {


    public ReviewATestController() {
    }

    public void addListeners(ReviewATestScreen rts, Test test, int agentID) {

        rts.getReturnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReviewATestLoader.returnBtnClicked(rts, agentID);
                }
                catch (SQLException ex) {
                    System.out.println("");
                }
            }
        });
        rts.getMarkAsReviewedBtn().addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {

                         try {
                             ReviewATestLoader.reviewBtnClicked(rts,test,agentID);
                         } catch (SQLException ex) {
                             System.out.println("");
                         }

                     }
        });
    }






}

