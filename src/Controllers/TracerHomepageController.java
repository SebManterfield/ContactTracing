package Controllers;

import GUI.TracerHomepageScreen;
import Loaders.ReviewATestLoader;
import Other.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class TracerHomepageController extends Controller{



    public void addButtonListeners(TracerHomepageScreen ts, ArrayList<Test> testArrayList, int agentID)
    {
        super.returnButtonListener(ts);


        ts.getReviewBtn1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int testID = testArrayList.get(0).getTestID();
                reviewBtnClicked(ts, testID,agentID);
            }

        });

        ts.getReviewBtn2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int testID = testArrayList.get(1).getTestID();
                reviewBtnClicked(ts, testID,agentID);
            }

        });
        ts.getReviewBtn3().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int testID = testArrayList.get(2).getTestID();
                reviewBtnClicked(ts, testID,agentID);
            }

        });
        ts.getReviewBtn4().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int testID = testArrayList.get(3).getTestID();
                reviewBtnClicked(ts, testID,agentID);
            }

        });
        ts.getReviewBtn5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int testID = testArrayList.get(4).getTestID();
                reviewBtnClicked(ts,testID,agentID);
            }

        });


    }

    public void reviewBtnClicked(TracerHomepageScreen ts, int testID, int agentID)
    {
        ts.close();
        try {
            ReviewATestLoader.loadScreen(testID,agentID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




}
