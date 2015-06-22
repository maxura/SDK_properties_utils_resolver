package ua.codenvy;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        //AuthApproveChecker approveChecker = new AuthApproveChecker();
        //approveChecker.createForm();
        System.out.println(new LoginChecker().getSession("mmusienko", "vfrcbv_1978"));
    }
}
