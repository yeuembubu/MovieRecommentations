package gradient_descent;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main2(String[] args) {
        double[] coefficients = {0.4, 0.8};
        double[][] dataset = {
                {1.0, 1.0},
                {2.0, 3.0},
                {4.0, 3.0},
                {3.0, 2.0},
                {5.0, 5.0}
        };
        double[] newcoef = coef_sgd(dataset, 0.001, 500);
        System.out.println(newcoef[0] + " " + newcoef[1]);
    }

    private static double[] coef_sgd(double[][] train, double l_rate, double n_epoch) {
        double[] coefficients = {0.0, 0.0};
        for (int e = 0; e < n_epoch; e++) {
            double sum_error = 0.0;
            for (int w = 0; w < train.length; w++) {
                double yhat = predict(train[w], coefficients);
                double error = yhat - train[w][1];
                sum_error += error * error;
                coefficients[0] = coefficients[0] = l_rate * error;
                for (int k = 0; k < (train[w].length - 1); k++) {
                    coefficients[k + 1] = coefficients[k + 1] - l_rate * error * train[w][k];
                }
            }
            System.out.println("b0 = " + coefficients[0] + " b1 = " + coefficients[1]);
            System.out.println("EPOCH " + e + " LRATE " + l_rate + " ERR " + sum_error);
        }
        return coefficients;
    }

    private static double predict(double[] row, double[] coef) {
        double yhat = coef[0];
        for (int i = 0; i < (coef.length - 1); i++) {
            yhat += coef[i + 1] * row[i];
        }
        return yhat;
    }

    public static void main(String[] args) {
        main1(args);
        // main2(args);
    }


    public static void main1(String[] args) {


        List<MovieInfor> mVote = new ArrayList<>();

        List<Friend> fList1 = new ArrayList<>();
        fList1.add(new Friend("A", 4));
        fList1.add(new Friend("B", 5));
        fList1.add(new Friend("C", 1));
        fList1.add(new Friend("D", 3));
        fList1.add(new Friend("E", 2));
        fList1.add(new Friend("F", 4));
        fList1.add(new Friend("G", 1));

        MovieInfor mInfor1 = new MovieInfor(1, fList1);
        mVote.add(mInfor1);

        List<Friend> fList2 = new ArrayList<>();
        fList2.add(new Friend("A", 3));
        fList2.add(new Friend("B", 2));
        fList2.add(new Friend("C", 4));
        fList2.add(new Friend("D", 5));
        fList2.add(new Friend("E", 3));
        fList2.add(new Friend("F", 1));
        fList2.add(new Friend("G", 4));

        MovieInfor mInfor2 = new MovieInfor(0, fList2);
        mVote.add(mInfor2);

        List<Friend> fList3 = new ArrayList<>();
        fList3.add(new Friend("A", 1));
        fList3.add(new Friend("B", 2));
        fList3.add(new Friend("C", 3));
        fList3.add(new Friend("D", 5));
        fList3.add(new Friend("E", 4));
        fList3.add(new Friend("F", 2));
        fList3.add(new Friend("G", 3));

        MovieInfor mInfor3 = new MovieInfor(0, fList3);
        mVote.add(mInfor3);

        StochasticGradientDescent sgd = new StochasticGradientDescent(mVote);

        double[] coefficients = sgd.getCoefficients();
        System.out.println("\n\n\n");

        double[] xTrain = {5, 2, 3, 1, 2, 5, 2};
        double sum = coefficients[0];
        for (int i = 0; i < coefficients.length - 1; i++) {
            sum += xTrain[i] * coefficients[i + 1];
        }
        System.out.println(Math.round(sum));

        /*
        List<MovieInfor> mVote = new ArrayList<>();

        List<Friend> fList1 = new ArrayList<>();
        fList1.add(new Friend("A", 1.0));
        MovieInfor mInfor1 = new MovieInfor(1.0, fList1);
        mVote.add(mInfor1);

        List<Friend> fList2 = new ArrayList<>();
        fList2.add(new Friend("B", 2.0));
        MovieInfor mInfor2 = new MovieInfor(3.0, fList2);
        mVote.add(mInfor2);

        List<Friend> fList3 = new ArrayList<>();
        fList3.add(new Friend("C", 4.0));
        MovieInfor mInfor3 = new MovieInfor(3.0, fList3);
        mVote.add(mInfor3);

        List<Friend> fList4 = new ArrayList<>();
        fList4.add(new Friend("D", 3.0));
        MovieInfor mInfor4 = new MovieInfor(2.0, fList4);
        mVote.add(mInfor4);

        List<Friend> fList5 = new ArrayList<>();
        fList5.add(new Friend("E", 5.0));
        MovieInfor mInfor5 = new MovieInfor(5.0, fList5);
        mVote.add(mInfor5);

        new StochasticGradientDescent(mVote); */
    }

}
